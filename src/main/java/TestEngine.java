import phone.TestDevice;
import testaccount.TestAccount;
import testaccount.TestIP;
import testapplication.TestApplication;

/**
 * 测试机器
 *
 */
public class TestEngine {

    //测试应用
    TestApplication application;
    //测试 当前流程的循环次数 默认一次
    int testAccount=1;

    public TestEngine(TestApplication application) {
        this.application = application;
    }

    public int getTestAccount() {
        return testAccount;
    }

    public void setTestAccount(int testAccount) {
        this.testAccount = testAccount;
    }
    public void start(){
        //测试次数
        for (int i=0;i<testAccount;i++){
            //开启全部测试流程
            application.startAllTestFlow();
        }
    }
}
