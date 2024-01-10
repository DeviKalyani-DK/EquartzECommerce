package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.RegistrationFunctionality;
import utils.Utils;

public class RegistrationTest extends BaseClass {
	
	RegistrationFunctionality register;
	Utils ut=new Utils();

	@BeforeTest
	public void setUp() {
		browserInitialization();
		register=new RegistrationFunctionality(driver);
		register.icon.click();
		register.signupIcon.click();
	}
	
	String sheetName="registrationFunctionality";
	@DataProvider
	public String[][] testData() throws Throwable{
		return Utils.setData(sheetName);
	}
	
	@Test(dataProvider="testData")
	public void validRegistratinCredentials(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/customer/auth/login", url);
	}
	
	@Test
	public void regElementsAvailable() {
		Assert.assertTrue(Utils.isElementDisplay(register.firstName),"FirstName is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.lastName),"LastName is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.email),"Email ID is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.phone),"Phone Number is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.password),"Password is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.confirmPassword),"Confirm Password is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.checkBox),"Check Box is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.signupButton),"Signup Button is not Displayed");
		Assert.assertTrue(Utils.isElementDisplay(register.signinButton),"Signin Button is not Displayed");
		
	}
	
	@Test(dataProvider="testData")
	public void duplicateEmailID(String fname,String lname,String email,String phone,String pass,String conpass) {
		
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String errMsg=ut.getToastMessageText(driver);
		Assert.fail(errMsg);
	}
	
	@Test(dataProvider="testData")
	public void duplicatePhoneNum(String fname,String lname,String email,String phone,String pass,String conpass) {
		
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String errMsg=ut.getToastMessageText(driver);
		Assert.fail(errMsg);
	}
	
	@Test(dataProvider="testData")
	public void emptyFirstName(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String isFirstNameRequired=register.firstName.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isFirstNameRequired,"Empty FirstName");
		}
	}
	
	
	@Test(dataProvider="testData")
	public void emptyLastName(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String isFirstNameRequired=register.lastName.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isFirstNameRequired,"Empty LastName");
		}
	}
	@Test(dataProvider="testData")
	public void emptyEmail(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String isEmailRequired=register.email.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isEmailRequired,"Empty EmailID");
		}
	}
	
	@Test(dataProvider="testData")
	public void emptyPhoneNum(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String isPhoneRequired=register.phone.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isPhoneRequired,"Empty PhoneNumber");
		}
	}
	
	@Test(dataProvider="testData")
	public void emptyPassword(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String isPasswordRequired=register.password.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isPasswordRequired,"Empty Password");
		}
	}
	
	@Test(dataProvider="testData")
	public void emptyConfirmPassword(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regCheckBox();
		register.regSignUpButton();
		String isConfirmPasswordRequired=register.confirmPassword.getAttribute("required");
		if(fname.equals("")) {
			Assert.assertEquals(false,isConfirmPasswordRequired,"Empty ConfirmPassword");
		}
	}
	
	@Test(dataProvider="testData")
	public void invalidPasswordLength(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String errMsg=ut.getToastMessageText(driver);
		Assert.fail(errMsg);
		
	}
	
	@Test(dataProvider="testData")
	public void mismatchPasswordConPassword(String fname,String lname,String email,String phone,String pass,String conpass) {
		register.regFirstName(fname);
		register.regLastName(lname);
		register.regEmailID(email);
		register.regPhoneNum(phone);
		register.regPassword(pass);
		register.regConfirmPassword(conpass);
		register.regCheckBox();
		register.regSignUpButton();
		String errMsg=ut.getToastMessageText(driver);
		Assert.fail(errMsg);
	}
	

}
