package br.com.carlos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import br.com.carlos.page.GooglePO;
import br.com.carlos.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTeste extends BaseTeste {
    private static LoginPO loginPage;

    // public void executarAcaoDeLogar(String email, String senha) {
    // loginPage.escrever(loginPage.inputEmail, "");
    // loginPage.escrever(loginPage.inputSenha, "");
    // }

    @BeforeClass
    public static void preperarTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_NaoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("", "");
        // loginPage.inputSenha.sendKeys("");
        loginPage.btnEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC002_NaoDeveLogarNoSistemaComEmailInformadoIncorretoESenhaVazios() {

        loginPage.executarAcaoDeLogar("teste", "");
        loginPage.btnEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC003_NaoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("", "teste");
        loginPage.btnEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaIncorretos() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        // loginPage.executarAcaoDeLogar("admin@123", "admin@admin.com");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");

    }
}
