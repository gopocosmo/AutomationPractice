package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.WindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;


    @Test
    public void testAutomat() {
        elementMethods = new ElementMethods(getDriver());
        windowMethods = new WindowMethods(getDriver());


        //gasim "skip sign in element"
        WebElement skipSignInElement = getDriver().findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //interactionam cu tabul "switch to"
        WebElement switchToElement = getDriver().findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.hoverElement(switchToElement);

        //identificam "Windows"
        WebElement windowsElement = getDriver().findElement(By.xpath("//a[contains(text(),'Windows')]"));
        elementMethods.clickElement(windowsElement);

        String url = "http://demo.automationtesting.in/Windows.html";
        getDriver().navigate().to(url);
        //driver.navigate().refresh();

        List<WebElement> windowOptions = getDriver().findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        windowOptions.get(0).click();
        WebElement clickButonElement = getDriver().findElement(By.cssSelector("#Tabbed a button"));
        elementMethods.clickElement(clickButonElement);


        System.out.println("titlul paginii" + getDriver().getTitle());

        //interactionam cu taburile nou deschise
        //salvam taburile intr-o lista noua
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);

        windowOptions.get(1).click();
        WebElement clickWindowElement = getDriver().findElement(By.cssSelector("#Seperate  button"));
        elementMethods.clickElement(clickWindowElement);

        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);


        windowOptions.get(2).click();
        WebElement clickTabsElement = getDriver().findElement(By.cssSelector("#Multiple button"));
        elementMethods.clickElement(clickTabsElement);

        windowMethods.switchToSpecificWindow(2);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);

    }
}