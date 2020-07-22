package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import testaccount.TestAccount;
import testaccount.TestIP;
import utils.Utils;

import static activityaction.ActivityEnum.MainActivity;
import static activityaction.ActivityEnum.NetSettingActivity;


public class LoginActivityAction extends BaseActivityAction{

    public void popCurrentActivity() {
     //   driver.quit();

        Utils.print("登录页面调用了popz直接就是失败");
        Assert.assertThrows(new Assert.ThrowingRunnable() {
            @Override
            public void run() throws Throwable {

            }
        });
    }



    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child== NetSettingActivity){//登录页面进入
            toNetSettingActivity();
        }else if (child== MainActivity){
            toMainActivity();
        }

        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                NetSettingActivity,
                MainActivity
        };
    }

    private void toMainActivity() {
        clickDelay("btnLogin");
        Utils.print("登录页面比较慢 睡眠");
        sleep();
        sleep();
        Utils.print("登录页面比较慢 睡眠结束");

    }


    public void toNetSettingActivity(){
        clickDelay("tvSetting");
    }

    public void startLogin(TestIP ip, TestAccount account) {
        //设置IP 端口
        toNetSettingActivity();
        sleep();
        NetSettingActivityAction netSettingActivityAction=new NetSettingActivityAction();
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
