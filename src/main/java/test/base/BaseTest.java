package test.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * testng 基于appium框架
 * 传送门
 * https://github.com/appium/appium/blob/master/sample-code/java/
 *
 */
public abstract class BaseTest {

   // private static AppiumDriverLocalService service;

    @BeforeSuite
    public void globalSetup () throws IOException {
      /*  service = AppiumDriverLocalService.buildDefaultService();
        service.start();*/
    }

    @AfterSuite
    public void globalTearDown () {
      //  service.stop();
    }

    public URL getServiceUrl () throws MalformedURLException {
        //return service.getUrl();
        return new URL("http://127.0.0.1:4723/wd/hub");
    }

}