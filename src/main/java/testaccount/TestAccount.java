package testaccount;

/**
 * 测试账号集合
 */
public enum TestAccount {
    test("test", "123456"),
    xmyd("xmyd", "12356"),
    admin("admin", "admin");
    private String account;
    private String password;

    TestAccount(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
