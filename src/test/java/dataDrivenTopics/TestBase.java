package dataDrivenTopics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {
	public WebDriver driver = null;

	@Test
	public void prop() throws IOException {
		Properties prop = new Properties();
		FileInputStream fir = new FileInputStream(
				"C:\\Users\\RITHWIK\\My_Work2\\DataDrivenFrmwrk\\datadriven.properties");
		prop.load(fir);

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").contains("chrome")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));
		driver.navigate().to(prop.getProperty("url2"));

		System.out.println(driver.getTitle());

		driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(1)"))
				.sendKeys(prop.getProperty("Username"));
		driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(2)"))
				.sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println(driver.getTitle());
	}
}
