/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.ranking;

import br.com.amil.entidade.Partida;
import java.util.List;

/**
 *
 * @author Orlando
 */
public interface RankingInterface {

    public void gerarRanking(List<Partida> partidas);
}
