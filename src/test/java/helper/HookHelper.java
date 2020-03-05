package helper;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HookHelper {
    private static WebDriver webDriver;

    @Before
    public void setUp()
    {
        SetWebDriver setWebDriver = new SetWebDriver();
        webDriver = setWebDriver.setWebDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.falabella.com.co/falabella-co/");

    }

    public static WebDriver getWebDriver()
    {
        return webDriver;
    }



/*
    @After
    public void tearDown()
    {
        webDriver.quit();
    }
*/


}