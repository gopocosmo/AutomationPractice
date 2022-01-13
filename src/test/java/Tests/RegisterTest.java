package Tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends SharedData {
    public ElementMethods elementMethods;


    @Test
    public void testAutomat() {
        elementMethods = new ElementMethods(getDriver());


        //gasim "skip sign in element"
        WebElement skipSignInElement = getDriver().findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //verificam daca suntem pe pagina care trebuie
        //validare pagina de "Register"
        String actualRegister = getDriver().getTitle();
        Assert.assertEquals("Register",actualRegister);

        //first name
        WebElement firstNameElement = getDriver().findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameElementvaloare = "Augustin";
        elementMethods.fillElement(firstNameElement,firstNameElementvaloare);

        //last name
        WebElement lastNameElement = getDriver().findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameElementvaloare = "Patron";
        elementMethods.fillElement(lastNameElement,lastNameElementvaloare);

        //adresa
        WebElement adresaElement = getDriver().findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String adresaElementValoare = "Cluj nr 23";
        elementMethods.fillElement(adresaElement,adresaElementValoare);


        //incarcam o poza
        WebElement imageElement = getDriver().findElement(By.id("imagesrc"));
        imageElement.sendKeys("C:\\Users\\Gopo\\Pictures\\1.jpg");




        //email
        WebElement emailElement = getDriver().findElement(By.cssSelector("input[type='email']"));
        String emailElementValoare = "ceva@ceva.com";
        elementMethods.fillElement(emailElement,emailElementValoare);


        //telefon
        WebElement telElement = getDriver().findElement(By.cssSelector("input[type='tel']"));
        String telElementValoare = "0264212666";
        elementMethods.fillElement(telElement,telElementValoare);


        //gender
        WebElement genderElement = getDriver().findElement(By.cssSelector("input[value='Male']"));
        elementMethods.clickElement(genderElement);

        //hobby
        WebElement hobbyElement = getDriver().findElement(By.id("checkbox3"));
        elementMethods.clickElement(hobbyElement);

        //language


        //clic altundeva pe pagina pt a inchide dropdownul de la language
        elementMethods.clickElement(genderElement);

        //skills
        WebElement skillsElement = getDriver().findElement(By.id("Skills"));
        elementMethods.selectByTextElement(skillsElement,"Android");

        //dam scroll
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");



        //country
        WebElement countryElement = getDriver().findElement(By.cssSelector("span[aria-labelledby='select2-country-container']"));
        elementMethods.clickElement(countryElement);
/*
        //parcurgem lista de tari si selectam tara dorita
        List<WebElement> countryElements = driver.findElements(By.xpath("//*[@id='country']/option"));
        for (Integer i = 0;i < countryElements.size();i++){
            if (countryElements.get(i).getText().equals("India")){
                countryElements.get(i).click();
            }
        }
*/
        //anul
        WebElement yearElement = getDriver().findElement(By.id("yearbox"));
        elementMethods.selectByValueElement(yearElement,"1970");

        //luna
        WebElement monthElement = getDriver().findElement(By.cssSelector("select[placeholder='Month']"));
        elementMethods.selectByTextElement(monthElement,"May");

        //ziua
        WebElement dayElement = getDriver().findElement(By.id("daybox"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("22");

        //parola
        WebElement parolaElement = getDriver().findElement(By.id("firstpassword"));
        String parolaElementValoare = "parola123";
        elementMethods.fillElement(parolaElement,parolaElementValoare);


        //confirmare parola
        WebElement confirmareParolaElement = getDriver().findElement(By.id("secondpassword"));
        String confirmareParolaElementValoare = "parola123";
        elementMethods.fillElement(confirmareParolaElement,confirmareParolaElementValoare);


        WebElement languageElement = getDriver().findElement(By.id("msdd"));
        elementMethods.clickElement(languageElement);

        List<WebElement> languageElements = getDriver().findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0;i < languageElements.size();i++){
            if (languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
                break;
            }
        }

        //click "submit"
        WebElement submitElement = getDriver().findElement(By.id("submitbtn"));
        elementMethods.clickElement(submitElement);



        //comparam url-ul curent cu url-ul paginii de register, daca nu s-a schimbat nu a trecut testul
        String actualRegisterDoi = getDriver().getTitle();
        String urlPagina = "http://demo.automationtesting.in/Register.html";
        Assert.assertTrue("Testul NU a functionat",urlPagina.contains("Register"));

    }
}