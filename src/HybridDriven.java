import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HybridDriven {

	public static void main(String[] args) throws IOException {
		//setting the path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/vani/selenium components/chromedriver_linux64/chromedriver");
		FileInputStream fis=new FileInputStream("/home/vani/eclipse-workspace/HybridDriven/hybrid.properties");
		Properties p=new Properties();
		p.load(fis);
		//System.out.println();
		//getting the value from property file and storing in the string named url
		String url=p.getProperty("url");
		String emailloc=p.getProperty("emailloc");
		String email=p.getProperty("email");
		String passloc=p.getProperty("passloc");
		String pass=p.getProperty("pass");
		String next=p.getProperty("next");
		//launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		//maximize the chrome
		driver.manage().window().maximize();
		//applying implicit wait to load the elements in the web page
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.get(url);
	    //click on my account
	    driver.findElement(By.linkText("My Account")).click();
	    //writing the email address in the text box
	    driver.findElement(By.xpath(emailloc)).sendKeys(email);
	    //writing the password in the password field
	    driver.findElement(By.xpath(passloc)).sendKeys(pass);
	    //click on login
	    driver.findElement(By.xpath(next)).click();
	    //click on log out
	    driver.findElement(By.linkText("Log Out")).click();

	}

}
