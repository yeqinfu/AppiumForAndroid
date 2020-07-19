package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseActivityAction implements ActivityAction{
    protected AndroidDriver driver;

    public BaseActivityAction(AndroidDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean checkCurrent(ActivityEnum target) {
        return target==ActivityEnum.getActivityEnumByPath(driver.currentActivity());
    }

    protected void clickDelay(String id){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById(id).click();
    }

    protected void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
