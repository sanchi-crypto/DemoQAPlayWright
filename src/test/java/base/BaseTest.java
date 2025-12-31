package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.*;

import utils.ConfigReader;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        String browserName = ConfigReader.getProperty("browser");

        if (browserName.equalsIgnoreCase("chromium")) {
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));
        } else {
            browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));
        }

        page = browser.newPage();
        page.navigate(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}