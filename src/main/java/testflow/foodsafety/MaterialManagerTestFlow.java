package testflow.foodsafety;

import activityaction.base.ActivityEnum;
import activityaction.MaterialAddActivityAction;
import io.appium.java_client.android.AndroidDriver;
import testflow.BaseTestFlow;

/**
 * 食材管理操作测试流程
 */
public class MaterialManagerTestFlow extends BaseTestFlow {
    public MaterialManagerTestFlow(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void startTest() {
        super.startTest();
        toTargetActivity(ActivityEnum.MaterialAddActivity);
        MaterialAddActivityAction addActivityAction=new MaterialAddActivityAction();
        addActivityAction.doAllActions();
     // toTargetActivity(ActivityEnum.MainActivity);
    }
}
