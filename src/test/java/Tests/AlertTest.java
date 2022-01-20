package Tests;

import Base.Hooks;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import com.aventstack.extentreports.Status;
import org.junit.Test;

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
        report.logger.log(Status.PASS,"Click to sign in");
        registerPage.goToAlertPage();
        report.logger.log(Status.PASS,"Go to Alert");
        alertPage.alertOkProcess();
        report.logger.log(Status.PASS,"Deal with OK Alert");
        alertPage.alertOkCancelProcess();
        report.logger.log(Status.PASS,"Deal with OK/Cancel Alert");
        alertPage.alertTextBoxProcess(inputData.get("alertTextBox"));
        report.logger.log(Status.PASS,"Deal with Text Box Alert");
    }
}
