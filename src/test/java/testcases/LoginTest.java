package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.LoginFunctionality;
import utils.Utils;

public class LoginTest extends BaseClass{
	
	LoginFunctionality login;
	
	@BeforeMethod
	public void setUp() {
		browserInitialization();
		login=new LoginFunctionality(driver);
		login.icon.click();
		login.signin_icon.click();
		
	}
	
	String sheetName="loginFunctionality";
	@DataProvider
	public String[][] testData() throws Throwable{
		return Utils.setData(sheetName);
	}
	
	
	
	@Test(dataProvider="testData")
	public void verifyLoginValidCredentials(String uname,String pwd) {	
		login.loginUsername(uname);
		login.loginPassword(pwd);
		login.loginSignin();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/", url);
		
	}
	
	@Test(dataProvider="testData")
	public void verifyLoginInvalid(String uname,String pwd) {
		login.loginUsername(uname);
		login.loginPassword(pwd);
		login.loginSignin();
		String errMsg=login.toastMessageText();
		Assert.fail(errMsg);
	}
	
	
	@Test(dataProvider="testData")
	public void verifyLoginInvalidPassword(String uname,String pwd) {
		login.loginUsername(uname);
		login.loginPassword(pwd);
		login.loginSignin();
		String errMsg=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.fail(errMsg);
	}

	@Test(dataProvider="testData")
	public void verifyLoginEmptyUserName(String uname,String pwd) {
		login.loginUsername(uname);
		login.loginSignin();
		String isUserNameRequired=login.email.getAttribute("required");
		if(uname.equals("")) {
			Assert.assertEquals(false,isUserNameRequired, "Empty UserName");
		}
	}
	
	@Test(dataProvider="testData")
	public void verifyLoginEmptyPassword(String uname,String pwd) {
		login.loginPassword(pwd);
		login.loginSignin();
		String isPasswordRequired=login.password.getAttribute("required");
		if(pwd.equals("")){
			Assert.assertEquals(false,isPasswordRequired, "Empty Password");
		}
		
	}
	
	@Test
	public void verifyLoginEmptyCredentials() {
		login.loginSignin();
		Assert.fail("Both credentials are empty");
	}
	
	@Test(dataProvider="testData")
	public void verifyTabButton(String uname,String pwd) throws Throwable {
		login.email.sendKeys(uname);
		Utils.keysRobot();
		login.password.sendKeys(pwd);
		login.signin.click();
		
	}
	
	@Test(dataProvider="testData")
	public void verifyEnterButton(String uname,String pwd) throws Throwable {
		login.email.sendKeys(uname);
		login.password.sendKeys(pwd);
		Utils.enterRobot();
		
	}
	
	@Test
	public void forgotPasswordEnable() {
		Assert.assertTrue(login.forgotPassword.isEnabled(), "password is not enabled");
		
	}
	
	
	@Test
    public void verifyForgotPassword() {
		login.forgotPass();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/customer/auth/recover-password", url);
	}
	
	
	@Test
	public void verifyRememberme() {
		login.remember_me();	
		Assert.assertEquals(true, Utils.isElementSelected(login.rememberMe));
		
	}
	
	@Test
	public void signupEnabled() {
		Assert.assertTrue(Utils.isElementEnable(login.signupbutton));
	}
	
	
	@Test
	public void verifySignUp() {
		login.signup_button();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/customer/auth/sign-up", url);
	}
	
	@Test
	public void verifyShowPassword() {
		login.show_password();
		String attribute=login.password.getAttribute("type");
		Assert.assertEquals("text", attribute,"Show Password is not working");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
