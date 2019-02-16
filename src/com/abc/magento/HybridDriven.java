package com.abc.magento;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class HybridDriven
{
	public static void main(String[] args) throws IOException 
	{
  		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/libs/chromedriver");
		InputStream file = HybridDriven.class.getClassLoader().getResourceAsStream("com/abc/magento/hybrid.properties");
		Properties p=new Properties();
		p.load(file);
		String url=p.getProperty("url");
		String emailloc=p.getProperty("emailloc");
		String email=p.getProperty("email");
		String passwordlocation=p.getProperty("passloc");
		String password=p.getProperty("pass");
		String next=p.getProperty("next");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        driver.get(url);
	        driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.xpath(emailloc)).sendKeys(email);
	        driver.findElement(By.xpath(passwordlocation)).sendKeys(password);
	        driver.findElement(By.xpath(next)).click();
	        driver.findElement(By.linkText("Log Out")).click();
	}
}
