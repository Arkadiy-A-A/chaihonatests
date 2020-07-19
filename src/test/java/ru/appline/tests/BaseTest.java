package ru.appline.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import ru.appline.framework.util.DriverManager;
import ru.appline.framework.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void setUp() {
        baseUrl = properties.getProperty("app.url");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.quitDriver();
    }


}
