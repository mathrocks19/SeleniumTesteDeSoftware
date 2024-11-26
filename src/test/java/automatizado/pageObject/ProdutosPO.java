package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO {
    @FindBy(
            id = "btn-adicionar"
    )
    public WebElement btnAdicionar;
    @FindBy(
            id = "cadastro-produto"
    )
    public WebElement modalCadastro;
    @FindBy(
            id = "btn-salvar"
    )
    public WebElement btnSalvar;
    @FindBy(
            id = "btn-sair"
    )
    public WebElement btnSair;
    @FindBy(
            css = ".alert-danger"
    )
    public WebElement mensagemErro;
    @FindBy(
            id = "codigo"
    )
    public WebElement inputCodigo;
    @FindBy(
            id = "nome"
    )
    public WebElement inputNome;
    @FindBy(
            id = "quantidade"
    )
    public WebElement inputQuantidade;
    @FindBy(
            id = "valor"
    )
    public WebElement inputValor;
    @FindBy(
            id = "data"
    )
    public WebElement inputData;
    @FindBy(
            css = "table tbody"
    )
    public WebElement tabelaProdutos;

    public ProdutosPO(WebDriver driver) {
        super(driver);
    }

    public void abrirModalCadastro() {
        this.btnAdicionar.click();
    }

    public void fecharModalCadastro() {
        this.btnSair.click();
    }

    public void preencherFormulario(String codigo, String nome, String quantidade, String valor, String data) {
        this.escrever(this.inputCodigo, codigo);
        this.escrever(this.inputNome, nome);
        this.escrever(this.inputQuantidade, quantidade);
        this.escrever(this.inputValor, valor);
        this.escrever(this.inputData, data);
    }

    public void salvarProduto() {
        this.btnSalvar.click();
    }

    public String obterMensagemErro() {
        return this.mensagemErro.getText();
    }

    public boolean verificarProdutoNaTabela(String codigo) {
        return this.tabelaProdutos.getText().contains(codigo);
    }

    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(new CharSequence[]{texto + Keys.TAB});
    }
}
