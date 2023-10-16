package br.com.carlos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.carlos.page.GooglePO;
import br.com.carlos.page.LoginPO;

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
}
