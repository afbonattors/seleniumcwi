package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Utils;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.junit.Assert.assertTrue;

public class SetupTest extends BaseTest{

    @Test
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Navegador iniciado e carregou URL com sucesso!");
    }

    @Test
    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Abriu browser, carregou a página e clicou Sign in");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("afbonatto@gmail.com");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("12345");
        System.out.println("Preencheu dados de login");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicou Signin");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou URL My account");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou My account no site");
    }
}