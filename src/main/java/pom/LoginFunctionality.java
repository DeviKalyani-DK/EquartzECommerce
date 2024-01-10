package pom;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginFunctionality {
	
	//pom -> design pattern for framework
	
	@FindBy(xpath="//a[@type='button']")
	public WebElement icon;
	
	@FindBy(xpath="//i[@class='fa fa-sign-in mr-2']")
	public WebElement signin_icon;
	
	@FindBy(id="si-email")
     public WebElement email;
	
	@FindBy(id="si-password")
	public WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	public WebElement signin;
	
	@FindBy(xpath="//a[text()[normalize-space()='Forgot password?']]")
	public WebElement forgotPassword;
	
	@FindBy(id="remember")
	public WebElement rememberMe;
	
	@FindBy(xpath="//a[@class=\"btn btn-outline-primary\"]")
	public WebElement signupbutton;
	
	@FindBy(xpath="//i[@class='czi-eye password-toggle-indicator']")
	public WebElement showPassword;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement toastMessage;

	//pagefactory initialization 
	public LoginFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*
	//properties file
	public void doLogin() {
		email.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("password"));
		signin.click();
	}
	*/
	
	//dataprovider & excel
	public void loginUsername(String username) {
		email.sendKeys(username);
		
	}
	
	public void loginPassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	public void loginSignin() {
		signin.click();
	}
	public void forgotPass() {
			forgotPassword.click();
	}
	
	public void remember_me() {
		rememberMe.click();
		
	}
	
	public void signup_button() {
		signupbutton.click();
	}
	
	public void show_password() {
		showPassword.click();
	}

	public String toastMessageText() {
		return toastMessage.getText();
	}
}
