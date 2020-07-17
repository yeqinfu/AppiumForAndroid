package activityaction;

import io.appium.java_client.android.AndroidDriver;

/**
 * 页面路由清单
 */
public enum ActivityEnum {
    loginActivity("loginActivity", ".ui.LoginActivity"),
    mainActivity("mainActivity", ".ui.MainActivity"),
    settingActivity("settingActivity", ".ui.me.SettingActivity"),
    ;
    String activity;
    String activityPath;


    ActivityEnum(String activity, String activityPath) {
        this.activity = activity;
        this.activityPath = activityPath;
    }
    public static ActivityEnum getActivityEnumByPath(String path){
        for (ActivityEnum item:ActivityEnum.values()){
            if (item.activityPath.equals(path)){
                return item;
            }
        }
        return  null;
    }
    public static ActivityAction getActivityActionByPath(AndroidDriver driver,String path){
        ActivityEnum target=getActivityEnumByPath(path);
        if (target==null){
            return null;
        }
        switch (target){
            case mainActivity:
                return new MainActivityAction(driver);
            case loginActivity:
                return new LoginActivityAction(driver);
            case settingActivity:
                return new SettingActivityAction(driver);
        }

        return null;
    }

}
