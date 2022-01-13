package Tests;

import Base.Hooks;
import Help.AlertMethods;
import Help.ElementMethods;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertTest extends Hooks {
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public AlertPage alertPage;

    @Test
    public void testAutomat() {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        alertPage = new AlertPage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.goToAlertPage();
        alertPage.alertOkProcess();
        alertPage.alertOkCancelProcess();
        alertPage.alertTextBoxProcess(inputData.get("alertTextBox"));
    }
}
