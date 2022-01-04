package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void testAutomat() {


        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //interactionam cu tabul "switch to"
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).perform();

        //identificam "Windows"
        WebElement windowsElement = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        windowsElement.click();
        String url = "http://demo.automationtesting.in/Windows.html";
        driver.navigate().to(url);
        //driver.navigate().refresh();

        List<WebElement> windowOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        windowOptions.get(0).click();
        WebElement clickButonElement = driver.findElement(By.cssSelector("#Tabbed a button"));
        clickButonElement.click();

        System.out.println("titlul paginii" + driver.getTitle());

        //interactionam cu taburile nou deschise
        //salvam taburile intr-o lista noua
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();

        driver.switchTo().window(tabs.get(0));

        windowOptions.get(1).click();
        WebElement clickWindowElement = driver.findElement(By.cssSelector("#Seperate  button"));
        clickWindowElement.click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();
        driver.switchTo().window(windows.get(0));


        windowOptions.get(2).click();
        WebElement clickTabsElement = driver.findElement(By.cssSelector("#Multiple button"));
        clickTabsElement.click();
        List<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));
        driver.close();
        driver.switchTo().window(multipleTabs.get(1));
        driver.close();
        driver.switchTo().window(multipleTabs.get(0));

    }
}