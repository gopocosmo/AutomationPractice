package Pages;

import Help.ElementMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Switch')]")
    private WebElement switchToelement;
    @FindBy(xpath = "//a[contains(text(),'Frames')]")
    private WebElement frameElement;
    @FindBy(xpath = "//a[contains(text(),'Alert')]")
    private WebElement alertElement;
    @FindBy(xpath = "//a[contains(text(),'Windows')]")
    private WebElement windowElement;

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
    @FindBy(css = "textarea[ng-model='Adress']")
    private WebElement adresaElement;
    @FindBy(id = "imagesrc")
    private WebElement imageElement;
    @FindBy(css = "input[type='email']")
    private WebElement emailElement;
    @FindBy(css = "input[type='tel']")
    private WebElement telElement;
    @FindBy(css = "input[type='radio']")
    private List<WebElement> genderListElement;
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> hobbyListElement;
    @FindBy(id = "msdd")
    private WebElement languageElement;
    @FindBy(xpath = "//li[@class='ng-scope']/a")
    private List<WebElement> languageElements;
    @FindBy(id = "Skills")
    private WebElement skillsElement;
    @FindBy(css = "span[aria-labelledby='select2-country-container']")
    private WebElement countryElement;
    @FindBy(id = "yearbox")
    private WebElement yearElement;
    @FindBy(css = "select[placeholder='Month']")
    private WebElement monthElement;
    @FindBy(id = "daybox")
    private WebElement dayElement;
    @FindBy(id = "firstpassword")
    private WebElement parolaElement;
    @FindBy(id = "secondpassword")
    private WebElement confirmareParolaElement;
    @FindBy(id = "submitbtn")
    private WebElement submitElement;



    public void goToFramePage(){
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(frameElement);
        String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to(url);
    }

    public void goToAlertPage(){
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(alertElement);
        String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to(url);

    }

    public void goToWindowPage(){
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(windowElement);
        String url = "http://demo.automationtesting.in/Windows.html";
        driver.navigate().to(url);

    }

    public void validRegisterProcess(HashMap<String, String> values){
        fillFirstName(values.get("firstName"));
        fillLastName(values.get("lastName"));
        fillEmail(values.get("email"));
        fillAdresa(values.get("address"));
        fillTelefon(values.get("phone"));
        clickGender(values.get("gender"));
        clickHobby(values.get("hobby"));
        sendPicture(values.get("picture"));
        chooseLanguage(values.get("language"));
    }

    public void fillFirstName(String value){
        elementMethods.fillElement(firstNameElement,value);

    }

    public void fillLastName(String value){
        elementMethods.fillElement(lastNameElement,value);

    }

    public void fillAdresa(String value){
        elementMethods.fillElement(adresaElement,value);

    }

    public void sendPicture(String value){
        imageElement.sendKeys(value);

    }

    public void fillEmail(String value){
        elementMethods.fillElement(emailElement,value);

    }

    public void fillTelefon(String value){
        elementMethods.fillElement(telElement,value);

    }

    public void clickGender(String gender){
        switch (gender){
            case "Male":
                elementMethods.clickElement(genderListElement.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderListElement.get(1));
                break;
        }
    }

    public void clickHobby(String hobby){
        switch (hobby){
            case "Cricket":
                elementMethods.clickElement(hobbyListElement.get(0));
                break;
            case "Movies":
                elementMethods.clickElement(hobbyListElement.get(1));
                break;
            case "Hockey":
                elementMethods.clickElement(hobbyListElement.get(2));
                break;
        }
    }

    public void chooseLanguage(String language){
        elementMethods.scrollByPixel(0,500);
        elementMethods.clickElement(languageElement);
        for(WebElement element: languageElements){
            if(element.getText().equals(language)){
                element.click();
                break;
            }
        }
    }

//    /language
//
//
//    //clic altundeva pe pagina pt a inchide dropdownul de la language
//        elementMethods.clickElement(genderElement);
//
//    //skills
//    WebElement skillsElement = getDriver().findElement(By.id("Skills"));
//        elementMethods.selectByTextElement(skillsElement,"Android");
//
//    //dam scroll
//        elementMethods.scrollByPixel(0,500);
//
//
//
//    //country
//    WebElement countryElement = getDriver().findElement(By.cssSelector("span[aria-labelledby='select2-country-container']"));
//        elementMethods.clickElement(countryElement);
//    /*
//            //parcurgem lista de tari si selectam tara dorita
//            List<WebElement> countryElements = driver.findElements(By.xpath("//*[@id='country']/option"));
//            for (Integer i = 0;i < countryElements.size();i++){
//                if (countryElements.get(i).getText().equals("India")){
//                    countryElements.get(i).click();
//                }
//            }
//    */
//    //anul
//    WebElement yearElement = getDriver().findElement(By.id("yearbox"));
//        elementMethods.selectByValueElement(yearElement,"1970");
//
//    //luna
//    WebElement monthElement = getDriver().findElement(By.cssSelector("select[placeholder='Month']"));
//        elementMethods.selectByTextElement(monthElement,"May");
//
//    //ziua
//    WebElement dayElement = getDriver().findElement(By.id("daybox"));
//    Select daySelect = new Select(dayElement);
//        daySelect.selectByValue("22");
//
//    //parola
//    WebElement parolaElement = getDriver().findElement(By.id("firstpassword"));
//    String parolaElementValoare = "parola123";
//        elementMethods.fillElement(parolaElement,parolaElementValoare);
//
//
//    //confirmare parola
//    WebElement confirmareParolaElement = getDriver().findElement(By.id("secondpassword"));
//    String confirmareParolaElementValoare = "parola123";
//        elementMethods.fillElement(confirmareParolaElement,confirmareParolaElementValoare);
//
//

//
//    //click "submit"
//    WebElement submitElement = getDriver().findElement(By.id("submitbtn"));
//        elementMethods.clickElement(submitElement);
//
//
//
//    //comparam url-ul curent cu url-ul paginii de register, daca nu s-a schimbat nu a trecut testul
//    String actualRegisterDoi = getDriver().getTitle();
//    String urlPagina = "http://demo.automationtesting.in/Register.html";
//        Assert.assertTrue("Testul NU a functionat",urlPagina.contains("Register"));
//
//


}
