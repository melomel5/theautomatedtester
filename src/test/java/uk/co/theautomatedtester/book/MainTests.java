package uk.co.theautomatedtester.book;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uk.co.theautomatedtester.book.env.EnvironmentManager;
import uk.co.theautomatedtester.book.steps.Chapter1PageSteps;
import uk.co.theautomatedtester.book.steps.HomePageSteps;

public class MainTests {
    private HomePageSteps homePageSteps;
    private Chapter1PageSteps chapter1PageSteps;

    @BeforeTest
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
        EnvironmentManager.openUrl("http://book.theautomatedtester.co.uk/");
        homePageSteps = new HomePageSteps();
        chapter1PageSteps = new Chapter1PageSteps();
    }

    @Test(description = "Check 'Assert that this text is on the page' text on Chapter1 page")
    public void chapter1Test() {
        homePageSteps.openChapter1();
        chapter1PageSteps.isTextPresentOnPage("Assert that this text is on the page");
        chapter1PageSteps.openHomePageLink();
    }

    @AfterTest
    public void afterTest() {
        EnvironmentManager.shutDownDriver();
    }
}
