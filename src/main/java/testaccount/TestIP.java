package testaccount;

public enum  TestIP {
    std("218.6.70.66","25040"),
    xiamen("47.96.141.242","25040"),
    ;
    String ip;
    String port;

    TestIP(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }
}
