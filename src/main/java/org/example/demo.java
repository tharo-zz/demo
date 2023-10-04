package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class demo {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.locator("//input[@name='username']").fill("Admin");
        page.locator("//input[@name='password']").fill("admin123");
        page.locator("//button[@type='submit']").click();
        assertThat(page).hasURL("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

        page.close();
        browser.close();
        playwright.close();
    }
}
