package com.hrms.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceSelenium {
	public static String url = "https://demoqa.com/automation-practice-form/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> proList = driver.findElements(By.xpath("//input[@name='gender']"));

		int listSize = proList.size();
		System.out.println("Size of CheckBoxes are:: " + listSize);

		String valueToBeSelected = "Male";
		// driver.findElement(By.xpath("//input[@id='sex-0']")).getAttribute("value");
		for (WebElement pro : proList) {

			if (pro.isEnabled()) {// Checking if the check-box is enabled

				String value = pro.getAttribute("value");// get value of value attribute

				System.out.println(value);

				if (value.equals(valueToBeSelected)) {
					pro.click();
					break;
				}

			}

		}

	}
}
