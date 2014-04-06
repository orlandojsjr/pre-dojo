/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.amil.entidade;

import java.util.Objects;

/**
 *
 * @author Orlando
 */
public class Arma {
    private String modelo;

    public Arma(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Arma{" + "modelo=" + modelo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.modelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arma other = (Arma) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
}
