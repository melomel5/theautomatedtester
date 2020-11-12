package uk.co.theautomatedtester.book.steps;

import org.testng.Assert;

import uk.co.theautomatedtester.book.env.RunEnvironment;
import uk.co.theautomatedtester.book.pages.Chapter1Page;

public class Chapter1PageSteps {

    private Chapter1Page chapter1Page;

    public Chapter1PageSteps() {
        chapter1Page = new Chapter1Page(RunEnvironment.getWebDriver());
    }

    public void openHomePageLink() {
        chapter1Page.clickHomePageLink();
    }

    public void isTextPresentOnPage(String text) {
        Assert.assertTrue(chapter1Page.isTextPresent(text), String.format("Text \"%s\" is not present on page", text));
    }

}
