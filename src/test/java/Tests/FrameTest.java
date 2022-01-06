package Tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.FrameMethods;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameTest extends SharedData {
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public FramePage framePage;

    @Test
    public void testAutomat() {
        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
        framePage = new FramePage(driver);

        indexPage.clickSkipSignIn();
        registerPage.goToFramePage();
        framePage.dealSingleFrame("cev aa");
        framePage.dealMultipleFrame("altceva");
    }
}
