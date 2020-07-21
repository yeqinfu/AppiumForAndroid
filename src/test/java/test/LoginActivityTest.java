package test;

import activityaction.ActivityEnum;
import activityaction.LoginActivityAction;
import activityaction.NetSettingActivityAction;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.FoodSafetyBaseTest;
import testaccount.TestIP;

/**
 * 登录页面测试
 */
public class LoginActivityTest extends FoodSafetyBaseTest {
    /**
     * 测试登录页面设置IP
     */
    @Test
    public void testSettingIp(){
        //去登录页面
        toTargetActivity(ActivityEnum.LoginActivity);
        LoginActivityAction activityAction=new LoginActivityAction(driver);
        //点击登录
        activityAction.toNetSettingActivity();
        //判断是否是NetSettingActivity
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.NetSettingActivity),true);
        //执行换ip
        //配置测试的环境
        TestIP ip=TestIP.std;//使用std测试环境
        NetSettingActivityAction netSettingActivityAction=new NetSettingActivityAction(driver);
        netSettingActivityAction.setAppIp(ip);
        //判断是否是否成功返回登录页面
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.LoginActivity),false);
    }

}
