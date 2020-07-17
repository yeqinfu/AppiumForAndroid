import phone.TestDevice;
import phone.RedMiNote7;
import testaccount.TestAccount;
import testaccount.TestIP;
import testapplication.FoodSafety;
import testapplication.TestApplication;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //配置测试手机对象
        TestDevice testDevice=new RedMiNote7();//使用手机红米note7
        //配置测试的环境
        TestIP ip=TestIP.std;//使用std测试环境
        //配置测试账号
        TestAccount account=TestAccount.test;//使用名为test的账号
        //配置要进行测试的应用
        TestApplication application=new FoodSafety(testDevice,ip,account);//选择了食安云厨
        //测试引擎
        TestEngine engine=new TestEngine(application);
        //设置测试流程为两次
        engine.setTestAccount(1);
        //开始测试
        engine.start();
    }
}
