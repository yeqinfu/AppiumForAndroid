package activityaction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import utils.Utils;

public abstract class BaseActivityAction implements ActivityAction {
    protected AndroidDriver driver;

    @Override
    public void doAllActions() {


    }

    public BaseActivityAction(AndroidDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean checkCurrent(ActivityEnum target) {
        return target == ActivityEnum.getActivityEnumByPath(driver.currentActivity());
    }

    protected boolean isExist(String id){
        return driver.findElementById(id)!=null;
    }
    protected void clickDelay(String id) {

        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElementById(id);
            if (webElement==null){
                Utils.print("当前页面ID"+id+"不存在");
                return;
            }
            webElement.click();
        } catch (Throwable e) {
            Utils.print("当前点击步骤出错"+id);
            e.printStackTrace();
        }

    }

    protected void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void findItemInputView(String id,String text){
        AndroidElement target= (AndroidElement)driver.findElementById(id);
        if (target==null){
            Utils.print("当前ItemInputView"+id+"不存在");
            return;
        }
        target.findElementById("etCenter").sendKeys(text);
    }

}
