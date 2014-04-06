/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.ranking;

import br.com.amil.entidade.Partida;
import br.com.amil.entidade.PartidaItem;
import br.com.amil.util.ArquivoEscrita;
import br.com.amil.util.Constantes;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orlando
 */
public class RankingCSV implements RankingInterface {

    private ArquivoEscrita arquivoEscrita;

    @Override
    public void gerarRanking(List<Partida> partidas) {
        try {
            for (Partida partida : partidas) {
                String arquivo = Constantes.PATH_DIR_CSV + "ranking_partida_" + partida.getNumero() + ".csv";
                arquivoEscrita = new ArquivoEscrita(new File(arquivo));
                escreverCabecalho();
                for (PartidaItem item : partida.getListaOrdernadaRanking()) {
                    escreverLinha(item);
                }
                arquivoEscrita.fechar();
                System.out.println("Arquivo ranking CSV Gerado com Sucesso! Diretório: " + arquivo);
            }
        } catch (IOException ex) {
            Logger.getLogger(RankingCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void escreverCabecalho() throws IOException {        
        arquivoEscrita.escreverNovaLinha("Jogador;Assassinatos;Mortes;Streak;Arma Preferida;Awards");
    }

    private void escreverLinha(PartidaItem item) throws IOException {
        StringBuilder linha = new StringBuilder();
        linha.append(item.getJogador().getNome())
                .append(";")
                .append(item.getQtdeAssassinato())
                .append(";")
                .append(item.getQtdeMorte())
                .append(";")
                .append(item.getMaiorSequAssassinatoSemMorrer())
                .append(";")
                .append(item.getArmaPreferida())
                .append(";")
                .append(item.getAwards());
        arquivoEscrita.escreverNovaLinha(linha.toString());
    }
}
