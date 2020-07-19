package testflow;

import io.appium.java_client.android.AndroidDriver;
import router.DefaultRouterImpl;
import router.IRouter;

public class BaseTestFlow implements TestFlow {
    protected AndroidDriver driver;
    protected IRouter iRouter;

    public BaseTestFlow(AndroidDriver driver) {
        this.driver = driver;
        iRouter=new DefaultRouterImpl();
    }

    public void startTest() {

    }
}
