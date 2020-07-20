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



    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child==ActivityEnum.NetSettingActivity){//登录页面进入
            toNetSettingActivity();
        }else if (child==ActivityEnum.MainActivity){
            toMainActivity();
        }

        return checkCurrent(child);
    }

    private void toMainActivity() {
        clickDelay("btnLogin");
    }


    public void toNetSettingActivity(){
        clickDelay("tvSetting");
    }

    public void startLogin(TestIP ip, TestAccount account) {
        //设置IP 端口
        toNetSettingActivity();
        sleep();
        NetSettingActivityAction netSettingActivityAction=new NetSettingActivityAction(driver);
        netSettingActivityAction.setAppIp(ip);
        sleep();
        parseAccount(account);
        toMainActivity();
    }

    private void parseAccount(TestAccount account) {
        driver.findElementById("etUserName").sendKeys(account.getAccount());
        driver.findElementById("etPassword").sendKeys(account.getPassword());
    }
}
