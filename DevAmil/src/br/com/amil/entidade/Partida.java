/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Orlando
 */
public class Partida {

    private int numero;
    private Date dtInicio;
    private Date dtFinal;
    private final Map<String, PartidaItem> itens;
    
    public Partida() {
        this.itens = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public Map<String, PartidaItem> getItens() {
        return itens;
    }
    
    public List<PartidaItem> getListaOrdernadaRanking(){
        List<PartidaItem> lista = new ArrayList<>(itens.values());
        Collections.sort(lista, Collections.reverseOrder());
        return lista;
    }
}


