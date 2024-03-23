package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=testing+tools");
		driver.manage().window().maximize();

		String actual = driver.getTitle();
		String expected = "testing tools - Google Search";

		if(actual.equals(expected)) {
			System.out.println("Title are matched :=> "+actual);
		}
		else {
			System.out.println("if title are not matching Test failed");
		}

		// Fetch all search result items
		List<WebElement> allDrop = driver.findElements(By.className("hXfKwd"));
		for(WebElement drop :allDrop) {
			Thread.sleep(2000);
			drop.click();
			//Extract Title 
			Thread.sleep(3000);
			List<WebElement> titles = drop.findElements(By.xpath("//div[@class='I506P IFnjPb']"));
     		for(WebElement title : titles) {
				String titleText = title.getText().trim();
				if (!titleText.isEmpty()) { // Check if title is not empty
					System.out.println("Title of the tool:=> " + title.getText());
				}
			}		

			//Extract descripation of the tools
			List<WebElement> paragraphs = driver.findElements(By.xpath("//h3/following-sibling::span/span"));
			Thread.sleep(2000);
			for(WebElement description : paragraphs) {
				String descriptionText = description.getText().trim();
				Thread.sleep(3000);
				if (!descriptionText.isEmpty()) {
			        System.out.println("Description of the tool:=> " + descriptionText);
			        break;
			    }
			}

		}

	}

}
