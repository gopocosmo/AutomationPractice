package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
    public WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificWindow(Integer index, Integer expectedWindows){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.numberOfWindowsToBe(expectedWindows));
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        System.out.println("titlul paginii" + driver.getTitle());

    }

    public void closeCurrentWindow(){
        driver.close();
    }
}
