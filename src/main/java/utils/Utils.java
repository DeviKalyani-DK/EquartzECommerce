package utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;


public class Utils extends BaseClass{
	
 
	public static String filepath="C:\\Users\\admin\\Documents\\EquartzTestData.xlsx";
    public static Robot rb;
	
	public static String[][] setData(String sheetName) throws Throwable{
		
		File file=new File(filepath);
		FileInputStream fin=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int cols=sheet.getRow(1).getLastCellNum();
		String[][] data=new String[rows-1][cols];
		
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<cols;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				System.out.println(data[i][j]);
			}
		}
		
		fin.close();
		workbook.close();
		return data;
	}
	
	public static void keysRobot() throws Throwable {
		rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
	}
	
	public static void enterRobot() throws Throwable {
		rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static boolean isElementDisplay(WebElement w) {
		return w.isDisplayed();
	}
	
	public static boolean isElementEnable(WebElement w) {
			return w.isEnabled();
	}
	
	public static boolean isElementSelected(WebElement w) {
		return w.isSelected();
	}
	
	public static boolean containsString(String s1,String s2) {
		s1=s1.replaceAll("[^a-zA-Z0-9]", "");
		s2=s2.replaceAll("[^a-zA-Z0-9]", "");
		if(s1.contains(s2)) {
			return true;
		}
		
		return false;
	}

	public  String getToastMessageText(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	}

}
