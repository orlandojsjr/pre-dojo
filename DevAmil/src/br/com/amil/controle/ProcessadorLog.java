/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.controle;

import br.com.amil.entidade.Arma;
import br.com.amil.entidade.Jogador;
import br.com.amil.entidade.Partida;
import br.com.amil.entidade.PartidaItem;
import br.com.amil.enuns.TipoRanking;
import br.com.amil.ranking.factory.RankingFactory;
import br.com.amil.ranking.RankingInterface;
import br.com.amil.util.ArquivoLeitura;
import br.com.amil.util.DataUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Orlando
 */
final class ProcessadorLog implements ProcessadorLogInterface {

    private final String urlAbsolutaArquivoLog;
    private final List<Partida> partidas;
    private Partida partida;

    public ProcessadorLog(String urlAbsolutaArquivoLog) {
        this.urlAbsolutaArquivoLog = urlAbsolutaArquivoLog;
        this.partidas = new ArrayList<>();
    }

    @Override
    public void apresentarResultado() {
        for (TipoRanking tipoRanking : TipoRanking.values()) {
            RankingInterface ranking = RankingFactory.criarRanking(tipoRanking);
            ranking.gerarRanking(partidas);
        }
    }

    @Override
    public boolean processar() {
        try {
            partidas.clear();
            File file = new File(urlAbsolutaArquivoLog);
            ArquivoLeitura arquivo = new ArquivoLeitura(file);
            String linha;
            while ((linha = arquivo.lerProximaLinha()) != null) {
                verificar(linha);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void verificar(String linha) {
        if (linha.contains("<WORLD>")) {
            return;
        }
        int indexData = linha.indexOf("-");
        String dataStr = linha.substring(0, indexData);
        Date dt = DataUtil.stringToDate(dataStr);
        String acao = linha.substring(indexData, linha.length());

        if (acao.contains("has started")) {
            novaPartida(dt, acao);
        } else if (acao.contains("has ended")) {
            fimPartida(dt);
        } else {
            assassinatoEMorte(dt, acao);
        }
    }

    private void novaPartida(Date dt, String str) {
        partida = new Partida();
        String aux[] = str.split(" ");
        partida.setNumero(Integer.parseInt(aux[3]));
        partida.setDtInicio(dt);
    }

    private void fimPartida(Date dt) {
        partida.setDtFinal(dt);
        partidas.add(partida);
    }

    private void assassinatoEMorte(Date dt, String str) {
        String aux[] = str.split(" ");
        Jogador assassino = new Jogador(aux[1]);
        Jogador vitima = new Jogador(aux[3]);
        Arma arma = new Arma(aux[5]);

        if (!partida.getItens().containsKey(assassino.getNome())) {
            partida.getItens().put(assassino.getNome(), new PartidaItem(assassino));
        }
        partida.getItens().get(assassino.getNome()).adicionarAssassinato(arma, dt);

        if (!partida.getItens().containsKey(vitima.getNome())) {
            partida.getItens().put(vitima.getNome(), new PartidaItem(vitima));
        }
        partida.getItens().get(vitima.getNome()).adicionarMorte();
    }
}
