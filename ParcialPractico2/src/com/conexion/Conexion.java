/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    //Connection con = new Connection();
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos"+e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            if (!con.isClosed()) {
                con.close();
            }
            
        } catch (Exception e){
            System.out.print("Error al desconectar"+e.getMessage());
        }
    }
    
}
