package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Constants;
import utilities.WebElementWait;

public class AmazonPayment {

	WebDriver driver;
	private WebElementWait webElementWait;
	private By DEBIT_CARD_RADIO_BUTTON = By.id("pm_new_verified_debit_card");
	private By SELECTED_PAYMENT_METHOD = By.cssSelector(".selected-section");
	private By CHOOSE_CARD_DROPDOWN = By.cssSelector(".a-dropdown-container ");
	private By CHOOSE_CARD = By.xpath("//a[@data-value='OtherBanks']");
	private By CARD_HOLDER_NAME = By.id("vdcName");
	private By CARD_NUMBER = By.id("newVerifiedDebitCardNumber");
	private By CCV_NUMBER = By.id("vdcCVVNum");
	private By ADD_YOUR_CARD = By.cssSelector(".payment-selected #ccAddCard");


	public AmazonPayment(WebDriver driver) {
		this.driver = driver;
	}

	
	public void chooseDebitCardOption() {
		webElementWait = new WebElementWait(driver);
		webElementWait.waitForElement(DEBIT_CARD_RADIO_BUTTON);
		driver.findElement(DEBIT_CARD_RADIO_BUTTON).click();
	}

	public WebElement getSelectedRow() {
		return driver.findElement(SELECTED_PAYMENT_METHOD);
	}

	public WebElement getChooseCard() {
		WebElement selectedRow = this.getSelectedRow();
		return selectedRow.findElement(CHOOSE_CARD_DROPDOWN);
	}

	public void choosingBankCard() {
		driver.findElement(CHOOSE_CARD).click();
	}

	public void setCardHolderName(String cardHolderName) {
		driver.findElement(CARD_HOLDER_NAME).sendKeys(cardHolderName);
	}

	public void setDebitCardNumber(String cardNumber) {
		driver.findElement(CARD_NUMBER).sendKeys(cardNumber);
	}

	public void setCVV(String cvvNumber) {
		driver.findElement(CCV_NUMBER).sendKeys(cvvNumber);
	}

	public void clickOnAddYourCard() {
		driver.findElement(ADD_YOUR_CARD).click();
	}

	public void choosePaymentOption() {
		this.chooseDebitCardOption();
		this.getChooseCard();
		this.choosingBankCard();
		this.setCardHolderName(Constants.CARD_HOLDERNAME);
		this.setDebitCardNumber(Constants.DEBIT_CARD_NUMBER);
		this.setCVV(Constants.CVV_NUMBER);
		this.clickOnAddYourCard();

	}

	public WebElement getSelectedPaymentRow() {
		webElementWait = new WebElementWait(driver);
		webElementWait.waitForElement(SELECTED_PAYMENT_METHOD);
		return driver.findElement(SELECTED_PAYMENT_METHOD);
	}
}
