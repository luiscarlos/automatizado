package br.com.carlos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.carlos.page.GooglePO;
import br.com.carlos.page.LoginPO;

public class LoginTeste extends BaseTeste {
    private static LoginPO loginPage;

    @BeforeClass
    public static void preperarTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_NaoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.escrever(loginPage.inputEmail, "");
        loginPage.inputSenha.sendKeys("");
        loginPage.btnEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }
}
