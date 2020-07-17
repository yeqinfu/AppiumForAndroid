package phone;

/**
 * 测试设备对象 的抽象
 */
public interface TestDevice {
    String getDeviceName();
    String getAutomationName();
    String getPlatformName();
    String getPlatformVersion();
}
