package test_leaf;

import static driver.Driver.getDriver;

import java.util.List;

import static common.Common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class DropDown_09_22_2019 {

	public static void main(String[] args) {
		WebDriver driver = getDriver("chrome");
		String URL="http://testleaf.herokuapp.com/pages/Dropdown.html";
		driver.navigate().to(URL);
//		sleep(1);
		
		WebElement dropdown1=driver.findElement(By.id("dropdown1"));
		Select select = new Select(dropdown1);
		select.selectByIndex(1);
//		sleep(1);
		
		WebElement dropdown2=driver.findElement(By.name("dropdown2"));
		select = new Select(dropdown2);
		select.selectByVisibleText("Selenium");
//		sleep(1);
		
		WebElement dropdown3=driver.findElement(By.id("dropdown3"));
		select = new Select(dropdown3);
		select.selectByValue("2");
//		sleep(1);
		
		WebElement dropdown4=driver.findElement(By.cssSelector("[class='dropdown']"));
		select = new Select(dropdown4);
		int numberOfOptions = select.getOptions().size();
		System.out.println("DropDown-4, number of options - "+numberOfOptions);
		List<WebElement> optionsOfDD4=select.getOptions();
		for (WebElement option : optionsOfDD4) {
			System.out.println("Options of DD4: "+option.getText());
		}
//		sleep(1);
		
		WebElement dropdown5=driver.findElement(By.xpath("(//select)[5]"));
//		select = new Select(dropdown5);
		dropdown5.sendKeys("UFT/QTP");
//		sleep(1);
		
		WebElement dropdown6=driver.findElement(By.xpath("(//select)[6]"));
		select = new Select(dropdown6);
//		boolean isMultiple=select.isMultiple();
//		System.out.println("DD6 Multiple? ");
//		if (isMultiple) {
//			select.selectByIndex(1);
//			select.selectByIndex(3);
//		}
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL)
		.click(select.getOptions().get(1))
		.click(select.getOptions().get(3))
		.keyUp(Keys.CONTROL).build().perform();
		
		sleep(1);
		driver.quit();
	}

}
