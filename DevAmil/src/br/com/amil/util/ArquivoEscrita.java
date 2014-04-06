/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Orlando
 */
public class ArquivoEscrita {

    private final File file;
    private boolean isNovo;
    private BufferedWriter bfWriter;

    public ArquivoEscrita(File file) {
        this.file = file;
    }

    public boolean escreverNovaLinha(String linha) throws IOException {
        try {
            if (!isNovo) {
                novoArquivo();
            }
            bfWriter.append(linha);
            bfWriter.newLine();            
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void novoArquivo() throws IOException {
        bfWriter = new BufferedWriter(new FileWriter(file));
        isNovo = true;
    }

    public boolean fechar() {
        try {
            if (isNovo) {
                bfWriter.flush();
                bfWriter.close();
                isNovo = false;
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
