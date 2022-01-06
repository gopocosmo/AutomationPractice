package Tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class AlertTest extends SharedData {
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

        //identificam "alerts"
        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
        elementMethods.clickElement(alertsElement);

        String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to(url);
        //driver.navigate().refresh();

        List<WebElement> alertOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        alertOptions.get(0).click();
        WebElement casutaOkButonElement = driver.findElement(By.cssSelector("#OKTab button"));
        elementMethods.clickElement(casutaOkButonElement);


        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        alertOptions.get(1).click();
        WebElement casutaOkCancelButonElement = driver.findElement(By.cssSelector("#CancelTab button"));
        elementMethods.clickElement(casutaOkCancelButonElement);


        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        alertOptions.get(2).click();
        WebElement casutaTextButonElement = driver.findElement(By.cssSelector("#Textbox button"));
        elementMethods.clickElement(casutaTextButonElement);


        Alert alertText = driver.switchTo().alert();
        alertText.sendKeys("sa scriem");
        alertText.accept();

    }
}
