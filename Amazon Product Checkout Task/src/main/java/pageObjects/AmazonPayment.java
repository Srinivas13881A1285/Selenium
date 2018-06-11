package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GenericFunction;

public class AmazonPayment {

	WebDriver driver;
	private GenericFunction gen;
	private By DEBIT_CARD_RADIO_BUTTON = By.id("pm_new_verified_debit_card");
	private By SELECTED_PAYMENT_ROW = By.cssSelector(".selected-section");
	private By BANK_SELECT = By.cssSelector(".a-dropdown-container ");
	private By BANK_CARD = By.xpath("//a[@data-value='OtherBanks']");
	private By CARD_HOLDER_NAME = By.id("vdcName");
	private By CARD_NUMBER = By.id("newVerifiedDebitCardNumber");
	private By CCV_NUMBER = By.id("vdcCVVNum");
	private By ADD_YOUR_CARD = By.cssSelector(".payment-selected #ccAddCard");


	public AmazonPayment(WebDriver driver) {
		this.driver = driver;
	}

	
	public void chooseDebitCardOption() {
		gen = new GenericFunction(driver);
		gen.waitForElement(DEBIT_CARD_RADIO_BUTTON);
		driver.findElement(DEBIT_CARD_RADIO_BUTTON).click();
	}

	public WebElement getSelectedRow() {
		return driver.findElement(SELECTED_PAYMENT_ROW);
	}

	public WebElement getChooseCard() {
		WebElement selectedRow = this.getSelectedRow();
		return selectedRow.findElement(BANK_SELECT);
	}

	public void choosingBankCard() {
		driver.findElement(BANK_CARD).click();
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
		this.setCardHolderName("Srinivas Chintakindhi");
		this.setDebitCardNumber("1234 5678 1234 1234");
		this.setCVV("123");
		this.clickOnAddYourCard();

	}

	public WebElement getSelectedPaymentRow() {
		gen = new GenericFunction(driver);
		gen.waitForElement(SELECTED_PAYMENT_ROW);
		return driver.findElement(SELECTED_PAYMENT_ROW);
	}
}
