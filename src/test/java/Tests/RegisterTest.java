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

        //verificam daca suntem pe pagina care trebuie
        //validare pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register",actualRegister);

        //first name
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameElementvaloare = "Augustin";
        firstNameElement.sendKeys(firstNameElementvaloare);

        //last name
        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameElementvaloare = "Patron";
        lastNameElement.sendKeys(lastNameElementvaloare);

        //adresa
        WebElement adresaElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String adresaElementValoare = "Cluj nr 23";
        adresaElement.sendKeys(adresaElementValoare);

        //incarcam o poza
        WebElement imageElement = driver.findElement(By.id("imagesrc"));
        imageElement.sendKeys("C:\\Users\\Gopo\\Pictures\\1.jpg");


        /*

        //email
        WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        String emailElementValoare = "ceva@ceva.com";
        emailElement.sendKeys(emailElementValoare);

        //telefon
        WebElement telElement = driver.findElement(By.cssSelector("input[type='tel']"));
        String telElementValoare = "0264212666";
        telElement.sendKeys(telElementValoare);

        //gender
        WebElement genderElement = driver.findElement(By.cssSelector("input[value='Male']"));
        genderElement.click();

        //hobby
        WebElement hobbyElement = driver.findElement(By.id("checkbox3"));
        hobbyElement.click();

        //language
        WebElement languageElement = driver.findElement(By.id("msdd"));
        languageElement.click();

        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0;i < languageElements.size();i++){
            if (languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
            }
        }

        //clic altundeva pe pagina pt a inchide dropdownul de la language
        genderElement.click();

        //skills
        WebElement skillsElement = driver.findElement(By.id("Skills"));
        Select skillSelect = new Select(skillsElement);
        skillSelect.selectByVisibleText("Android");



        //country
        WebElement countryElement = driver.findElement(By.cssSelector("span[aria-labelledby='select2-country-container']"));
        countryElement.click();

        //parcurgem lista de tari si selectam tara dorita
        List<WebElement> countryElements = driver.findElements(By.xpath("//*[@id='country']/option"));
        for (Integer i = 0;i < countryElements.size();i++){
            if (countryElements.get(i).getText().equals("India")){
                countryElements.get(i).click();
            }
        }

        //anul
        WebElement yearElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1970");

        //luna
        WebElement monthElement = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByValue("May");

        //ziua
        WebElement dayElement = driver.findElement(By.id("daybox"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("22");

        //parola
        WebElement parolaElement = driver.findElement(By.id("firstpassword"));
        String parolaElementValoare = "parola123";
        parolaElement.sendKeys(parolaElementValoare);

        //confirmare parola
        WebElement confirmareParolaElement = driver.findElement(By.id("secondpassword"));
        String confirmareParolaElementValoare = "parola123";
        confirmareParolaElement.sendKeys(confirmareParolaElementValoare);

        //click "submit"
        WebElement submitElement = driver.findElement(By.id("submitbtn"));
        submitElement.click();



        //comparam url-ul curent cu url-ul paginii de register, daca nu s-a schimbat nu a trecut testul
        String actualRegisterDoi = driver.getTitle();
        String urlPagina = "http://demo.automationtesting.in/Register.html";
        Assert.assertEquals("Testul NU a functionat",actualRegisterDoi,urlPagina);


         */


    }
}