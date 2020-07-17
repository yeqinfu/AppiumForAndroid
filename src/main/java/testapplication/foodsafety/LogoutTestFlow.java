package testapplication.foodsafety;

import activityaction.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;
import testflow.BaseTestFlow;
import testflow.TestFlow;

/**
 * 登出 测试流程
 * 登出流程
 * 我告诉你我现在在哪个activity
 * 你就要执行一系列的动作一直到登出逻辑完成
 * 所以需要一个倒叙
 */
public class LogoutTestFlow extends BaseTestFlow {
    public LogoutTestFlow(AndroidDriver driver) {
        super(driver);
    }

    public void startTest() {

        //无论是哪个页面 都有一个登出的方法，直接执行就行了
        ActivityEnum.getActivityActionByPath(driver,driver.currentActivity()).toLoginActivity();


    }
}
