/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amil.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orlando
 */
public class ArquivoLeitura {

    private final File file;
    private boolean isAberto;
    private BufferedReader bfReader;

    public ArquivoLeitura(File file) {
        this.file = file;
    }

    public String lerProximaLinha() throws IOException {
        if (!isAberto) {
            abrirArquivo();
        }
        String retorno = bfReader.readLine();
        if (retorno == null) {
            fechar();
        }
        return retorno;
    }

    private void abrirArquivo() throws FileNotFoundException {
        bfReader = new BufferedReader(new FileReader(file));
        isAberto = true;
    }

    private boolean fechar() {
        try {
            if (isAberto) {
                bfReader.close();
                isAberto = false;
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
