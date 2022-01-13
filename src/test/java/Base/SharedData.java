package Base;

import PropertyUtility.PropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void initiateDriver(){
        PropertyFile driverResource = new PropertyFile("DriverData/DriverResource");
        //specificam unde se afla driverul pt browser
        System.setProperty(driverResource.getValue("driverBrowser"),driverResource.getValue("location"));
        //deschidem un browser
        driver = new ChromeDriver();
        //introducem o adresa web
        driver.get(driverResource.getValue("url"));
        //schimbam rezolutia in full-screen sau maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitBrowser(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
