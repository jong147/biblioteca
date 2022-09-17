/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
public class CategoriaDAO extends Conexion {
    
    //funcion para insertar registros
    public int insertarCategoria(Categoria c){
        int res = 0;
        try {
            this.conectar();
            String sql ="INSERT INTO categoria (nombreCategoria, descripcion) VALUES(?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombreCategoria());
            pre.setString(2, c.getDescripcion());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar registro "+e.getMessage());
        }
        return res;
    }
    
    //funcion para mostar registros
    public ArrayList<Categoria> mostrarCategoria(){
        ArrayList<Categoria> listCategorias = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM categoria";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt(1));
                c.setNombreCategoria(rs.getString("nombreCategoria"));
                c.setDescripcion(rs.getString("descripcion"));
                listCategorias.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer los registros "+e.getMessage());
        }
        return listCategorias;
    }
    
    //funcion para modificar registros
    public int modificarCategoria(Categoria c){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE categoria SET nombreCategoria=?, descripcion=? WHERE idCategoria=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombreCategoria());
            pre.setString(2, c.getDescripcion());
            pre.setInt(3, c.getIdCategoria());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        }
        return res;  
    }
    
    //funcion par eliminar registros
    public int eliminarCategoria(Categoria c){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM categoria WHERE idCategoria=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getIdCategoria());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        }
        return res;
    }
}