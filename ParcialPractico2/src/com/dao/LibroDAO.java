/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
public class LibroDAO extends Conexion {
    
    //funcion para insertar productos
    public int insertarLibro(Libro li) {   
        int res=0;
        try {
            this.conectar();
            String sql = "INSERT INTO libro (titulo, descripcion, stock, stockMinimo, idCategoria, idAutor) VALUES(?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, li.getTitulo());
            pre.setString(2, li.getDescripcion());
            pre.setInt(3, li.getStock());
            pre.setInt(4, li.getStockMinimo());
            pre.setInt(5, li.getIdCategoria());
            pre.setInt(6, li.getIdAutor());
            res = pre.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Error al insertar registro"+e.getMessage());
        }
        finally {
            return res;
        }
    }
    
    //funcion para mostrar productos
    public ArrayList<Libro> mostrarLibro(){
        ArrayList<Libro> listaLibros = new ArrayList <>();
        try {
            this.conectar();
            String sql = "SELECT li.idLibro, li.titulo, li.descripcion, li.stock, "
                    + "li.stockMinimo, li.idCategoria, c.nombreCategoria, a.idAutor, "
                    + "CONCAT(a.nombreAutor, ' ', a.apellido) as nombreAutor FROM libro li INNER JOIN categoria c on li.idCategoria=c.idCategoria "
                + "INNER JOIN autor a on li.idAutor=a.idAutor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
            Libro li = new Libro();
            li.setIdLibro(rs.getInt(1));
            li.setTitulo(rs.getString("titulo"));
            li.setDescripcion(rs.getString("descripcion"));
            li.setStock(rs.getInt("stock"));
            li.setStockMinimo(rs.getInt("stockMinimo"));
            li.setIdCategoria(rs.getInt("idCategoria"));
            li.setNombreCategoria(rs.getString("nombreCategoria"));
            li.setIdAutor(rs.getInt("idAutor"));
            li.setNombreAutor(rs.getString("nombreAutor"));
            listaLibros.add(li);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al mostrar registro"+e.getMessage());
        }
        finally {
           this.desconectar();
        }
        return listaLibros;
    }
    
    public int modificarLibro(Libro li){
        int res =0;
        try {
            this.conectar();
            String sql = "UPDATE libro set titulo=?, descripcion=?, stock=?, stockMinimo=?, idCategoria=?, idAutor=? WHERE idLibro=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, li.getTitulo());
            pre.setString(2, li.getDescripcion());
            pre.setInt(3, li.getStock());
            pre.setInt(4, li.getStockMinimo());
            pre.setInt(5, li.getIdCategoria());
            pre.setInt(6, li.getIdAutor());
            pre.setInt(7, li.getIdLibro());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar registro: "+e.getMessage());
        } finally{
            this.desconectar();
        }
        return res;
    }
    
    public int eliminarLibro(Libro li){
        int res=0;
        try {
            this.conectar();
            String sql = "DELETE FROM libro WHERE idLibro=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, li.getIdLibro());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro: "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
        return res;
    }
}
