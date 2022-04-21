package com.libraryApp.pages;

import com.libraryApp.utils.ConfigurationReader;
import com.libraryApp.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement userNameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")
    public WebElement loginBtn;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }

}
