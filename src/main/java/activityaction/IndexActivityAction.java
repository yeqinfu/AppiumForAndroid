package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static activityaction.base.ActivityEnum.IndexActivity;
import static activityaction.base.ActivityEnum.PlayerActivity;

/**
 * 视频首页
 */
public class IndexActivityAction extends BaseActivityAction {
    @Override
    public void popCurrentActivity() {

        clickDelay("ivBack");
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child==PlayerActivity){
            //默认选择第一个 如果需要选择别的 另外启用一个函数
            List<MobileElement> list=findElementById("rvIndex").findElements(By.id("texture_view"));
            if (list!=null&&!list.isEmpty()){
                list.get(0).click();
            }



        }
        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                PlayerActivity
        };
    }

    public void clickAllVideo() {
       List<MobileElement> list=findElementById("rvIndex").findElements(By.id("texture_view"));
       //得到一个总数
        if (list==null||list.isEmpty()){
            return;
        }
        Assert.assertEquals(clickNumberVideo(0),true);
        for (int i=1;i<list.size();i++){
            sleep(5);
            Assert.assertEquals(clickNumberVideo(i),true);
        }




    }

    private boolean clickNumberVideo(int i) {
        List<MobileElement> list=findElementById("rvIndex").findElements(By.id("texture_view"));

        if (list==null||list.isEmpty()){
            return false;
        }
        list.get(i).click();
        new PlayerActivityAction().popCurrentActivity();
        return checkCurrent(IndexActivity);
    }
}
