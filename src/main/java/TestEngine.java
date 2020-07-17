import phone.TestDevice;
import testaccount.TestAccount;
import testaccount.TestIP;
import testapplication.TestApplication;

/**
 * 测试机器
 *
 */
public class TestEngine {
    //测试设备
    TestDevice testDevice;
    //测试IP
    TestIP ip;
    //测试账号
    TestAccount account;
    //测试应用
    TestApplication application;
    //测试 当前流程的循环次数 默认一次
    int testAccount=1;

    public TestEngine(TestDevice testDevice, TestIP ip, TestAccount account, TestApplication application) {
        this.testDevice = testDevice;
        this.ip = ip;
        this.account = account;
        this.application = application;
    }

    public int getTestAccount() {
        return testAccount;
    }

    public void setTestAccount(int testAccount) {
        this.testAccount = testAccount;
    }
    public void start(){

    }
}
