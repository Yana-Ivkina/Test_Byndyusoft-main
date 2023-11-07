package ru.byndyusoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static ru.byndyusoft.Browser.getDriver;
import static org.junit.Assert.assertEquals;

public class TestCorrectPhoneNumberAndMailbox {

    private WebDriver driver;

    @Before
    public void startUp() {

        this.driver = getDriver(BrowserName.Chrome);
    }

    @Test
    public void checkMailInOrderPresentationButton() {
        driver.get("https://www.google.com");
        MainPageByndyusoft element = new MainPageByndyusoft(driver);
        element.writeWorldInSearchGoogle("Byndyusoft");
        element.clickOnFirstLinks();
        element.scrollToYellowButton();
        element.clickOnYellowButton();
        String actualTelegramName = element.getTelegramName();
        assertEquals(actualTelegramName, "https://t.me/alexanderbyndyu");
    }

    @After
    public void teardown() {
        driver.close();
    }
}
