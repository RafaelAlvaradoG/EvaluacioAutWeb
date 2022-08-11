package com.nttdata.stepsdefinitions;

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


public class GuruStepDef {

    private WebDriver driver;
    private Scenario scenario;
    private GuruLoginSteps loginSteps;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("que estoy en la pagina de inicio de Guru")
    public void queEstoyEnLaPaginaDeInicioDeGuru() {
        driver.get("https://demo.guru99.com/V4/");
        screenShot();
    }

    @When("ingremos mis credenciales usuario {string} y la clave {string}")
    public void ingremosMisCredencialesUsuarioYLaClave(String user, String password) {
        loginSteps = new GuruLoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
    }

    @And("hago clic en login")
    public void hagoClicEnLogin() {
        loginSteps.login();
        screenShot();
    }

    @And("valido que estoy logeado correctamente")
    public void validoQueEstoyLogeadoCorrectamente() {
        //falta implementar
    }


    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
