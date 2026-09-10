package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static TakesScreenshot ts;
	protected static Actions A;
	protected static JavascriptExecutor js;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("profile.credentials_enable_service", false);
		options.setExperimentalOption("prefs", prefs);

		options.addArguments("disable-notification");
		options.addArguments("disable-geolocation");
		options.addArguments("disable-media-stream");

		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		ts = (TakesScreenshot) driver;
		A = new Actions(driver);
		js = (JavascriptExecutor) driver;

	}

	public static void setText(WebElement element, String value) {
		element.click();
		element.sendKeys(value);
	}

	public static void button(WebElement element) {
		element.click();
	}

	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void setTextWithEnter(WebElement element, String value) {
		element.sendKeys(value, Keys.ENTER);
	}

	public static void WaitImpletic() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void elementToClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void visibleOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void visibleOfAllElement(List<WebElement> list) {
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	public static boolean displayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public void iterateWebElement(List<WebElement> list, int size) {
		for (int i = 0; i < size; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(list.get(i).getText() + " | ");
			System.out.println();
		}
	}

	public static void select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void shot() throws IOException {
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/image.jpg");

		FileUtils.copyFile(src, des);
	}

	public static void scrollToElement(WebElement element) {
		A.moveToElement(element).perform();
	}

	public void hiddenButton(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void scroll(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}

	public String retrieveAttribute(WebElement element, String attribute) {
		String attribute2 = element.getAttribute(attribute);
		return attribute2;
	}

	public String screenShot(WebDriver driver1, String scenario) {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String filePath = System.getProperty("user.dir") + "/screenShot/" + scenario + " - " + timeStamp + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(filePath);
		try {
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			throw new RuntimeException("Screenshot not captured");
		}
		return filePath;
	}

	public void clickDate(String data) {

		// By dateLocator = By.xpath("//td[.//div[contains(@class,'day') and
		// normalize-space()='" + data + "']]//div[contains(@class,'day')]");
		By locator = By.xpath("//div[contains(@class,'day') and normalize-space()='" + data + "']");
		List<WebElement> dates = driver.findElements(locator);
		System.out.println("date element: " + dates.size());
		if (dates.size() == 0) {
			throw new RuntimeException("Date" + data + "was not found");
		}
		WebElement dateElement = dates.get(0);

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", dateElement);
		js.executeScript("arguments[0].click();", dateElement);
//		wait.until(ExpectedConditions.elementToBeClickable(dateElement));
//		
//		Actions A = new Actions(driver);
//		A.moveToElement(dateElement).click().perform();
	}

	public void date(String data) {
		By locator = By.xpath("//div[contains(@class,'day') and normalize-space()='" + data + "']");
		List<WebElement> dates = driver.findElements(locator);
		for (WebElement date : dates) {
			if (date.isDisplayed() && date.getSize().getHeight() > 0) {
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", date);
				js.executeScript("arguments[0].click();", date);
				//return;
			}
		}

	}

	public void setTextByJs(WebElement element) {
		js.executeScript("arguments[0].setAttribute('value','Test@gmail.com');", element);
	}

	public void sliderRanger(List<WebElement> slider, WebElement sliderRange) {
		Actions A = new Actions(driver);
		WebElement left = slider.get(0);
		WebElement right = slider.get(1);

		int width = sliderRange.getSize().getWidth();
		int move = (int) (width * 0.30);

		A.clickAndHold(right).moveByOffset(0, -move).release().perform();

	}
	
	public void switchToWindow(int i) {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		List<String> list = new ArrayList<>();
		driver.switchTo().window(list.get(i));
	}

}



