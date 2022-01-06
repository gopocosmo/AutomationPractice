package Tests;

import Base.SharedData;
import Help.AlertMethods;
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
    public AlertMethods alertMethods;

    @Test
    public void testAutomat() {
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);


        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //interactionam cu tabul "switch to"
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.hoverElement(switchToElement);

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

        alertMethods.acceptAlert();

        alertOptions.get(1).click();
        WebElement casutaOkCancelButonElement = driver.findElement(By.cssSelector("#CancelTab button"));
        elementMethods.clickElement(casutaOkCancelButonElement);

        alertMethods.cancelAlert();

        alertOptions.get(2).click();
        WebElement casutaTextButonElement = driver.findElement(By.cssSelector("#Textbox button"));
        elementMethods.clickElement(casutaTextButonElement);

        alertMethods.acceptFillAlert("orice vrem sa scriem");

    }
}
