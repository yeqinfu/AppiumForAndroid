package test;

import activityaction.ActivityEnum;
import activityaction.LoginActivityAction;
import activityaction.NetSettingActivityAction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.base.FoodSafetyBaseTest;
import testaccount.TestIP;

/**
 * 登录页面测试
 */
public class LoginActivityTest extends FoodSafetyBaseTest {
    @DataProvider(name="ipGroup")
    public static Object[][] ipGroupProvider(){
        return new Object[][]{
                {TestIP.std.getIp(),TestIP.std.getPort()},
                {TestIP.xiamen.getIp(),TestIP.xiamen.getPort()},
        };
    }
    @Test
    public void testError(){
        boolean isRight=false;
        Assert.assertEquals(isRight,true);
    }
    /**
     * 测试登录页面设置IP
     */
    @Test(dataProvider = "ipGroup")
    public void testSettingIp(String ip,String port){
        //去登录页面
        toTargetActivity(ActivityEnum.LoginActivity);
        LoginActivityAction activityAction=new LoginActivityAction(driver);
        //点击登录
        activityAction.toNetSettingActivity();
        //判断是否是NetSettingActivity
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.NetSettingActivity),true);
        //执行换ip
        //配置测试的环境
        NetSettingActivityAction netSettingActivityAction=new NetSettingActivityAction(driver);
        netSettingActivityAction.setAppIpAndPort(ip,port);
        //判断是否是否成功返回登录页面
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.LoginActivity),true);
    }

}
