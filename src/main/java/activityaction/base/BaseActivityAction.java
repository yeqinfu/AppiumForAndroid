package activityaction.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import utils.Utils;

public abstract class BaseActivityAction implements ActivityAction {
    protected AndroidDriver driver;


    @Override
    public void doAllActions() {


    }
    protected void clickBaseTitleBack(){
        clickDelay("title_left");
    }

    public BaseActivityAction() {
        Config config=Config.getInstance();
        this.driver =config.driver;
    }

    @Override
    public boolean checkCurrent(ActivityEnum target) {
        Utils.print("检查当前节点是否已经到了目标节点，当前"+driver.currentActivity()+"目标："+target.activityPath);
        return target == ActivityEnum.getActivityEnumByPath(driver.currentActivity());
    }

    protected boolean isExist(String id){
        try {
            if (driver.findElementById(id)!=null){
                return true;
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

        return false;
    }

    /**
     * 向上滑动
     */
    protected void swipeUp(){
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        //滑动
        new AndroidTouchAction(driver)
                .longPress(PointOption.point(width / 2, height/2))
                .moveTo(PointOption.point(width/2,100))
                .release()
                .perform();
    }
    protected void clickDelay(WebElement webElement){
        webElement.click();
      /*  try {
            Thread.sleep(1000);

        }catch (Throwable throwable){
            Utils.print("当前点击步骤出错"+webElement.getText());

            throwable.printStackTrace();
        }*/
    }
    protected void clickIfExist(String id){
        if (isExist(id)){
            clickDelay(id);
        }
    }
    protected void clickDelay(String id) {

        try {
            Thread.sleep(1000);
            AndroidElement webElement = (AndroidElement) driver.findElementById(id);
            if (webElement==null){
                Utils.print("当前页面ID"+id+"不存在");
                return;
            }

            webElement.click();
            Utils.print("点击了按钮："+id);
        } catch (Throwable e) {
            Utils.print("当前点击步骤出错"+id);
            e.printStackTrace();
        }

    }

    protected void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void findItemInputView(String id,String text){
        AndroidElement target= (AndroidElement)driver.findElementById(id);
        if (target==null){
            Utils.print("当前ItemInputView"+id+"不存在");
            return;
        }
        target.findElementById("etCenter").sendKeys(text);
    }

}
