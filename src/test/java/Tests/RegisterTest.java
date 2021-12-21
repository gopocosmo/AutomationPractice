package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest {
    public WebDriver driver;

    @Test
    public void testAutomat() {
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        //deschidem un browser
        driver = new ChromeDriver();
        //introducem o adresa web
        driver.get("http://demo.automationtesting.in/Index.html");
        //schimbam rezolutia in full-screen sau maximize
        driver.manage().window().maximize();

        //gasim "skip sign in element"
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //validare pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Regi2ster",actualRegister);


        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameElementvaloare = "Augustin";
        firstNameElement.sendKeys(firstNameElementvaloare);


        WebElement genderElement = driver.findElement(By.cssSelector("input[value='Male']"));
        genderElement.click();

        WebElement hobbyElement = driver.findElement(By.id("checkbox3"));
        hobbyElement.click();

        WebElement skillsElement = driver.findElement(By.id("Skills"));
        Select skillSelect = new Select(skillsElement);
        skillSelect.selectByVisibleText("Android");

        WebElement yearElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1970");

        WebElement languageElement = driver.findElement(By.id("msdd"));
        languageElement.click();

        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0;i < languageElements.size();i++){
            if (languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
            }
        }

        genderElement.click();

        //adresa
        WebElement adresaElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String adresaElementValoare = "Cluj nr 23";
        adresaElement.sendKeys(adresaElementValoare);

        //parola
        WebElement parolaElement = driver.findElement(By.id("firstpassword"));
        String parolaElementValoare = "parola123";
        parolaElement.sendKeys(parolaElementValoare);



    }
}
