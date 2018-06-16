package dataDrivenTopics;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.DataTable;


public class NewDeal extends TestBase {
	
	@BeforeTest
	public void Login() throws IOException {
		
	prop();
	}
	
	@Test
	public void moves_to_New_Deal_page(DataTable dealdata) {

		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\'navmenu\']/ul/li[5]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a")).click();

		for (Map<String, String> deal2 : dealdata.asMaps(String.class, String.class)) {

			driver.findElement(By.xpath("//*[@id=\'title\']")).sendKeys(deal2.get("Title"));
			driver.findElement(
					By.xpath("//*[@id=\'prospectForm\']/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/input[3]"))
					.sendKeys(deal2.get("Company"));

			driver.findElement(By.id("probability")).sendKeys(deal2.get("Probability %"));

			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\'owner_user_id\']")));
			dropdown.selectByVisibleText(deal2.get("Owner"));

			driver.findElements(
					By.xpath("//*[@id=\'prospectForm\']/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[2]/input[2]"))
					.get(0).click();
			driver.findElements(
					By.xpath("//*[@id=\'prospectForm\']/table/tbody/tr[2]/td[2]/table/tbody/tr[9]/td[2]/input")).get(0)
					.click();

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@type='submit'and @value='Save']")));
			element.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie1) {
				ie1.printStackTrace();
			}

			// WebDriverWait wait1 = new WebDriverWait(driver, 10);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Actions action2 = new Actions(driver);
			action2.moveToElement(driver.findElement(By.xpath("//*[@id=\'navmenu\']/ul/li[5]/a"))).build().perform();
			driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a")).click();

			// Write code here that turns the phrase above into concrete actions
			// For automatic transformation, change DataTable to one of
			// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
			// E,K,V must be a scalar (String, Integer, Date, enum etc)
		}
	}

	@AfterTest
	public void close_the_browser() {
		driver.close();
	}

}
