package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.steps.GuruLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LinioStepdefs {

    private WebDriver driver;
    private Scenario scenario;
    private LinioLoginSteps login;


    @Before(order = 0)
    public void setUp() {
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Given("que estoy en la pagina de inicio de Linio")
    public void queEstoyEnLaPaginaDeInicioDeLinio() {
        driver.get("https://www.linio.com.co/account/login");
        screenShot();

    }

    @When("ingresemos mis credenciales usuario {string} y la clave {string}")
    public void ingresemosMisCredencialesUsuarioYLaClave(String usuario, String clave) {
        login = new LinioLoginSteps(driver);
        login.typeUser(usuario);
        login.typePassword(clave);
        screenShot();
    }

    @And("hago click en login")
    public void hagoClickEnLogin() {
    }


    @And("valido el ingreso")
    public void validoElIngreso() {
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}

