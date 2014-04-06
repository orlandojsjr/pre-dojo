/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.amil.entidade;

/**
 *
 * @author Orlando
 */
public class PartidaItemHasArma implements Comparable<PartidaItemHasArma>{
    private Arma arma;
    private int qtdeAssassinato;

    public PartidaItemHasArma(Arma arma) {
        this.arma = arma;
    }
    
    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getQtdeAssassinato() {
        return qtdeAssassinato;
    }

    public void adicionarMortes() {
        qtdeAssassinato++;
    }  

    @Override
    public String toString() {
        return "PartidaItemHasArma{" + "arma=" + arma + ", qtdeAssassinato=" + qtdeAssassinato + '}';
    }

    @Override
    public int compareTo(PartidaItemHasArma o) {
        if (qtdeAssassinato < o.getQtdeAssassinato()) {
            return -1;
        } else if (qtdeAssassinato > o.getQtdeAssassinato()) {
            return 1;
        }
        return 0;    
    }
}
