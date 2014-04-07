/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.controle;

import br.com.amil.util.Constantes;

/**
 *
 * @author Orlando
 */
public class Main {

    public static void main(String[] args) {
        String nomeArquivo = "log.txt";
        ProcessadorLogInterface processadorLogInterface = new ProcessadorLog(Constantes.PATH_DIR_LOG + nomeArquivo);
        if (processadorLogInterface.processar()) {
            processadorLogInterface.apresentarResultado();
        } else {
            System.out.println("Houve um erro no processamento!");
        }
    }
}
