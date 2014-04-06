/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.amil.ranking.factory;

import br.com.amil.enuns.TipoRanking;
import br.com.amil.ranking.RankingCSV;
import br.com.amil.ranking.RankingHTML;
import br.com.amil.ranking.RankingInterface;
import br.com.amil.ranking.RankingSaidaPadrao;

/**
 *
 * @author Orlando
 */
public class RankingFactory {
    
    public static RankingInterface criarRanking(TipoRanking tipoRanking){
        if(TipoRanking.HTML == tipoRanking){
            return new RankingHTML();
        }else if(TipoRanking.CSV == tipoRanking){
            return new RankingCSV();
        }else {
            return new RankingSaidaPadrao();
        }    
    }    
}
