package automatizado.testes;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import automatizado.pageObject.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleFirstTestRefatorado4 extends BaseTest {

	private static GooglePO googlePage;

	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://www.google.com");
		googlePage = new GooglePO(driver);
	}

	@Test
	public void TC001_deveSerPossivelPesquisarNoGoogleReceitaDeBolo() {
		realizarPesquisa("receita de bolo de laranja", "bolo de laranja");
		realizarPesquisa("receita de bolo de banana", "relacionadas");
	}

	private void realizarPesquisa(String termo, String esperado) {
		googlePage.pesquisar(termo);
		String resultado = googlePage.getResultadoDaPesquisa();
		assertTrue(resultado, resultado.contains(esperado));
	}
}
