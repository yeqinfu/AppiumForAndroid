package router;

import activityaction.base.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;

/**
 * 路由算法 抽象
 */
public interface IRouter {
     boolean currentToTarget(AndroidDriver driver, ActivityEnum target);
}
