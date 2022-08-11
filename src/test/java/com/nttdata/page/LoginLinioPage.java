package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginLinioPage {

    //Localizadores de elementos
    public static By userInput = By.id("login_form_email");
    public static By passInput = By.id("login_form_password");
    public static By loginButton = By.xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/form/button");

}
