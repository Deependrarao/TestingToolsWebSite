package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingToolDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//System is class setProperty take two parameter like "key" and "Value" 
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32/chromedriver.exe");

		//Create the object of driver
		WebDriver driver = new ChromeDriver();

		//provide the Valid Url
		driver.get("https://www.google.com/search?q=testing+tools");

		//Maximize the window
		driver.manage().window().maximize();

		//Global wait provide by using implicitly wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String actual = driver.getTitle();
		String expected = "testing tools - Google Search";

		//compare the actual and expected title of the page
		if(actual.equals(expected)) 
		{
			System.out.println("Actual and expected title are matching :=> "+actual+" = "+expected);
		}
		else 
		{
			System.out.println("Actual and expected title are not matching Test failed");
		}


		//click on tool side drop button
		driver.findElement(By.xpath("//span[@class='PBBEhf']")).click();

		//Display total testing tool name 
		WebElement allTools = driver.findElement(By.id("Odp5De"));
		System.out.print("Name of the all tool:=>"+allTools.getText());

		List<WebElement> allDrop = driver.findElements(By.className("hXfKwd"));
		for(WebElement drop :allDrop)
		{
			drop.click();

			//Here extract Title of tools
			Thread.sleep(3000);

			List<WebElement> titles = drop.findElements(By.xpath("//div[@class='I506P IFnjPb']"));
			for(WebElement title : titles)
			{
				String titleText = title.getText().trim();
				// Check if title is not empty
				if (!titleText.isEmpty()) 
				{    
					System.out.println("Title of the testing tool:=> " + title.getText());
				}
			}			

			//Extract descripation of the tools

			List<WebElement> paragraphs = driver.findElements(By.xpath("//h3/following-sibling::span/span"));
			Thread.sleep(2000);
			for(WebElement description : paragraphs)
			{
				String descriptionText = description.getText().trim();
				Thread.sleep(3000);
				if (!descriptionText.isEmpty())
				{
					System.out.println("Description of the testing tool:=> " + descriptionText);
					break;
				}
			}

			//Extract Logo of testing tools

			List<WebElement> logos = driver.findElements(By.xpath("(//div[@class='Q8j1wd'])[position() mod 2=0]"));
			for(WebElement logo:logos)
			{
				boolean logoTool = logo.isDisplayed();
				if (logoTool) 
				{
					//if logo image is present then print True if not then print false, or whatever method retrieves the text of the logo
					System.out.println("Logo is displayed image of the tool:=> " + logoTool); 
				} 
			}
		}

		// Extract URL of testing tools	

		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'https://en.wikipedia.org/wiki')]"));
		for(WebElement link: links)
		{
			String urlText = link.getAttribute("href").trim();
			System.out.println("Url of the testing tools:=> "+urlText);
		}
	}
}

