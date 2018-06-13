package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Constants;
import util.WebElementWait;

public class AmazonPayment {

	WebDriver driver;
	private WebElementWait webElementWait;
	private final By debitCardRadioButton = By.id("pm_new_verified_debit_card");
	private final By selectedPaymentMethod = By.cssSelector(".selected-section");
	private final By chooseCardDropDown = By.cssSelector(".a-dropdown-container ");
	private final By chooseCard = By.xpath("//a[@data-value='OtherBanks']");
	private final By txt_CardHolderName = By.id("vdcName");
	private final By txt_CardNumber = By.id("newVerifiedDebitCardNumber");
	private final By txt_CcvNumber = By.id("vdcCVVNum");
	private final By addYourCard = By.cssSelector(".payment-selected #ccAddCard");
	private final By errorBox = By.cssSelector("#newVDCErrors");


	public AmazonPayment(WebDriver driver) {
		this.driver = driver;
	}

	
	public void chooseDebitCardOption() {
		webElementWait = new WebElementWait(driver);
		webElementWait.waitForElement(debitCardRadioButton);
		driver.findElement(debitCardRadioButton).click();
	}

	public WebElement getSelectedRow() {
		return driver.findElement(selectedPaymentMethod);
	}

	public WebElement getChooseCard() {
		WebElement selectedRow = this.getSelectedRow();
		return selectedRow.findElement(chooseCardDropDown);
	}

	public void choosingBankCard() {
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
		this.chooseDebitCardOption();
		this.getChooseCard();
		this.choosingBankCard();
		this.setCardHolderName(Constants.CARD_HOLDERNAME);
		this.setDebitCardNumber(Constants.DEBIT_CARD_NUMBER);
		this.setCVV(Constants.CVV_NUMBER);
		this.clickOnAddYourCard();

	}

	public WebElement getSelectedPaymentMethod() {
		webElementWait = new WebElementWait(driver);
		webElementWait.waitForElement(selectedPaymentMethod);
		return driver.findElement(selectedPaymentMethod);
	}
}
