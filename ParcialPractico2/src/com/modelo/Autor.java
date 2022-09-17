/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
public class Autor {
    private int idAutor;
    private String nombreAutor;
    private String apellido;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(int idAutor, String nombreAutor, String apellido, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
