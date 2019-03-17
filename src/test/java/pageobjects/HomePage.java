package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BookingStepDefs;

public class HomePage extends BaseClass{
    BookingStepDefs BookingStepDefs;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators/////

    @FindBy(how = How.XPATH, using = "//a[@href='#TOURS']")
    private static WebElement tourTab;

    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Search')])[2]")
    private static WebElement searchTours;

    @FindBy(how = How.ID, using = "selectedAdults")
    public static WebElement selectTickets;

    @FindBy(how = How.CSS, using = ".text-center.adultPrice")
    public static WebElement defaultPrice;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Personal Details')]")
    public static WebElement personalDetailText;

    @FindBy(how = How.NAME, using = "firstname")
    public static WebElement firstName;

    @FindBy(how = How.NAME, using = "lastname")
    public static WebElement lastName;

    @FindBy(how = How.NAME, using = "email")
    public static WebElement email;

    @FindBy(how = How.NAME, using = "confirmemail")
    public static WebElement confirmEmail;

    @FindBy(how = How.NAME, using = "phone")
    public static WebElement phone;

    @FindBy(how = How.NAME, using = "address")
    public static WebElement address;

    @FindBy(how = How.CSS, using = ".chosen-select.select2-offscreen")
    public static WebElement country;

   @FindBy(how = How.XPATH, using = "//*[@id='bookingdetails']/div[2]/table/tbody/tr[1]/td[4]/label/span/span[2]")
   public static WebElement returnAirTickets;

   @FindBy( how= How.XPATH, using ="//*[@id='bookingdetails']/div[2]/table/tbody/tr[2]/td[4]/label/span/span[2]")
   public static WebElement threeNightsAccomodation;

   @FindBy(how= How.XPATH, using= "//*[@id='bookingdetails']/div[2]/table/tbody/tr[3]/td[4]/label/span/span[2]")
   public static WebElement travelInsurance;

   @FindBy(how=How.XPATH, using= "//*[@id='bookingdetails']/div[2]/table/tbody/tr[4]/td[4]/label/span/span[2]")
   public static WebElement airportPickup;

   @FindBy(how=How.XPATH, using="//*[@id=\"body-section\"]/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/table/tbody/tr[2]/td[2]")
   public static WebElement subTotal;


   @FindBy(how = How.XPATH ,using= "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/div[4]/table[1]/tbody/tr[1]/td[2]")
   public static WebElement taxReturnPrice;

   @FindBy(how= How.XPATH, using= "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/div[4]/table[1]/tbody/tr[2]/td[2]")
   public static WebElement returnAirTicketPrice;

   @FindBy(how = How.XPATH ,using = "//*[@id='displaydeposit']")
   public static WebElement depositNowPrice;

    @FindBy(how = How.XPATH ,using = "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/div[4]/table[1]/tbody/tr[4]/td[2]")
    public static WebElement travelInsuranceAmount;

   @FindBy(how = How.XPATH , using= "//*[@id='displaytotal']")
   public static  WebElement totalAmount;

   @FindBy(how=How.XPATH ,using = "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/table/tbody/tr[1]/td[1]/strong")
   public static WebElement noOfAdultSelectedTickets;

    @FindBy(how=How.XPATH ,using = "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/table/tbody/tr[1]/td[1]/strong")
    public static WebElement noOfChildSelectedTickets;

    @FindBy(how=How.XPATH ,using = "//*[@id='body-section']/div[1]/div/div/div/div[2]/div[2]/div[5]/div[1]/table/tbody/tr[1]/td[1]/strong")
    public static WebElement noOfInfantSelectedTickets;

    @FindBy(how=How.NAME,using= "passport[1][name]")
    public static WebElement guestNameOne;

    @FindBy(how=How.NAME,using= "passport[1][passportnumber]")
    public static WebElement guestPassportOne;

    @FindBy(how=How.NAME,using= "passport[1][age]")
    public static WebElement ageOfGuestOne;

    @FindBy(how=How.NAME,using= "passport[2][name]")
    public static WebElement guestNameTwo;

    @FindBy(how=How.NAME,using= "passport[2][passportnumber]")
    public static WebElement guestPassportTwo;

    @FindBy(how=How.NAME,using= "passport[2][age]")
    public static WebElement ageOfGuestTwo;

    @FindBy(how=How.NAME,using= "passport[3][name]")
    public static WebElement guestNameThree;

    @FindBy(how=How.NAME,using= "passport[3][passportnumber]")
    public static WebElement guestPassportThree;

    @FindBy(how=How.NAME,using= "passport[3][age]")
    public static WebElement ageOfGuestThree;

    @FindBy(how=How.XPATH,using= "//button[@class='btn btn-success btn-lg btn-block completebook' and @name='guest']")
    public static WebElement confirmBookinhButton;

    @FindBy(how=How.XPATH, using= "//*[@id=\"invoiceTable\"]/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div[3]")
    public static WebElement invoiceConfirmationText;

    @FindBy(how=How.CSS,using= ".btn.btn-default.arrivalpay")
    public static WebElement payOnArrivalButton;

    @FindBy(how=How.CSS,using= ".wow.flash.animted")
    public static WebElement  bookingStatusReservedText;

   /////////actions/methods-------//////

    public void gotoToursTab() {
        tourTab.click();
    }

    public void search(){


    }

    public void waitAndClickOnSearch() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Search')])[2]")));
        searchTours.click();


    }

    public void fillPersonalDetails(String firstNameData, String lastNameData, String emailData, String confirmEmailData, String contactNoData, String addressData, String selectCountry) {
        (firstName).sendKeys(firstNameData);
        (lastName).sendKeys(lastNameData);
        (email).sendKeys(emailData);
        (confirmEmail).sendKeys(confirmEmailData);
        (phone).sendKeys(contactNoData);
        (address).sendKeys(addressData);
        Select select = new Select(country);
        select.selectByVisibleText(selectCountry);
    }
}
