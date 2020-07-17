package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testaccount.TestIP;

public class SettingActivityAction extends BaseActivityAction{
    public SettingActivityAction(AndroidDriver driver) {
        super(driver);
    }

    public void popCurrentActivity() {
        driver.findElementById("title_left").click();

    }

    public void toLoginActivity() {
        driver.findElementById("rlLogout").click();

    }

    public void parseIP(TestIP ip) {
        driver.findElementById("iivIP").findElement(By.id("etCenter")).sendKeys(ip.getIp());
        driver.findElementById("iivPort").findElement(By.id("etCenter")).sendKeys(ip.getIp());
        driver.findElementById("tvSubmit").click();


    }
}
