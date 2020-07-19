package router;

import activityaction.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;

/**
 * 路由算法 抽象
 */
public interface IRouter {
     boolean currentToTarget(AndroidDriver driver, ActivityEnum target);
}
