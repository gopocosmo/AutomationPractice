package Tests;

import Base.SharedData;
import Pages.IndexPage;
import Pages.LoginPage;
import org.junit.Test;

public class LoginTest extends SharedData {
    public IndexPage indexPage;
    public LoginPage loginPage;

    @Test
    public void testAutomat(){
        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);

        indexPage.clickSignIn();
        loginPage.InvalidLogin("alex","dorha","Invalid User Name or PassWord");
    }
}
