package br.com.carlos.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    /**
     * Construtor padrao para uma nova instancia da pagina de login
     * 
     * @param driver driver da pagina de login
     */

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);

    }

    /**
     * Metodo que tenta executar a acao de logar no sistema
     * 
     * @param email
     * @param senha
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnEntrar.click();
    }

}
