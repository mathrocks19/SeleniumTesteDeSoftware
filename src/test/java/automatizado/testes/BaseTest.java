package automatizado.testes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

	protected static WebDriver driver;
	private static final String PATH_DRIVER = "src/test/resources/chromedriver.exe";
	private static final String URL_LOGIN = "file:///C:/Users/36129382023.2N/Downloads/sistema/sistema/login.html";
	private static final String URL_PRODUTOS = "file:///C:/Users/36129382023.2N/Downloads/sistema/sistema/produtos.html\n";

	/**
	 * Método para inicializar o WebDriver e abrir a URL desejada.
	 *
	 * @param url URL da página a ser carregada.
	 */
	public static void iniciar(String url) {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@BeforeClass
	public static void iniciarLogin() {
		iniciar(URL_LOGIN); // Inicializa o driver com a página de login.
	}

	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
}
