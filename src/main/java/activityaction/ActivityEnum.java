package activityaction;

import io.appium.java_client.android.AndroidDriver;

/**
 * 页面路由清单
 */
public enum ActivityEnum {

    SettingActivity("settingActivity", ".ui.me.SettingActivity",
            new String[]{
                    ".ui.LoginActivity"

            }),
    MainActivity("mainActivity", ".ui.MainActivity",
            new String[]{
                    SettingActivity.activityPath
            }
    ),
    NetSettingActivity("NetSettingActivity", ".ui.NetSettingActivity",
            new String[]{
            }),

    LoginActivity("loginActivity",
            ".ui.LoginActivity",

            new String[]{
                    NetSettingActivity.activityPath,
                    MainActivity.activityPath,

            }),
    LaunchActivity("launchActivity",
            ".ui.launchActivity",
            new String[]{
                    MainActivity.activityPath,
                    LoginActivity.activityPath
            }),


    ;
    String activity;
    String activityPath;
    //当前activity能进到其他的activity有哪些？
    private String[] childList;

    ActivityEnum(String activity, String activityPath, String[] childList) {
        this.activity = activity;
        this.activityPath = activityPath;
        this.childList = childList;
    }


    public String[] getChildList() {
        return childList;
    }

    public void setChildList(String[] childList) {
        this.childList = childList;
    }


    public static ActivityEnum getActivityEnumByPath(String path) {
        for (ActivityEnum item : ActivityEnum.values()) {
            if (item.activityPath.equals(path)) {
                return item;
            }
        }
        return null;
    }

    public static ActivityAction getActivityActionByPath(AndroidDriver driver, String path) {
        ActivityEnum target = getActivityEnumByPath(path);
        if (target == null) {
            return null;
        }
        switch (target) {
            case MainActivity:
                return new MainActivityAction(driver);
            case LoginActivity:
                return new LoginActivityAction(driver);
            case SettingActivity:
                return new SettingActivityAction(driver);
        }

        return null;
    }


    /**
     * 判断理论路径是否可行
     *
     * @param target
     * @return
     */
    public boolean canGoToTarget(ActivityEnum target) {
        if (this == target) {
            return true;
        }
        for (String child : childList) {
            ActivityEnum childActivityEnum = ActivityEnum.getActivityEnumByPath(child);
            if (childActivityEnum.canGoToTarget(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean tryGoToTarget(AndroidDriver driver, ActivityEnum target, String[] tempChildList) {
        //当前就是指定要到的节点
        if (this == target) {
            return true;
        }
        //孩子节点是否可以进去
        for (String child : tempChildList) {
            ActivityEnum childActivityEnum=ActivityEnum.getActivityEnumByPath(child);
            if (childActivityEnum.canGoToTarget(target)) {//子列表可以进去
                //无条件相信
                ActivityAction childAction = ActivityEnum.getActivityActionByPath(driver, childActivityEnum.activityPath);
                boolean result = childAction.goToChild(driver, childActivityEnum);
                if (result) {//进入成功
                    return true;
                } else {
                    childAction.popCurrentActivity();
                }
            }
        }
        return false;
    }
}
