package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BookingPage extends BaseClass{


    public BookingPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Flights  ')]")
    public static WebElement flightsTab;

    @FindBy(how=How.XPATH, using ="//div[@class ='pure-checkbox']" )
    private static List<WebElement> ticketType;

    @FindBy(how=How.CSS, using ="#s2id_location_from > a > span.select2-chosen" )
    private static WebElement departureAirport;

    @FindBy(how=How.CSS, using ="#s2id_location_to > a > span.select2-chosen")
    private static WebElement returnAirport;

    @FindBy(how=How.XPATH, using ="//input[@placeholder ='Depart' and @name ='departure']")
    private static WebElement depatureDate;

    @FindBy(how=How.XPATH, using ="//input[@placeholder ='Return' and @name ='arrival']")
    private static WebElement returnDate;

    @FindBy(how=How.XPATH, using ="//input[@name='totalManualPassenger' and @data-target='#manual_flightTravelers']")
    private static WebElement tickets;

    @FindBy(how=How.XPATH, using ="//select[@name='madult']")
    private static WebElement adultTicket;

    @FindBy(how=How.XPATH, using ="//select[@name='mchildren']")
    private static WebElement childTicket;

    @FindBy(how=How.ID, using ="sumManualPassenger")
    private static WebElement confirmBtn;

    @FindBy(how=How.CSS, using ="div.bgfade.col-md-3.col-xs-12.search-button > button")
    private static WebElement doneBtn;

    @FindBy(how=How.CSS, using ="div.col-md-3 > div > div.panel-body")
    private static WebElement filters;

    @FindBy(how=How.ID, using ="load_data")
    private static WebElement priceTable;






  public void selectRadioButton(String radioBtn)
  {
      for(WebElement web : ticketType)
      {
          WebElement label= web.findElement(By.xpath("./label"));
          if(radioBtn.equalsIgnoreCase(label.getText().trim()))
          {
              label.click();
              break;
          }
      }

  }

  public void selectAirport(String departAirport, String retAirport) throws InterruptedException {

      Actions departActions = new Actions(driver);
      departActions.moveToElement(departureAirport);
      departActions.click();
      departActions.sendKeys(departAirport);
      departActions.build().perform();
      WebDriverWait departWait = new WebDriverWait(driver,20);
      WebElement departUlTag= departWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select2-drop > ul > li > div")));
      if(departUlTag.isDisplayed()) {
          departActions.sendKeys(Keys.DOWN);
          departActions.sendKeys(Keys.ENTER);
          departActions.build().perform();
      }


     // Thread.sleep(5000);

      Actions returnActions = new Actions(driver);
      returnActions.moveToElement(returnAirport);
      returnActions.click();
      returnActions.sendKeys(retAirport);
      returnActions.build().perform();
      WebDriverWait returnWait = new WebDriverWait(driver,20);
      WebElement returnUlTag= returnWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select2-drop > ul > li > div")));
      if(returnUlTag.isDisplayed()) {
          returnActions.sendKeys(Keys.DOWN);
          returnActions.sendKeys(Keys.ENTER);
          returnActions.build().perform();
      }
  }

    public void selectDate(String departureDate1, String retDate) {
        depatureDate.click();

        WebElement table = driver.findElement(By.cssSelector("body > div:nth-child(20) > div.datepicker-days > table"));
        WebElement rows = table.findElement(By.tagName("thead"));
        List<WebElement> tr = rows.findElements(By.tagName("tr"));
        List<WebElement> th = tr.get(0).findElements(By.tagName("th"));
        String[] dateSplit = departureDate1.split("-");

            if(th.get(1).getText().equalsIgnoreCase(dateSplit[1]+" "+dateSplit[2])){
                selectDate(table, dateSplit[0]);
            }
            else
            {
                do{
                    th.get(2).click();
                }while(!th.get(1).getText().equalsIgnoreCase(dateSplit[1]+" "+dateSplit[2]));
                selectDate(table, dateSplit[0]);
            }
        WebElement returnDatetable = driver.findElement(By.cssSelector("body > div:nth-child(23) > div.datepicker-days > table"));
        WebElement returnDateRows = returnDatetable.findElement(By.tagName("thead"));
        List<WebElement> returnDateTr = returnDateRows.findElements(By.tagName("tr"));
        List<WebElement> returnDateTh = returnDateTr.get(0).findElements(By.tagName("th"));
        String[] returnDateSplit = retDate.split("-");

        if(returnDateTh.get(1).getText().equalsIgnoreCase(returnDateSplit[1]+" "+returnDateSplit[2])){
            selectDate(returnDatetable, returnDateSplit[0]);
        }
        else
        {
            do{
                returnDateTh.get(2).click();
            }while(!returnDateTh.get(1).getText().equalsIgnoreCase(returnDateSplit[1]+" "+returnDateSplit[2]));
            selectDate(returnDatetable, returnDateSplit[0]);
        }
  }

    private void selectDate(WebElement table, String anotherString) {
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> bodyRow = tbody.findElements(By.tagName("tr"));
        boolean exitFlag = false;
        for(WebElement row : bodyRow)
        {
            List<WebElement> bodyTd = row.findElements(By.tagName("td"));
            for(WebElement td : bodyTd)
            {
                if(td.getText().equalsIgnoreCase(anotherString))
                {
                    td.click();
                    exitFlag = true;
                    break;
                }
            }
            if(exitFlag)
            {
                break;
            }
        }
    }

    public void selectAdultAndChildTickets(String adultTickets, String childTickets) {
        tickets.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement submit;
        submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='madult']")));
        if(submit.isDisplayed()) {
            Select adult = new Select(adultTicket);
            adult.selectByVisibleText(adultTickets);
            Select child = new Select(childTicket);
            child.selectByVisibleText(childTickets);
            confirmBtn.click();
        }

  }

    public void submit() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement submit;
        submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bgfade.col-md-3.col-xs-12.search-button > button")));
        if(submit.isDisplayed()) {
            doneBtn.click();
        }
        else
        {
            doneBtn.click();
        }
    }

    public void filterFlightResults(String flight) {

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement filter;
        filter= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-md-3 > div > div.panel-body")));
        if(filter.isDisplayed()) {
            if(flight.contains(",")) {
                String[] flightNameList = flight.split(",");
                for(String flightName : flightNameList) {
                    chooseFlight(flightName);
                }
            }
            else
            {
                chooseFlight(flight);
            }
        }
    }

    private void chooseFlight(String flight) {
        List<WebElement> flightFiltersList = filters.findElements(By.xpath("./div"));

        for (int i = 4; i < flightFiltersList.size(); i+=2) {
            WebElement flightFilters = flightFiltersList.get(i).findElement(By.xpath("./label"));
            if (flightFilters.getText().trim().equalsIgnoreCase(flight)) {
                WebElement flightCheckbox = flightFiltersList.get(i).findElement(By.className("iCheck-helper"));
                flightCheckbox.click();
                break;
            }
        }
    }

    public void selectCheapestPrice() throws InterruptedException {
        List<WebElement> tableRows = priceTable.findElements(By.tagName("tr"));
        int price = 0;
        int rowNum = 0;
        int i=0;
        for(WebElement row : tableRows)
        {
            i++;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)");
            WebDriverWait wait = new WebDriverWait(driver,20);
            WebElement submit;
            submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='load_data']/tbody/tr["+i+"]/td/div[2]/p/span")));
            if(submit.isDisplayed()) {
                WebElement priceElement = driver.findElement(By.xpath("//*[@id='load_data']/tbody/tr["+i+"]/td/div[2]/p/span"));
                System.out.println(priceElement.getText());
                String priceSubString = priceElement.getText();
                priceSubString = priceSubString.substring(0,priceSubString.length()-1);
                System.out.println(priceSubString);
                if(price != 0 && price > Integer.valueOf(priceSubString))
                {
                    price = Integer.valueOf(priceSubString);
                    rowNum = i;
                }
                else if(price == 0)
                {
                    price = Integer.valueOf(priceSubString);
                    rowNum = i;
                }

            }
        }
        WebElement button = tableRows.get(rowNum-1).findElement(By.tagName("button"));
        button.click();
    }
}
