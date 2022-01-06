package Tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameTest extends SharedData {
    public ElementMethods elementMethods;

    @Test
    public void testAutomat() {
        elementMethods = new ElementMethods(driver);

        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //interactionam cu tabul "switch to"
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).perform();

        //identificam "Frames"
        WebElement frameElement = driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        elementMethods.clickElement(frameElement);
        String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to(url);
        //driver.navigate().refresh();

        List<WebElement> frameOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs '] li a"));
        frameOptions.get(0).click();
        //ne mutam pe un iframe
        driver.switchTo().frame("singleframe");
        WebElement singleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        singleInputElement.sendKeys("ceva ce vrei tu;...");
        driver.switchTo().defaultContent();

        frameOptions.get(1).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        WebElement multipleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        multipleInputElement.sendKeys("altceva ce vrei tu;...");

        driver.quit();




    }
}
