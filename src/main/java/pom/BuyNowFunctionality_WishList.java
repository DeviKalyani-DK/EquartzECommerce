package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class BuyNowFunctionality_WishList extends BaseClass{

		@FindBy(xpath="//i[@class='fa fa-heart-o ']")
		public WebElement addToWishList;
		
		@FindBy(xpath="//button[text()='OK']")
		public WebElement wishlistOK;
		
		@FindBy(xpath="//i[@class='navbar-tool-icon czi-heart']")
		public WebElement iconHeart;
		
		@FindBy(xpath="//div[@class='font-name']//a")
		public List<WebElement> wishlistProducts;
		
		@FindBy(xpath="//i[@class='czi-close-circle']")
		public List<WebElement> wishlistProductsCancel;
		
		@FindBy(xpath="//span[text()='Buy now']")
		public WebElement buyNow;
		
		@FindBy(xpath="//a[text()[normalize-space() = 'Garden Tree']]")
		public WebElement product;
		
		@FindBy(id="swal2-content")
		public WebElement CartMessage;
	
		public BuyNowFunctionality_WishList(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
			
		}
		
		public void productOnClick() {
			
			product.click();
		}
		
		public void addProductWishList() {
		
			addToWishList.click();
		}
		
		public void wishListOK() {
			wishlistOK.click();
		}
		
		public void clickIconHeart() {
			iconHeart.click();
		}
		
		public List<WebElement> wishlistProductsNames() {
			return wishlistProducts;
		}
		
		public List<WebElement> wishlistProductsCancel() {
			 return wishlistProductsCancel;
		}
		
		public void buyNowProduct() {
			buyNow.click();
		}
		    
		public String cartMsg() {
			return CartMessage.getText();
		}
		
//		Select s=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
//		s.selectByValue("7");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@onclick='checkout()']")).click();
//		//
//		driver.findElement(By.name("contact_person_name")).sendKeys("devi");
//		driver.findElement(By.name("phone")).sendKeys("8586746324");
//		s=new Select(driver.findElement(By.name("address_type")));
//		s.selectByIndex(0);
//		
//		driver.findElement(By.name("city")).sendKeys("Rajahmundry");
//		driver.findElement(By.name("zip")).sendKeys("566232");
//		s=new Select(driver.findElement(By.name("country")));
//		s.selectByValue("India");
//		
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@data-target='#collapseThree']"));
//		driver.findElement(By.name("address")).sendKeys("12-232-34/s3, LalithaBrand Street");
//		driver.findElement(By.id("same_as_shipping_address")).click();
//		driver.findElement(By.xpath("//span[text()='Proceed payment']")).click();
//		
//		List<WebElement> payment_mode=driver.findElements(By.xpath("//button[@class='btn btn-block click-if-alone']"));
//		payment_mode.get(0).click();
//		System.out.println(driver.findElement(By.xpath("//h5[@class='font-black __text-20px']")).getText());
//	
	
}
