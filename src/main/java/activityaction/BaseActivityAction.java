package activityaction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

    public BaseActivityAction(AndroidDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean checkCurrent(ActivityEnum target) {
        Utils.print("检查当前节点是否已经到了目标节点，当前"+driver.currentActivity()+"目标："+target.activityPath);
        return target == ActivityEnum.getActivityEnumByPath(driver.currentActivity());
    }

    protected boolean isExist(String id){
        if (driver.findElementById(id)==null){
            return false;
        }
        return true;
    }
    protected void clickDelay(WebElement webElement){
        try {
            Thread.sleep(1000);
            webElement.click();
        }catch (Throwable throwable){
            Utils.print("当前点击步骤出错"+webElement.getText());

            throwable.printStackTrace();
        }
    }
    protected void clickDelay(String id) {

        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElementById(id);
            if (webElement==null){
                Utils.print("当前页面ID"+id+"不存在");
                return;
            }
            Utils.print("点击了按钮："+id);
            webElement.click();
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
