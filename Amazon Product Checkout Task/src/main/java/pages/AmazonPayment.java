package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Constants;
import util.WebDriverFactory;
import util.WebElementWait;

public class AmazonPayment {

	private WebDriver driver = WebDriverFactory.getDriverInstance();
	private WebElementWait webElementWait= new WebElementWait();
	private final By debitCardRadioButton = By.id("pm_new_verified_debit_card");
	private final By selectedPaymentMethod = By.cssSelector(".payment-selected");
	private final By chooseCardDropDown = By.cssSelector(".a-dropdown-container");
	private final By chooseCard = By.xpath("//a[@data-value='OtherBanks']");
	private final By txt_CardHolderName = By.id("vdcName");
	private final By txt_CardNumber = By.id("newVerifiedDebitCardNumber");
	private final By txt_CcvNumber = By.id("vdcCVVNum");
	private final By addYourCard = By.cssSelector(".payment-selected #ccAddCard");
	private final By errorBox = By.cssSelector("#newVDCErrors");
	private final By loaderIcon = By.id("loading-spinner-img");



	
	public void chooseDebitCardOption() {
		webElementWait.waitForInvisibility(loaderIcon);
		webElementWait.waitForElementVisibility(debitCardRadioButton);
		driver.findElement(debitCardRadioButton).click();
	}


	public void getChooseCard() {
		WebElement selectedRow = getSelectedPaymentMethod();
		 selectedRow.findElement(chooseCardDropDown).click();
	}

	public void choosingBankCard() {
		webElementWait.waitForElementPresence(chooseCard);
		driver.findElement(chooseCard).click();
	}

	public void setCardHolderName(String cardHolderName) {
		driver.findElement(txt_CardHolderName).sendKeys(cardHolderName);
	}

	public void setDebitCardNumber(String cardNumber) {
		driver.findElement(txt_CardNumber).sendKeys(cardNumber);
	}

	public void setCVV(String cvvNumber) {
		driver.findElement(txt_CcvNumber).sendKeys(cvvNumber);
	}

	public void clickOnAddYourCard() {
		driver.findElement(addYourCard).click();
	}
	
	public boolean  checkErrorDisplay() {
		return driver.findElement(errorBox).isDisplayed();
	}

	public void choosePaymentOption() {
		chooseDebitCardOption();
		getChooseCard();
		choosingBankCard();
		setCardHolderName(Constants.CARD_HOLDERNAME);
		setDebitCardNumber(Constants.DEBIT_CARD_NUMBER);
		setCVV(Constants.CVV_NUMBER);
		clickOnAddYourCard();

	}

	public WebElement getSelectedPaymentMethod() {
		return driver.findElement(selectedPaymentMethod);
	}
}
