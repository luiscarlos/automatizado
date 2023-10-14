package br.com.carlos;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.Keys;

import br.com.carlos.page.GooglePO;

public class GoogleTeste extends BaseTeste {

    private static GooglePO googlePage;

    @BeforeClass
    public static void preperarTestes() {
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPequisarNoGoogleOTextoBatataFrita() {

        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));
        // assertEquals("Aproximadamente 23.900.000 resultados", resultado); valor do
        // tempo de pesquisa muda

    }

    @Test
    public void TC002_deveSerPossivelPequisarNoGoogleOTextoAulaDeTeclado() {
        googlePage.inputPesquisa.sendKeys("Aulas de violão" + Keys.ENTER);

        String resultado = googlePage.divResultadoPesquisa.getText();
        assertTrue(resultado, resultado.contains("resultados"));

    }
}
