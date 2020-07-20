package activityaction;

import io.appium.java_client.android.AndroidDriver;

/**
 * 在一个activity可能出现的操作抽象
 * 每一个activity需要完成到这个activity到此技或者上级页面的所有操作
 *
 */
public interface ActivityAction {
    void doAllActions();
    //退出当前activity
    void popCurrentActivity();
    boolean goToChild(AndroidDriver driver, ActivityEnum child);
    boolean checkCurrent(ActivityEnum target);
}
