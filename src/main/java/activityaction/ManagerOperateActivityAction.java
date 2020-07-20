package activityaction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Utils;

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

        try {
            if (child==MaterialManagerActivity){

                for (MobileElement item:list){

                    if ("食材管理".equals(item.getText())){
                        Utils.print("点击进入食材管理");
                        clickDelay(item);
                    }
                }

            }
        }catch (Throwable throwable){
            Utils.print("管理操作列表点击报错");
            throwable.printStackTrace();
        }

        return checkCurrent(child);
    }
}
