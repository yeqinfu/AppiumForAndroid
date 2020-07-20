package activityaction;

import io.appium.java_client.android.AndroidDriver;

import static activityaction.ActivityEnum.OperateChooseActivity;

/**
 * MainActivity范围内的动作放在这里
 *
 */
public class MainActivityAction extends BaseActivityAction{
    public MainActivityAction(AndroidDriver driver) {
        super(driver);
    }

    public void popCurrentActivity() {
        //因为在main的时候就相当于退出测试
        driver.quit();
    }



    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child==ActivityEnum.SettingActivity){
            clickDelay("rBtnTabMe");
            clickDelay("rlSetting");
        }else if (child==ActivityEnum.AboutActivity){
            clickDelay("rBtnTabMe");
            clickDelay("rlAbout");
        }else  if (child==OperateChooseActivity){
            if (isExist("cvSchoolInfo")){//具体的单位
                clickDelay("cvSchoolInfo");
            }else{

            }
        }
        return checkCurrent(child);
    }

}
