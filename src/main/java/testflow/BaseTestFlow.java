package testflow;

import io.appium.java_client.android.AndroidDriver;

public class BaseTestFlow implements TestFlow {
    protected AndroidDriver driver;

    public BaseTestFlow(AndroidDriver driver) {
        this.driver = driver;
    }

    public void startTest() {

    }
}
