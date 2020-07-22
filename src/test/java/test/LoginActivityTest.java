package test;

import activityaction.IndexActivityAction;
import activityaction.base.ActivityEnum;
import activityaction.LoginActivityAction;
import activityaction.MaterialAddActivityAction;
import activityaction.NetSettingActivityAction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import test.base.FoodSafetyBaseTest;
import testaccount.TestAccount;
import testaccount.TestIP;

import static activityaction.base.ActivityEnum.*;

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
        LoginActivityAction activityAction = new LoginActivityAction();
        //点击登录
        activityAction.toNetSettingActivity();
        //判断是否是NetSettingActivity
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.NetSettingActivity), true);
        //执行换ip
        //配置测试的环境
        NetSettingActivityAction netSettingActivityAction = new NetSettingActivityAction();
        netSettingActivityAction.setAppIpAndPort(ip, port);
        //判断是否是否成功返回登录页面
        Assert.assertEquals(activityAction.checkCurrent(ActivityEnum.LoginActivity), true);
    }

    @Test
    public void testLogin(){
        //去登录页面
        toTargetActivity(ActivityEnum.LoginActivity);
        LoginActivityAction activityAction = new LoginActivityAction();
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

        MaterialAddActivityAction addActivityAction=new MaterialAddActivityAction();
        Assert.assertEquals(addActivityAction.checkCurrent(ActivityEnum.MaterialAddActivity), true);

        //判断是否是添加食材页面
        addActivityAction.setPager(barcode,purchaseNumber);
        //多个数据测试需要睡眠一下，不然判断不准确
        sleep();
    }
    @Test
    public void testAllManagerPager(){
     /*   toTargetActivity(MaterialManagerActivity);
        toTargetActivity(DisinfectManagerActivity);
        toTargetActivity(PersonHealthyActivity);
        toTargetActivity(ReservedRecordActivity);
        toTargetActivity(SupplierTraceActivity);
        toTargetActivity(RiskWarningActivity);*/
        toTargetActivity(LoginActivity);
        new LoginActivityAction().startLogin(TestIP.std,TestAccount.test);
        toTargetActivity(IndexActivity);

        Assert.assertEquals(isInActivity(IndexActivity),true);
    }

    /**
     * 测试所有的视频监控是否可以播放
     */
    @Test
    public void testAllVideoPlay(){
        //到当前单位的视频首页
        toTargetActivity(IndexActivity);
        //太慢了 加载等待五秒
        sleep(5);
        new IndexActivityAction().clickAllVideo();
        //最后停留在首页
        Assert.assertEquals(isInActivity(IndexActivity),true);

    }



}
