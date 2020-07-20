package activityaction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import static activityaction.ActivityEnum.MaterialManagerActivity;

public class ManagerOperateActivityAction extends BaseActivityAction{
    public ManagerOperateActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {

       clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        List<MobileElement> list= ((AndroidElement)driver.findElementById("rvOperator")).findElementsById("tvOperator");

        if (child==MaterialManagerActivity){

            for (MobileElement item:list){

                if (item.getText().equals("食材管理")){
                    clickDelay(item);
                }
            }

        }
        return checkCurrent(child);
    }
}
