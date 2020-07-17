package activityaction;

import io.appium.java_client.android.AndroidDriver;
import testaccount.TestAccount;
import testaccount.TestIP;


public class LoginActivityAction extends BaseActivityAction{
    public LoginActivityAction(AndroidDriver driver) {
        super(driver);
    }

    public void popCurrentActivity() {
        driver.quit();

    }

    public void toLoginActivity() {
        //do nothing
    }
    public void toNetSettingActivity(){
        driver.findElementById("tvSetting").click();
    }

    public void startLogin(TestIP ip, TestAccount account) {
        //设置IP 端口
        toNetSettingActivity();
        sleep();
        SettingActivityAction settingActivityAction=new SettingActivityAction(driver);
        settingActivityAction.parseIP(ip);
        sleep();
        parseAccount(account);
        clickDelay("btnLogin");


    }

    private void parseAccount(TestAccount account) {
        driver.findElementById("etUserName").sendKeys("test");
        driver.findElementById("etPassword").sendKeys("123456");
    }
}
