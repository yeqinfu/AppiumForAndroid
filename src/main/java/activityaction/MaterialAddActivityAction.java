package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class MaterialAddActivityAction extends BaseActivityAction{
    public MaterialAddActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void doAllActions() {
        super.doAllActions();
        //设置页面内容工作
        //条码
        findItemInputView("iivBarCode","测试条码001");
        //选择品名
        clickDelay("iivProductName");
        //选择一个默认的第一个产品
        clickDelay("tvSure");
        //findItemInputView("iivBarCode","测试条码001");
        //数量3
        findItemInputView("iivPurchaseNumber","3");

        //选择图片
        clickDelay("ivAddImage");
        //
    }

    @Override
    public void popCurrentActivity() {
        clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
