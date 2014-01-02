/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.launchpad.automation.keywords;

import com.qait.launchpad.automation.pageuiobjects.LoginPageUi;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAIT
 */
public class LoginPageActions {

    LoginPageUi loginpage;
   

    public LoginPageActions(WebDriver driver) {
        loginpage = new LoginPageUi(driver);
        
    }

    public void typeUserName(String username){
        loginpage.getUserNameField().clear();
        loginpage.getUserNameField().sendKeys(username);
    }
    
    public void typePassword(String password){
        loginpage.getPasswordField().clear();
        loginpage.inp_username.sendKeys("");
        loginpage.getPasswordField().sendKeys(password);
    }
    
    public void typeUsernameAndPassword(String username, String password){
        typeUserName(username);
        typePassword(password);
    }
    
    public void loginToTheApplication (String username, String password){
        typeUsernameAndPassword(username, password);
        loginpage.getLoginButton().click();
    }
        
    public String getPageTitle(){
        return loginpage.getPageTitle();
    }
    
}
