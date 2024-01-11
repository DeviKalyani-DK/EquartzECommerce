package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class BuyNowFunctionality_WishList extends BaseClass{
	LoginFunctionality login;
	@Test
	public void buyNow() throws Throwable {
		
		browserInitialization();
		login=new LoginFunctionality(driver);
		WebElement product=driver.findElement(By.xpath("//a[text()[normalize-space()='Garden Tree']]"));
		product.click();
		driver.findElement(By.xpath("//i[@class='fa fa-heart-o ']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[@type='button']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-sign-in mr-2']")).click();
		login.loginUsername("devikalyaniviswanadhula2000@gmail.com");
		login.loginPassword("jungkook97");
		login.loginSignin();
		driver.findElement(By.xpath("//i[@class='fa fa-heart-o ']")).click();
		driver.findElement(By.xpath("//i[@class='navbar-tool-icon czi-heart']")).click();
		driver.findElement(By.xpath("//div[@class='font-name']/a[text()='Garden  Tree']")).click();
		driver.findElement(By.xpath("//button[@onclick='buy_now()']")).click();
		Select s=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByValue("7");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@onclick='checkout()']")).click();
		//
		driver.findElement(By.name("contact_person_name")).sendKeys("devi");
		driver.findElement(By.name("phone")).sendKeys("8586746324");
		s=new Select(driver.findElement(By.name("address_type")));
		s.selectByIndex(0);
		
		driver.findElement(By.name("city")).sendKeys("Rajahmundry");
		driver.findElement(By.name("zip")).sendKeys("566232");
		s=new Select(driver.findElement(By.name("country")));
		s.selectByValue("India");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-target='#collapseThree']"));
		driver.findElement(By.name("address")).sendKeys("12-232-34/s3, LalithaBrand Street");
		driver.findElement(By.id("same_as_shipping_address")).click();
		driver.findElement(By.xpath("//span[text()='Proceed payment']")).click();
		
		List<WebElement> payment_mode=driver.findElements(By.xpath("//button[@class='btn btn-block click-if-alone']"));
		payment_mode.get(0).click();
		System.out.println(driver.findElement(By.xpath("//h5[@class='font-black __text-20px']")).getText());
	
	}
}
