package Tests;

import Base.Hooks;
import Base.SharedData;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class RegisterTest extends Hooks {

    public IndexPage indexPage;
    public RegisterPage registerPage;


    @Test
    public void testAutomat() {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.validRegisterProcess(inputData);

    }
}