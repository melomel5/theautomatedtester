package uk.co.theautomatedtester.book.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Chapter1Page {

    WebDriver driver;

    @FindBy(xpath = "//a[text() = 'Home Page']")
    private WebElement homePageLink;

    public Chapter1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHomePageLink() {
        homePageLink.click();
    }

    public boolean isTextPresent(String expectedText) {
        List<WebElement> expectedTextList = driver.findElements(
                By.xpath("//*[contains(text(), '" + expectedText + "')]"));
        return expectedTextList.size() > 0;
    }

}
