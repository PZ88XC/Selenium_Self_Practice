package com.seleniumbootcampframework.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumbootcampframework.core.Browser;
import com.seleniumbootcampframework.core.Log;

public class Frame extends Browser {

	public static void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
		Log.testStep("PASSED", "Switch to default content", "Switch to default content");
	}
	private By by;
	private WebElement element;

	private String name;

	public Frame(String name, By by) {
		this.by = by;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void switchFrame() {
		element = Browser.findElement(by);
		if (element == null) {
			Log.testStep("FAILED", name + " Frame is NOT displayed", name + " Frame is displayed");
		} else {
			WebDriverWait wait = new WebDriverWait(getDriver(), 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			Log.testStep("PASSED", "Switch to frame " + name, "Switch to frame " + name);
		}
	}

}
