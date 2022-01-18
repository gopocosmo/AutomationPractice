package Pages;

import Help.ElementMethods;
import Help.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "ul[class='nav nav-tabs nav-stacked'] li a")
    private List<WebElement> windowOptions;
    @FindBy(css = "#Tabbed a button")
    private WebElement clickButonElement;
    @FindBy(css = "#Seperate  button")
    private WebElement clickWindowElement;
    @FindBy(css = "#Multiple button")
    private WebElement clickTabsElement;




    public void switchToWindow(){
        windowMethods.switchToSpecificWindow(1,2);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0, 1);
    }

    public void switchToWindows(){
        windowMethods.switchToSpecificWindow(2, 3);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(1, 2);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0, 1);
    }


    public void tabProcess(){
        windowOptions.get(0).click();
        elementMethods.clickElement(clickButonElement);
        switchToWindow();
    }

    public void seperateProcess(){
        windowOptions.get(1).click();
        elementMethods.clickElement(clickWindowElement);
        switchToWindow();
    }

    public void multipleProcess(){
        windowOptions.get(2).click();
        elementMethods.clickElement(clickTabsElement);
        switchToWindows();
    }


}
