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

/**
 *
 * @author Orlando
 */
public class RankingHTML implements RankingInterface {

    private ArquivoEscrita arquivoEscrita;

    @Override
    public void gerarRanking(List<Partida> partidas) {
        try {
            for (Partida partida : partidas) {
                String arquivo = Constantes.PATH_DIR_HTML + "ranking_partida_" + partida.getNumero() + ".html";
                arquivoEscrita = new ArquivoEscrita(new File(arquivo));
                escreverCabecalho();
                for (PartidaItem item : partida.getListaOrdernadaRanking()) {
                    escreverLinha(item);
                }
                rodape();
                arquivoEscrita.fechar();
                System.out.println("Arquivo ranking HTML Gerado com Sucesso! Diretório: " + arquivo);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void escreverCabecalho() throws IOException {
        StringBuilder cabecalho = new StringBuilder("<html>")
                .append("<head>")
                .append("<title>DevAmil - Ranking</title>")
                .append("<style>")
                .append(getCss())
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append("<table id=dataTable>")
                .append("<tr><th>")
                .append("Jogador")
                .append("</th><th>")
                .append("Assassinatos")
                .append("</th><th>")
                .append("Mortes")
                .append("</th><th>")
                .append("Streak")
                .append("</th><th>")
                .append("Arma Preferida")
                .append("</th><th>")
                .append("Awards")
                .append("</th></tr>");
        arquivoEscrita.escreverNovaLinha(cabecalho.toString());
    }

    private void rodape() throws IOException {
        arquivoEscrita.escreverNovaLinha("</table></body></html>");
    }

    private void escreverLinha(PartidaItem item) throws IOException {
        StringBuilder linha = new StringBuilder("<tr><td>");
        linha.append(item.getJogador().getNome())
                .append("</td><td>")
                .append(item.getQtdeAssassinato())
                .append("</td><td>")
                .append(item.getQtdeMorte())
                .append("</td><td>")
                .append(item.getMaiorSequAssassinatoSemMorrer())
                .append("</td><td>")
                .append(item.getArmaPreferida())
                .append("</td><td>")
                .append(item.getAwards())
                .append("</td></td>");
        arquivoEscrita.escreverNovaLinha(linha.toString());
    }

    private String getCss() {
        String css = "#dataTable\n"
                + "{\n"
                + "	font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", Sans-Serif;\n"
                + "	font-size: 12px;\n"
                + "	background: #fff;\n"
                + "	margin: 45px;\n"
                + "	width: 80%;\n"
                + "	border-collapse: collapse;\n"
                + "	text-align: left;\n"
                + "}\n"
                + "#dataTable th\n"
                + "{\n"
                + "	font-size: 14px;\n"
                + "	font-weight: normal;\n"
                + "	color: #039;\n"
                + "	padding: 10px 8px;\n"
                + "	border-bottom: 2px solid #6678b1;\n"
                + "}\n"
                + "#dataTable td\n"
                + "{\n"
                + "	color: #669;\n"
                + "	padding: 9px 8px 0px 8px;\n"
                + "}\n"
                + "#dataTable tbody tr:hover td\n"
                + "{\n"
                + "	color: #009;\n"
                + "}";
        return css;
    }
}
