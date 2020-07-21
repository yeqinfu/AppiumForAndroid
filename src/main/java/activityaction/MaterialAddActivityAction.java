package activityaction;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class MaterialAddActivityAction extends BaseActivityAction{
    public MaterialAddActivityAction(AndroidDriver driver) {
        super(driver);
    }

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
        new MultiImageSelectorActivityAction(driver).selectPic();
        //继续滑动
        // swipeUp();
        //提交
        clickDelay("tvSubmit");
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
