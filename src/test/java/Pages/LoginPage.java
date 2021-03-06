package Pages;

import Help.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "input[placeholder='E mail']")
    private WebElement emailElement;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement parolaElement;
    @FindBy(id = "enterbtn")
    private WebElement enterElement;
    @FindBy(id = "errormsg")
    private WebElement eroareElement;

    public void InvalidLogin(HashMap<String, String> values){
        elementMethods.fillElement(emailElement, values.get("email"));
        elementMethods.fillElement(parolaElement, values.get("password"));
        elementMethods.clickElement(enterElement);
        elementMethods.validateElementMessage(eroareElement, values.get("message"));
    }
}
