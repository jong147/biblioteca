/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilidades;

import java.util.Objects;

/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
//clase para cargar datos en combobox desde base de datos
public class ComboBoxCategoria {
    private int codigo;
    private String valor;

    public ComboBoxCategoria() {
    }

    public ComboBoxCategoria(int codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){return valor;}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComboBoxCategoria other = (ComboBoxCategoria) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return Objects.equals(this.valor, other.valor);
    }
    
    
}
