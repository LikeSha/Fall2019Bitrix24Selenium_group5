package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    //we use css selector to define username webElement
    // we can also use (name="USER_LOGIN")
    @FindBy(css = "[name='USER_LOGIN']")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='errortext']")
    private WebElement wrongInputWaringMessage;

    public LoginPage() {

        //to connect our webdriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);


    }

    public String getWarningMessageText(){
        return getWarningMessageText();
    }

    // below is Nurallah version

//    public void login(){
//        userName.clear();
//        password.clear();
//
//        userName.sendKeys(ConfigurationReader.getProperty("user_name"));
//        password.sendKeys(ConfigurationReader.getProperty("password"));
//        loginButton.click();
//    }


    /*
    Method to login , version #1
    Login as a specific user
    @param usernameValue
    @param passwordValue
     */
    public void login(String usernameValue,String passwordValue ){
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        BrowserUtils.wait(3);
    }

    /*
     Method login, version #2
     Login as a default user
     Credentials will be retrieved from configuration properties file
     */
    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("user_name"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.wait(3);
    }


}
