package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

public class MaterialAddActivityAction extends BaseActivityAction {

    @Override
    public void doAllActions() {
        super.doAllActions();
        //设置页面内容工作
        //条码




        //
    }

    public void setPager(String barcode,String PurchaseNumber){
        findItemInputView("iivBarCode",barcode);
        //选择品名
        clickDelay("iivProductName");
        //选择一个默认的第一个产品
        clickDelay("tvSure");
        //数量3
        findItemInputView("iivPurchaseNumber",PurchaseNumber);
        //滑动
        swipeUp();
        //选择图片
        clickDelay("ivAddImage");
        new MultiImageSelectorActivityAction().selectPic();
        //继续滑动
        // swipeUp();
        //提交
        clickDelay("tvSubmit");
        sleep();
    }
    @Override
    public void popCurrentActivity() {
        clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[0];
    }
}
