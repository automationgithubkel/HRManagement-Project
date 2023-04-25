package pompackage;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class Pomlogin extends BaseHRMClass{
//object repository
@FindBy(css=".oxd-input oxd-input--active") //driver.FindElement(By.
WebElement Username;
@FindBy (xpath="//*[@name='password']") WebElement Password;	
@FindBy (css ="//button[@type='submit']") WebElement Loginbtn;

//initiate page elements

public Pomlogin () throws IOException, InterruptedException {
    PageFactory.initElements(driver, this);
}

public void typeusername(String name) {
Username.sendKeys(name);
}
public void typepassword(String pass) {
Password.sendKeys(pass);
}
public void clickbtn() {
	Loginbtn.click();
}
public String verify() {
	return driver.getTitle();
	
}
}
