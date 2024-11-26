package automatizado.testes;

import automatizado.pageObject.ProdutosPO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TesteMensagemErroDeCadastro {

    private WebDriver driver;
    private ProdutosPO produtosPO;
    private String PATH_DRIVE = "src/test/resources/chromedriver.exe";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", this.PATH_DRIVE);
        this.driver = new ChromeDriver();
        this.driver.get("file:///C:/Users/36129382023.2N/Downloads/sistema/sistema/produtos.html#");
        this.produtosPO = (ProdutosPO) PageFactory.initElements(this.driver, ProdutosPO.class);
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void deveMostrarMensagemErroAoSalvarComCamposVazios() {
        this.produtosPO.abrirModalCadastro();
        this.produtosPO.abrirModalCadastro();
        this.produtosPO.salvarProduto();
        Assert.assertTrue(this.produtosPO.obterMensagemErro().contains("Todos os campos são obrigatórios para o cadastro!"));
        this.produtosPO.fecharModalCadastro();
    }
}
