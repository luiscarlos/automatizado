package br.com.carlos;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.carlos.page.ControleDeProdutoPO;
import br.com.carlos.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTeste extends BaseTeste {

    private static LoginPO loginPage;

    private static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void preperarTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleDeProdutoPage.obterTituloDaPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_DeveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleDeProdutoPage.btnAdicionar.click();

        // TODO: Remover esse click quando o sistema for corrigido
        controleDeProdutoPage.btnAdicionar.click();

        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
    }

}
