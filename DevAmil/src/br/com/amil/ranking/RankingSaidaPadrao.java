/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.ranking;

import br.com.amil.entidade.Partida;
import br.com.amil.entidade.PartidaItem;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Orlando
 */
public class RankingSaidaPadrao implements RankingInterface {

    @Override
    public void gerarRanking(List<Partida> partidas) {
        try {
            for (Partida partida : partidas) {
                System.out.println("Ranking PARTIDA " + partida.getNumero() + "!");
                escreverCabecalho();
                for (PartidaItem item : partida.getListaOrdernadaRanking()) {
                    escreverLinha(item);
                }
                System.out.println("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void escreverCabecalho() throws IOException {
        System.out.println(addEspacoDireita("Jogador")
                + addEspacoDireita("Assassinatos")
                + addEspacoDireita("Mortes")
                + addEspacoDireita("Streak")
                + addEspacoDireita("Arma Preferida")
                + addEspacoDireita("Awards")
        );
    }

    private void escreverLinha(PartidaItem item) throws IOException {
        System.out.println(addEspacoDireita(item.getJogador().getNome())
                + addEspacoDireita("" + item.getQtdeAssassinato())
                + addEspacoDireita("" + item.getQtdeMorte())
                + addEspacoDireita("" + item.getMaiorSequAssassinatoSemMorrer())
                + addEspacoDireita(item.getArmaPreferida())
                + addEspacoDireita(item.getAwards().toString()));
    }

    private String addEspacoDireita(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < (20 - str.length()); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
