package test;

import activityaction.ActivityEnum;
import activityaction.LoginActivityAction;
import activityaction.MaterialAddActivityAction;
import activityaction.NetSettingActivityAction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.base.FoodSafetyBaseTest;
import testaccount.TestAccount;
import testaccount.TestIP;

/**
 * 登录页面测试
 */
public class LoginActivityTest extends FoodSafetyBaseTest {
    @DataProvider(name = "ipGroup")
    public static Object[][] ipGroupProvider() {
        return new Object[][]{
                {TestIP.xiamen.getIp(), TestIP.xiamen.getPort()},
                {TestIP.std.getIp(), TestIP.std.getPort()}
        };
    }

   /* @Test
    public void testError() {
        boolean isRight = false;
        Assert.assertEquals(isRight, true);
    }*/

    /**
     * 测试登录页面设置IP
     */
    @Test(dataProvider = "ipGroup")
    public void testSettingIp(String ip, String port) {
        //去登录页面
        toTargetActivity(ActivityEnum.LoginActivity);
        LoginActivityAction activityAction = new LoginActivityAction(driver);
        //点击登录
        activityAction.toNetSettingActivity();
        //判断是否是NetSettingActivity
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.NetSettingActivity), true);
        //执行换ip
        //配置测试的环境
        NetSettingActivityAction netSettingActivityAction = new NetSettingActivityAction(driver);
        netSettingActivityAction.setAppIpAndPort(ip, port);
        //判断是否是否成功返回登录页面
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.LoginActivity), true);
    }

    @Test
    public void testLogin(){
        //去登录页面
        toTargetActivity(ActivityEnum.LoginActivity);
        LoginActivityAction activityAction = new LoginActivityAction(driver);
        //设置
        activityAction.startLogin(TestIP.std, TestAccount.test);
        //判断是否是主页面
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.MainActivity), true);
    }

    @DataProvider(name = "addMaterialProvider")
    public static Object[][] addMaterialProvider() {
        return new Object[][]{
                {"条码001", "100"},
                {"条码002", "120"}
        };
    }

    @Test(dataProvider = "addMaterialProvider")
    public void testAddMaterial(String barcode,String purchaseNumber){
        //到添加食材页面
        toTargetActivity(ActivityEnum.MaterialAddActivity);

        MaterialAddActivityAction addActivityAction=new MaterialAddActivityAction(driver);
        Assert.assertEquals(addActivityAction.checkCurrent(ActivityEnum.MaterialAddActivity), true);

        //判断是否是添加食材页面
        addActivityAction.setPager(barcode,purchaseNumber);
        //多个数据测试需要睡眠一下，不然判断不准确
        sleep();


    }



}
