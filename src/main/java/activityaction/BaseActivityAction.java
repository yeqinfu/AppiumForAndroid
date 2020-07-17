package activityaction;

import io.appium.java_client.android.AndroidDriver;

public abstract class BaseActivityAction implements ActivityAction{
    protected AndroidDriver driver;

    public BaseActivityAction(AndroidDriver driver) {
        this.driver = driver;
    }
}
