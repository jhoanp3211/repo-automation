package stepsdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Base {

    WebDriver nav;
    private static ChromeOptions options;

    public Base(WebDriver driver) {
        this.nav = driver;
    }

    public WebDriver inicializarNavegardor() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        nav = new ChromeDriver(options);
        return nav;
    }

    public void abrirPagina(String url) {
        nav.get(url);
    }

    public String getText(By localizador) {
        return nav.findElement(localizador).getText();
    }

    public String getTitulo() {
        return nav.getTitle();
    }

    public void click(By localizador) {
        nav.findElement(localizador).click();
    }

    public void escribir(By localizador, String txt) {
        nav.findElement(localizador).sendKeys(txt);
    }

    public void enviar(By loacalizador) {
        nav.findElement(loacalizador).submit();
    }

    public Boolean isDisplayed(By localizador) {
        return nav.findElement(localizador).isDisplayed();
    }

    public Boolean isEnabled(By localizador) {
        return nav.findElement(localizador).isEnabled();
    }

    public void selebpx(Select box, String value) {
        box.selectByVisibleText(value);
    }
}
