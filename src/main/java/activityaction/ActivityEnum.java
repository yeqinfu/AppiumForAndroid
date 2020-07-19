package activityaction;

import io.appium.java_client.android.AndroidDriver;

import java.util.LinkedList;

/**
 * 页面路由清单
 */
public enum ActivityEnum {
    loginActivity("loginActivity", ".ui.LoginActivity", new ActivityEnum[]{

    }),
    mainActivity("mainActivity", ".ui.MainActivity", new ActivityEnum[]{
            loginActivity
    }),
    settingActivity("settingActivity", ".ui.me.SettingActivity", new ActivityEnum[]{
            mainActivity
    }),
    ;
    String activity;
    String activityPath;
    //能进到当前activity的入口列表
    private ActivityEnum[] parentList;
    //当前activity能进到其他的activity有哪些？
    private ActivityEnum[] childList;

    public ActivityEnum[] getParentList() {
        return parentList;
    }

    public void setParentList(ActivityEnum[] parentList) {
        this.parentList = parentList;
    }

    public ActivityEnum[] getChildList() {
        return childList;
    }

    public void setChildList(ActivityEnum[] childList) {
        this.childList = childList;
    }

    ActivityEnum(String activity, String activityPath, ActivityEnum[] parentList) {
        this.activity = activity;
        this.activityPath = activityPath;
        this.parentList = parentList;
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
            case mainActivity:
                return new MainActivityAction(driver);
            case loginActivity:
                return new LoginActivityAction(driver);
            case settingActivity:
                return new SettingActivityAction(driver);
        }

        return null;
    }


    /**
     * 判断理论路径是否可行
     * @param target
     * @return
     */
    public boolean canGoToTarget(ActivityEnum target) {
        if (this==target){
            return true;
        }
        for (ActivityEnum child:childList){
            if (child.canGoToTarget(target)){
                return true;
            }
        }
        return false;
    }
    public boolean tryGoToTarget(AndroidDriver driver,ActivityEnum target,ActivityEnum[] tempChildList){
        //当前就是指定要到的节点
        if (this==target){
            return true;
        }
        //孩子节点是否可以进去
        for (ActivityEnum child:tempChildList){
            if (child.canGoToTarget(target)){//子列表可以进去
                //无条件相信
                ActivityAction childAction=ActivityEnum.getActivityActionByPath(driver,child.activityPath);
                boolean result=childAction.goToChild(driver,child);
                if (result){//进入成功
                    return true;
                }else{
                    childAction.popCurrentActivity();
                }
            }
        }
        return false;
    }
}
