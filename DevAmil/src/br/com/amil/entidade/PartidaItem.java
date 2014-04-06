/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.entidade;

import br.com.amil.enuns.Award;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Orlando
 */
public class PartidaItem implements Comparable<PartidaItem> {

    private final Jogador jogador;
    private int sequAssassinatoSemMorrer;
    private int maiorSequAssassinatoSemMorrer;
    private int qtdeAssassinato;
    private int qtdeMorte;
    private final Map<String, PartidaItemHasArma> armas;
    private final List<Date> dtHoraAssassinatos;

    public PartidaItem(Jogador jogador) {
        this.jogador = jogador;
        armas = new HashMap<>();
        dtHoraAssassinatos = new ArrayList<>();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public int getQtdeAssassinato() {
        return qtdeAssassinato;
    }

    public int getQtdeMorte() {
        return qtdeMorte;
    }

    public int getMaiorSequAssassinatoSemMorrer() {
        return maiorSequAssassinatoSemMorrer;
    }

    public Map<String, PartidaItemHasArma> getArmas() {
        return armas;
    }

    public String getArmaPreferida() {
        if (armas.isEmpty()) {
            return "";
        }
        List<PartidaItemHasArma> lista = new ArrayList<>(armas.values());
        Collections.sort(lista, Collections.reverseOrder());
        return lista.get(0).getArma().getModelo() + " (" + lista.get(0).getQtdeAssassinato() + "x)";
    }

    private void atualizarSequenciaAssassinatoSemMorrer() {
        if (sequAssassinatoSemMorrer > maiorSequAssassinatoSemMorrer) {
            maiorSequAssassinatoSemMorrer = sequAssassinatoSemMorrer;
        }
    }

    public void adicionarMorte() {
        atualizarSequenciaAssassinatoSemMorrer();
        sequAssassinatoSemMorrer = 0;
        qtdeMorte++;
    }

    public void adicionarAssassinato(Arma arma, Date dt) {
        if (!armas.containsKey(arma.getModelo())) {
            armas.put(arma.getModelo(), new PartidaItemHasArma(arma));
        }
        armas.get(arma.getModelo()).adicionarMortes();
        qtdeAssassinato++;
        sequAssassinatoSemMorrer++;
        atualizarSequenciaAssassinatoSemMorrer();
        dtHoraAssassinatos.add(dt);
    }

    public Set<Award> getAwards() {
        Set<Award> awards = new HashSet<>();
        if (getQtdeMorte() == 0) {
            awards.add(Award.IMMORTAL);
        }
        if (dtHoraAssassinatos.size() >= 5) {
            for (int i = 0; i < dtHoraAssassinatos.size() - 4; i++) {
                if ((dtHoraAssassinatos.get(i + 4).getTime() - dtHoraAssassinatos.get(i).getTime()) <= 60000) {
                    awards.add(Award.THE_KILLER_FIVE_KILLS_PER_MINUTE);
                    break;
                }
            }
        }
        return awards;
    }

    @Override
    public int compareTo(PartidaItem o) {
        if (qtdeAssassinato < o.getQtdeAssassinato()) {
            return -1;
        } else if (qtdeAssassinato > o.getQtdeAssassinato()) {
            return 1;
        }
        return 0;
    }
}
