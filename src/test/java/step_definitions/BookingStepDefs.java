package step_definitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.HomePage;
import pageobjects.BookingPage;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookingStepDefs {

    public WebDriver driver;
    HomePage homePage;
    BookingPage bookingPage;

    // BookingPage bookingPage;

    public BookingStepDefs()
    {
        driver = Hooks.driver;
    }


    @Given("^user is in landing page$")
    public void user_is_in_landing_page() throws Throwable {
        driver.get("https://www.phptravels.net/");
        Assert.assertTrue(driver.findElement(By.className("navbar-brand")).isDisplayed());
    }


    @When("^user clicks the flights tab and selects the \"([^\"]*)\"$")
    public void userClicksTheFlightsTabAndSelectsThe(String radioBtn) throws Throwable {
       bookingPage =new BookingPage(driver);
       bookingPage.flightsTab.click();
       Thread.sleep(1000);
       bookingPage.selectRadioButton(radioBtn);
    }

    @And("^user select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSelectAnd(String departAirport, String arrivalAirport) throws Throwable
    {

        bookingPage.selectAirport(departAirport,arrivalAirport);
    }

    @And("^user selects \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSelectsAnd(String departureDate, String returnDate) throws Throwable {
        bookingPage.selectDate(departureDate,returnDate);
    }

    @And("^also selects \"([^\"]*)\" and \"([^\"]*)\"$")
    public void alsoSelectsAnd(String adultTickets, String childTickets) throws Throwable {
        bookingPage.selectAdultAndChildTickets(adultTickets,childTickets);
    }

    @And("^user clicks on the search button$")
    public void userClicksOnTheSearchButton() throws Throwable {
        bookingPage.submit();
    }

    @And("^also user filter by the \"([^\"]*)\"$")
    public void alsoUserFilterByThe(String flight) throws Throwable {
        bookingPage.filterFlightResults(flight);
    }

    @And("^user click on bookNow button with the cheapest price$")
    public void userClickOnBookNowButtonWithTheCheapestPrice() throws Throwable {
        bookingPage.selectCheapestPrice();
    }

    @Then("^user must be taken to booking page$")
    public void userMustBeTakenToBookingPage() throws Throwable {

    }



}

