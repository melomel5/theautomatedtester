package uk.co.theautomatedtester.book.steps;

import uk.co.theautomatedtester.book.env.RunEnvironment;
import uk.co.theautomatedtester.book.pages.HomePage;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage(RunEnvironment.getWebDriver());
    }

    public void openChapter1() {
        homePage.clickChapter1Button();
    }

}
