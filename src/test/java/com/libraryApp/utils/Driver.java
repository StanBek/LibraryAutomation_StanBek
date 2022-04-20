package com.libraryApp.utils;

import com.libraryApp.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    static String browser;
    /*
   Creating a private constructor, so we are closing
   access to the object of this class from outside the class
    */
    public Driver() {
    }

    /*
    we make webdriver private. because we want to close access from outside the class
    we make it static because we will use it in a static method.
     */
    // private static WebDriver driver;


    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>();
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            /*
            we read our browserType from configuration.properties.
            This way, we can control which browser is open from outside code,
            from  configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "remote-chrome":
                    try{
                        String gridAddress= ConfigurationReader.getProperty("gridAddress");
                        URL url = new URL("https://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }

    public static void close() {
        if(driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}