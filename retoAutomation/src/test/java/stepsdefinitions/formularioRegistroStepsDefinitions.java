package stepsdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Persona;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

public class formularioRegistroStepsDefinitions {

    Base way2auto;
    WebDriver nav;
    WebDriverWait wait;

    By name = new By.ByName("name");
    By phone = new By.ByName("phone");
    By email = new By.ByName("email");
    By country = new By.ByName("country");
    By city = new By.ByName("city");
    By userName = new By.ByXPath("/html/body/div[2]/div/div/div/div/div/form/fieldset[6]/input");
    By password = new By.ByXPath("/html/body/div[2]/div/div/div/div/div/form/fieldset[7]/input");
    By submit = new By.ByXPath("/html/body/div[2]/div/div/div/div/div/form/div[1]/div[2]/input");
    By dummy = new By.ById("alert");


    @Before
    public void configurar() {
        way2auto = new Base(nav);
        nav = way2auto.inicializarNavegardor();
        wait = new WebDriverWait(nav, 10);
        nav.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^el usuario esta en la pagina principal$")
    public void elUsuarioEstaEnLaPaginaPrincipal() {
        way2auto.abrirPagina("https://www.way2automation.com/way2auto_jquery/index.php");
    }

    @When("^el usuario rellena el formulario$")
    public void elUsuarioRellenaElFormulario(List<Persona> arg1) throws Exception {
        String direccion= "insumo.txt";
        wait.until(ExpectedConditions.visibilityOf(nav.findElement(name)));
        int user = (int)(random()*(Persona.sLista(direccion).size()+1)+1);
        way2auto.escribir(name, Persona.listaPersonas(direccion).get(user).getFirstname()+" "+Persona.listaPersonas(direccion).get(user).getSecondName()+" "+Persona.listaPersonas(direccion).get(user).getLastname1()+" "+Persona.listaPersonas(direccion).get(user).getLastname2());
        way2auto.escribir(phone,Persona.listaPersonas(direccion).get(user).getPhone());
        way2auto.escribir(email,Persona.listaPersonas(direccion).get(user).getFirstname()+"@"+Persona.listaPersonas(direccion).get(user).getLastname1()+".com");
        way2auto.escribir(city, arg1.get(0).getCity());
        way2auto.escribir(userName, Persona.listaPersonas(direccion).get(user).getFirstname().substring(0,2)+Persona.listaPersonas(direccion).get(user).getSecondName().substring(0,2)+Persona.listaPersonas(direccion).get(user).getLastname1().substring(0,2)+Persona.listaPersonas(direccion).get(user).getLastname2().substring(0,2));
        way2auto.escribir(password, arg1.get(0).getPassword());
        way2auto.click(submit);


    }

    @Then("^el usuario vera el mensaje (.*)$")
    public void elUsuarioVeraElMensaje(String arg1) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(nav.findElement(dummy)));
        Assert.assertEquals(arg1,way2auto.getText(dummy).replace( " you just clicked SUBMIT BUTTON",""));
    }

    @After
    public void cerrar(){
         //nav.quit();
    }

}