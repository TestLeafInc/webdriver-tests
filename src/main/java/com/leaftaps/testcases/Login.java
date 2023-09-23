package com.leaftaps.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void loginTests() throws IOException, InterruptedException {
		
		// RemoteWebDriver
		EdgeOptions options = new EdgeOptions();
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("firefox");
		//dc.setVersion("117.0");
		//dc.setPlatform(Platform.LINUX);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://4.240.86.27:4447/wd/hub"), dc);

		//ChromeDriver driver = new ChromeDriver();
		
		// Step 2: Load an URL
		driver.get("http://leaftaps.com/opentaps");

		// Maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(10000);

		// Step 3: Print the title --> getTitle
		driver.findElement(By.id("username")).sendKeys("democsr");
		System.out.println("The title is "+driver.getTitle());
		
		Thread.sleep(5000);
		
		// Step 3: Print the title --> getTitle
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		Thread.sleep(5000);

		driver.findElement(By.className("decorativeSubmit")).click();
		
		Thread.sleep(5000);


		// Step 4: Take Snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("login.png"));

		// Close the browser
		driver.close();


	}

}
