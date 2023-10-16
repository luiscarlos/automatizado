package br.com.carlos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {
    protected static WebDriver driver;
    // protected static ChromeDriver chromeDriver;
    private static final String URL_BASE = "file://C:/Users/luisc/Downloads/sistema/login.html";
    private static final String DRIVER = "webdriver.chrome.driver";
    private static final String CAMINHO_DRIVER = "C://temp//drivers//chromedriver.exe";

    @BeforeClass
    public static void iniciar() {
        System.setProperty(DRIVER, CAMINHO_DRIVER);

        // abrindo o navegador
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navegando para a pagina desejada/
        driver.get(URL_BASE);

    }

    @AfterClass
    public static void finalizar() {
        driver.close();
    }
}
