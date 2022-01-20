package Tests;

import Base.Hooks;
import Pages.IndexPage;
import Pages.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.Test;

public class LoginTest extends Hooks {

    public IndexPage indexPage;
    public LoginPage loginPage;

    @Test
    public void testAutomat(){
        indexPage = new IndexPage(getDriver());
        loginPage = new LoginPage(getDriver());

        indexPage.clickSignIn();
        report.logger.log(Status.PASS,"Click sign in Button");
        loginPage.InvalidLogin(inputData);
        report.logger.log(Status.PASS,"Invalid Login");
    }
}
