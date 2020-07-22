package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.Utils;

import java.util.List;

public class MultiImageSelectorActivityAction extends BaseActivityAction {


    @Override
    public void popCurrentActivity() {
        AndroidElement element= (AndroidElement) driver.findElementById("toolbar");

        Activity activity;

        List<MobileElement> list= element.findElements(By.className("android.widget.ImageButton"));
        for (MobileElement item:list){
            item.click();
        }
        Utils.print("MultiImageSelectorActivityAction 点击了退出");

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[0];
    }

    public void selectPic() {
        clickDelay("image");
        clickDelay("commit");

    }
}
