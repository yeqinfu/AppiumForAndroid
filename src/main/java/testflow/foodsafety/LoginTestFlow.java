package testflow.foodsafety;

import activityaction.base.ActivityAction;
import activityaction.base.ActivityEnum;
import activityaction.LoginActivityAction;
import io.appium.java_client.android.AndroidDriver;
import testaccount.TestAccount;
import testaccount.TestIP;
import testflow.BaseTestFlow;
import utils.Utils;

public class LoginTestFlow extends BaseTestFlow {

    //测试IP
    TestIP ip;
    //测试账号
    TestAccount account;

    public LoginTestFlow(AndroidDriver driver, TestIP ip, TestAccount account) {
        super(driver);
        this.ip = ip;
        this.account = account;
    }


    public void startTest() {
        super.startTest();
        //登录流程第一步 确保在登录页面
        boolean result = iRouter.currentToTarget(driver, ActivityEnum.LoginActivity);
        if (result){//确保成功
            Utils.print("确保了在登录页面");
        }else{
            return;
        }

        //登录流程
        ActivityAction activityAction = ActivityEnum.getActivityActionByPath(driver, driver.currentActivity());
        startLogin(activityAction);
    }

    private void startLogin(ActivityAction activityAction) {
        if (activityAction instanceof LoginActivityAction) {
            ((LoginActivityAction) activityAction).startLogin(ip, account);
        }
    }
}
