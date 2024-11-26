package automatizado.testes;

import automatizado.pageObject.ProdutosPO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class TestBtnSalvar {

    private WebDriver driver;
    private ProdutosPO produtosPO;
    private String PATH_DRIVE = "src/test/resources/chromedriver.exe";

    public TestBtnSalvar() {
    }

    @Before
    public void setUp() {
        // Configuração do driver do Chrome
        System.setProperty("webdriver.chrome.driver", this.PATH_DRIVE);
        this.driver = new ChromeDriver();
        this.driver.get("file:///C:/Users/36129382023.2N/Downloads/sistema/sistema/produtos.html#");

        // Inicializando a página de produtos
        this.produtosPO = PageFactory.initElements(this.driver, ProdutosPO.class);
    }

    @After
    public void tearDown() {
        // Fechar o navegador após o teste
        this.driver.quit();
    }

    @Test
    public void deveDesabilitarBotaoSalvarAtePreenchimentoCompleto() {
        // Abrir o modal de cadastro
        this.produtosPO.abrirModalCadastro();

        // Verificar se o botão "Salvar" está desabilitado
        assertFalse(this.produtosPO.btnSalvar.isEnabled());

        // Preencher o formulário de cadastro
        this.produtosPO.preencherFormulario("123", "Produto Teste", "10", "99.99", "2024-06-28");

        // Verificar se o botão "Salvar" está habilitado após preenchimento do formulário
        assertTrue(this.produtosPO.btnSalvar.isEnabled());
    }
}
