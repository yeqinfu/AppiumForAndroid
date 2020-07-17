package testapplication.foodsafety;

import activityaction.ActivityAction;
import activityaction.ActivityEnum;
import activityaction.LoginActivityAction;
import io.appium.java_client.android.AndroidDriver;
import testaccount.TestAccount;
import testaccount.TestIP;
import testflow.BaseTestFlow;

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
        //登录流程
        ActivityEnum activityEnum=ActivityEnum.getActivityEnumByPath(driver.currentActivity());
        ActivityAction activityAction= ActivityEnum.getActivityActionByPath(driver,driver.currentActivity());
        if (activityAction==null){
            return;
        }
        if (activityEnum!=ActivityEnum.loginActivity){//不是登录页面
            activityAction.toLoginActivity();
            activityAction= ActivityEnum.getActivityActionByPath(driver,driver.currentActivity());
        }
        startLogin(activityAction);


    }

    private void startLogin(ActivityAction activityAction) {
        if (activityAction instanceof LoginActivityAction) {
            ((LoginActivityAction) activityAction).startLogin(ip,account);
        }
    }
}
