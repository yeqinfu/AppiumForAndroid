package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testaccount.TestIP;

public class SettingActivityAction extends BaseActivityAction{
    public SettingActivityAction(AndroidDriver driver) {
        super(driver);
    }

    public void popCurrentActivity() {
        clickDelay("title_left");

    }

    public void toLoginActivity() {
        clickDelay("rlLogout");

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child==ActivityEnum.LoginActivity){
            toLoginActivity();
        }
        return checkCurrent(child);
    }

    public void parseIP(TestIP ip) {

       // driver.findElementById("iivIP").findElement(By.id("etCenter")).sendKeys(ip.getIp());
       // driver.findElementById("iivPort").findElement(By.id("etCenter")).sendKeys(ip.getIp());
        clickDelay("tvSubmit");


    }
}
