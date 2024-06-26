package practice.homeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.protobuf.Method;

public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		String expectedTitle="Home";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		String actualTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		if(actualTitle.trim().equals(expectedTitle)) {
			System.out.println(expectedTitle+"page is verified");
		}else {
			System.out.println(expectedTitle+"page is not verified");
		}
		System.out.println(mtd.getName()+"Test End");
		
	}
	@Test
	public void verifylogohomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		if(status==true) {
			System.out.println("logo is verified");
		}else {
			System.out.println("logo is not verified");
		}
		System.out.println(mtd.getName()+"Test End");
	}

}
