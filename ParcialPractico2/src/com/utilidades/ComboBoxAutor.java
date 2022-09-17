/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilidades;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
//clase para cargar datos en combobox desde base de datos
public class ComboBoxAutor {
    private int idAutor;
    private String valor;

    public ComboBoxAutor() {
    }

    public ComboBoxAutor(int idAutor, String valor) {
        this.idAutor = idAutor;
        this.valor = valor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){return valor;}
}
