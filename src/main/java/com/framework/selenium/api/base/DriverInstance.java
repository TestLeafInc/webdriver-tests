package com.framework.selenium.api.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class DriverInstance  extends AbstractTestNGCucumberTests{

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) {		
		switch (browser) {
		case "chrome":
			ChromeOptions chrome_options = new ChromeOptions();
			chrome_options.addArguments("--no-sandbox"); 
			chrome_options.addArguments("--disable-dev-shm-usage"); 
			chrome_options.addArguments("--disable-notifications"); 
			chrome_options.addArguments("--headless");
			remoteWebdriver.set(new ChromeDriver(chrome_options));
			break;
		case "firefox":
			FirefoxOptions firefox_options = new FirefoxOptions();
			firefox_options.addArguments("--no-sandbox");
			firefox_options.addArguments("--disable-dev-shm-usage"); 
			firefox_options.addArguments("--headless");
			remoteWebdriver.set(new FirefoxDriver(firefox_options));
			break;
		case "ie":
			remoteWebdriver.set(new EdgeDriver());
		default:
			break;
		}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
