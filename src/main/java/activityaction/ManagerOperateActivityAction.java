package activityaction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.Utils;

import java.util.List;

import static activityaction.ActivityEnum.*;

public class ManagerOperateActivityAction extends BaseActivityAction {

    @Override
    public void popCurrentActivity() {

        clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        List<MobileElement> list = ((AndroidElement) driver.findElementById("rvOperator")).findElementsById("tvOperator");
        if (child == MaterialManagerActivity) {
            toTargetPage(list, "食材管理");
        }else if (child==DisinfectManagerActivity){
            toTargetPage(list,"消毒管理");
        }else if (child==PersonHealthyActivity){
            toTargetPage(list,"人员健康");
        }else if (child==ReservedRecordActivity){
            toTargetPage(list,"留样操作");

        }


        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                MaterialManagerActivity,
                DisinfectManagerActivity,
                PersonHealthyActivity,
                ReservedRecordActivity

        };
    }

    private void toTargetPage(List<MobileElement> list,  String text) {
        try {
            for (MobileElement item : list) {
                if (text.equals(item.getText())) {
                    Utils.print("点击进入" + text);
                    clickDelay(item);
                }
            }

        } catch (Throwable throwable) {
            Utils.print("以下报错可忽略" + text);
            throwable.printStackTrace();
        }
    }
}
