package maven1.Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WebTablescript {
	
	   static WebDriver driver;
	
	@Test
	public static void WebTable() throws InterruptedException {
		
		
	  	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.get("https://www.w3schools.com");
    	driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div.w3-row:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(3)")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='HTML Tables']")).click();
		Thread.sleep(3000);
		WebElement table=driver.findElement(By.id("customers"));
		
		 // it will count no of rows in webtable
		
		List<WebElement>tr_rows=table.findElements(By.tagName("tr"));
		Reporter.log("no of rows in webtable is="+tr_rows.size(),true);
		
		// count no of colums in webtable
		
	    List<WebElement>tc_colums=table.findElements(By.tagName("th"));
	    Reporter.log("no of colums in webtable is="+tc_colums.size(),true);
	    
	        // retrieve the test data from webtable
	    
	              int row_num=1;
	              
	              for(WebElement trows:tr_rows) {
	            	  
	            	List<WebElement>tabledata=  trows.findElements(By.tagName("td"));
	              
	              int col_num=1;
	              
	               for(WebElement data:tabledata) {
	            	   
	            	   Reporter.log("row="+row_num+",col="+col_num+",text="+data.getText());
	               

	                    col_num++;
	            	   
	               }
	                    row_num++;
	              }
	                  
	}
}

