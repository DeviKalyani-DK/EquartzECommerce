package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.BuyNowFunctionality_WishList;
import pom.LoginFunctionality;
import utils.Utils;

public class BuyNow_WishList_Test extends BaseClass{
	
	BuyNowFunctionality_WishList buynow;
	LoginFunctionality login;
	boolean flag=false;
	
	@BeforeMethod()
	
	public void setUp() {
		browserInitialization();
		buynow=new BuyNowFunctionality_WishList(driver);
		login=new LoginFunctionality(driver);
		login.icon.click();
		login.signin_icon.click();
		login.loginUsername("devikalyaniviswanadhula2000@gmail.com");
		login.loginPassword("jungkook97");
		login.loginSignin();
		
	}
	
	@Test
	public void productDisplay() {
		Assert.assertTrue(buynow.product.isDisplayed(), "Product is not displayed."); 
	}
	
	@Test
	public void wishlistHeartEnable() {
		Assert.assertTrue(buynow.addToWishList.isEnabled(),"WishList heart is not enabled.");
	}
	
	@Test
	public void wishListOKEnable() {
		Assert.assertTrue(buynow.wishlistOK.isEnabled(),"WishList Ok is not enabled");
	}
	
	@Test
	public void clickIconHeartEnable() {
		Assert.assertTrue(buynow.iconHeart.isEnabled(), "Icon Heart is not enabled.");
	}
	
	@Test
	public void verifyclickIconHeart() {
		buynow.clickIconHeart();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/wishlists",url);
	}
	
	@Test
	public void validaddToWishList() {
		
		buynow.productOnClick();
		buynow.addProductWishList();
		buynow.wishListOK();
		buynow.addProductWishList();
		buynow.clickIconHeart();
		List<WebElement> products=buynow.wishlistProductsNames();
		for(WebElement p:products) {
			
			if(buynow.product.getText().equals(p.getText())) {
				p.click();
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag,"product is not added to wishlist");
		buynow.buyNowProduct();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/shop-cart", url);
		
	}
	@Test
	public void verifyCancelWishListProduct() {
		Utils.cancelWishListProducts(buynow.product);
		List<WebElement> products=buynow.wishlistProductsCancel();
		for(WebElement p:products) {
			if(buynow.product.getText().equals(p.getText())) {
				Assert.fail("The product is still in wishlist");
			}
		}
		
	}
	
	@Test
	public void verifyCart() {
		buynow.buyNowProduct();
		String url=buynow.cartMsg();
		Assert.assertEquals("Already added!",url);
	}
	
	
	

}
