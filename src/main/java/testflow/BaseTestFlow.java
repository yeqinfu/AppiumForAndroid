package testflow;

import activityaction.base.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;
import router.DefaultRouterImpl;
import router.IRouter;
import utils.Utils;

public class BaseTestFlow implements TestFlow {
    protected AndroidDriver driver;
    protected IRouter iRouter;

    public BaseTestFlow(AndroidDriver driver) {
        this.driver = driver;
        iRouter=new DefaultRouterImpl();
    }

    public void startTest() {
        Utils.print("当前测试流:"+this.getClass().getSimpleName());
        sleep();

    }
    protected void toTargetActivity(ActivityEnum activityEnum){
        iRouter.currentToTarget(driver,activityEnum);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
