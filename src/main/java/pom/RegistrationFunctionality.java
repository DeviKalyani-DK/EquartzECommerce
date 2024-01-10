package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationFunctionality{
	
	@FindBy(xpath="//a[@type='button']")
	public WebElement icon;
	
	@FindBy(xpath="//i[@class='fa fa-user-circle mr-2']")
	public WebElement signupIcon;
	
	@FindBy(name="f_name")
	public WebElement firstName;
	
	@FindBy(name="l_name")
	public WebElement lastName;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(name="phone")
	public WebElement phone;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="con_password")
	public WebElement confirmPassword;
	
	@FindBy(id="inputCheckd")
	public WebElement checkBox;
	
	@FindBy(id="sign-up")
	public WebElement signupButton;
	
	@FindBy(xpath="//i[@class='fa fa-sign-in']")
	public WebElement signinButton;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement toastMessage;
	
	@FindBy(xpath="//img[@class='__inline-11']")
	public WebElement companyIcon;
	
	public RegistrationFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void regFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void regLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void regEmailID(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void regPhoneNum(String phoneNum) {
		phone.sendKeys(phoneNum);
	}
	
	public void regPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void regConfirmPassword(String conPass) {
		confirmPassword.sendKeys(conPass);
	}
	
	public void regCheckBox() {
		checkBox.click();
	}
	
	public void regSignUpButton() {
		signupButton.click();
	}
	
	public String toastMessageText() {
		return toastMessage.getText();
	}
}
