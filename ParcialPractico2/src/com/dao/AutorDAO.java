/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
public class AutorDAO extends Conexion{
    
    //funcion para insertar registros
    public int insertarAutor(Autor a){
        int res = 0;
        try {
            this.conectar();
            String sql ="INSERT INTO autor (nombreAutor, apellido, nacionalidad) VALUES(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, a.getNombreAutor());
            pre.setString(2, a.getApellido());
            pre.setString(3, a.getNacionalidad());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar registro "+e.getMessage());
        }
        return res;
    }
    
    //funcion para mostar registros
    public ArrayList<Autor> mostrarAutor(){
        ArrayList<Autor> listAutores = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM autor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Autor a = new Autor();
                a.setIdAutor(rs.getInt(1));
                a.setNombreAutor(rs.getString("nombreAutor"));
                a.setApellido(rs.getString("apellido"));
                a.setNacionalidad(rs.getString("nacionalidad"));
                listAutores.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer los registros "+e.getMessage());
        }
        return listAutores;
    }
    
    //funcion para modificar registros
    public int modificarAutor(Autor a){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE autor SET nombreAutor=?, apellido=?, nacionalidad=? WHERE idAutor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, a.getNombreAutor());
            pre.setString(2, a.getApellido());
            pre.setString(3, a.getNacionalidad());
            pre.setInt(4, a.getIdAutor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        }
        return res;  
    }
    
    //funcion par eliminar registros
    public int eliminarAutor(Autor a){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM autor WHERE idAutor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, a.getIdAutor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        }
        return res;
    }
}
