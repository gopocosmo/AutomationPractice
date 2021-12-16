package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    //webdriver = variabila care ne ajuta sa interactionam cu site-ul si elementele acestuia

    public WebDriver driver;

    @Test
    public void testAutomat(){
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        //deschidem un browser
        driver = new ChromeDriver();
        //introducem o adresa web
        driver.get("http://demo.automationtesting.in/Index.html");
        //schimbam rezolutia in full-screen sau maximize
        driver.manage().window().maximize();

        //identificam elementul "sign in"
        WebElement signInElement = driver.findElement(By.id("btn1"));
        //facem un click
        signInElement.click();

        //identificare element dupa "locaters" : id, class, name, link, css, xpath

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "ceva@ceva.com";
        emailElement.sendKeys(emailValue);

        WebElement parolaElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String parolaValue = "parolaInspargibila";
        parolaElement.sendKeys(parolaValue);
        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement eroareElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = eroareElement.getText();
        Assert.assertEquals("MESAJUL DE PE PAGINA NU ESTE CORECT!!!",expectedError, actualError);









    }

}
