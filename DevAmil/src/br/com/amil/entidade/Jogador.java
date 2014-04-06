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
public class Jogador {
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.nome);
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }    
}
