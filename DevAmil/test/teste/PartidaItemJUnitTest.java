/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import br.com.amil.entidade.Arma;
import br.com.amil.entidade.Jogador;
import br.com.amil.entidade.PartidaItem;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Orlando
 */
public class PartidaItemJUnitTest {
    
    public PartidaItemJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void quantidadeMorteTest() {
        Jogador jogador = new Jogador("vitima Test");
        PartidaItem partidaItem = new PartidaItem(jogador);
        partidaItem.adicionarMorte();
        partidaItem.adicionarMorte();
        partidaItem.adicionarMorte();
        int exp = 3;
        Assert.assertEquals(exp, partidaItem.getQtdeMorte());
    }

    @Test
    public void quantidadeAssassinatoTest() {
        Jogador jogador = new Jogador("Jogador Test");
        PartidaItem partidaItem = new PartidaItem(jogador);
        Arma arma = new Arma("AK47");
        Date dataAtual = new Date();
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarAssassinato(arma, dataAtual);
        int exp = 2;
        Assert.assertEquals(exp, partidaItem.getQtdeAssassinato());
    }

    @Test
    public void sequMaxAssassinatoSemMorrerTest() {
        Jogador jogador = new Jogador("Jogador Test");
        PartidaItem partidaItem = new PartidaItem(jogador);
        Arma arma = new Arma("AK47");
        Date dataAtual = new Date();
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarMorte();
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarAssassinato(arma, dataAtual);
        partidaItem.adicionarMorte();
        int exp = 4;
        Assert.assertEquals(exp, partidaItem.getMaiorSequAssassinatoSemMorrer());
    }

    @Test
    public void armaPreferida() {
        Jogador jogador = new Jogador("Jogador Test");
        PartidaItem partidaItem = new PartidaItem(jogador);
        Arma ak47 = new Arma("AK47");
        Arma m16 = new Arma("M6");
        Date dataAtual = new Date();
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(m16, dataAtual);
        partidaItem.adicionarAssassinato(m16, dataAtual);
        Assert.assertTrue(partidaItem.getArmaPreferida().contains("AK47"));
    }
    
    @Test
    public void awards() {
        Jogador jogador = new Jogador("Jogador Test");
        PartidaItem partidaItem = new PartidaItem(jogador);
        Arma ak47 = new Arma("AK47");        
        Date dataAtual = new Date();
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(ak47, dataAtual);
        partidaItem.adicionarAssassinato(ak47, dataAtual);        
        Assert.assertFalse(partidaItem.getAwards().size() == 2);
        Assert.assertTrue(partidaItem.getAwards().size() == 1);
        partidaItem.adicionarAssassinato(ak47, dataAtual);                
        Assert.assertTrue(partidaItem.getAwards().size() == 2);
        partidaItem.adicionarMorte();
        Assert.assertTrue(partidaItem.getAwards().size() == 1);
    }
}

