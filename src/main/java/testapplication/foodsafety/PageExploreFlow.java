package testapplication.foodsafety;

import activityaction.AboutActivityAction;
import activityaction.ActivityEnum;
import activityaction.SettingActivityAction;
import io.appium.java_client.android.AndroidDriver;
import testflow.BaseTestFlow;
import testflow.TestFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有页面都浏览一遍的flow
 */
public class PageExploreFlow extends BaseTestFlow {
    public PageExploreFlow(AndroidDriver driver) {
        super(driver);
        list=new ArrayList<>();
    }
    List<TestFlow> list;

    @Override
    public void startTest() {
        //执行进入关于产品页面
        iRouter.currentToTarget(driver, ActivityEnum.AboutActivity);
        //执行进入设置页面
        iRouter.currentToTarget(driver,ActivityEnum.SettingActivity);


    }
}
