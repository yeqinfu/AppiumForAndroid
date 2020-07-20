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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
