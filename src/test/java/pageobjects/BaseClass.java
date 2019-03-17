package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;

	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		PageFactory.initElements(driver,this);
	}

	protected BaseClass() {
	}
}
