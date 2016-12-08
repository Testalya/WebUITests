package pages;


import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.AQConstants;
import common.AQDriver;

public class EmailProviderPageManager {
	
		//Elements accessible by CSS
		public static final String MAIl_CLIENT_EMAIL = "input[id='mailbox__login']";
		public static final String MAIL_CLIENT_PASSWORD = "input[id='mailbox__password']";
		public static final String MAIL_CLIENT_LOGIN_BTN = "input[id='mailbox__auth__button']";
		public static final String MAIL_CLIENT_FIRST_SEARCH_RESULT = "div[class='b-datalist__item__wrapper']:first-child";
		
		
		//Elements accessible by xPath
		public static final String SUBSCRIBE_BUTTON_FROM_LETTER = ".//*/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/a/span";
		public static final String SUBSCRIPTION_CONFIRMATION_MESSAGE = ".//*[@id='templateBody']/h2";
		
		
		/***
	     * Methods to get the elements
		 *
		 * @return WebElement
		 */
		
		public static WebElement getEmailInputOnMailClient(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(MAIl_CLIENT_EMAIL));
		}
		
		public static WebElement getPasswordInputOnMailClient(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(MAIL_CLIENT_PASSWORD));
		}
		
		public static WebElement getLoginButtonOnMailClient(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(MAIL_CLIENT_LOGIN_BTN));
		}
		
		public static WebElement getFirstSearchResultOnMailClient(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(MAIL_CLIENT_FIRST_SEARCH_RESULT));
		}
		
		public static WebElement getSubcribeButtonFromLetter(){
			return AQDriver.getCurrentDriver().findElement(By.xpath(SUBSCRIBE_BUTTON_FROM_LETTER));
		}
		
		public static WebElement getSubscribeConfirmationMessage(){
			return AQDriver.getCurrentDriver().findElement(By.xpath(SUBSCRIPTION_CONFIRMATION_MESSAGE));
		}



		/***
		 * Methods to click on the elements
		 *
		 * 
		 */
		
		public static void clickOnEmailInputOnMailClient(){
			getEmailInputOnMailClient().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnPasswordInputOnMailClient(){
			getPasswordInputOnMailClient().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnLoginButtonOnMailClient(){
			getLoginButtonOnMailClient().click();
			AQDriver.waitFor(AQConstants.MAX_WAIT_TIME);
		}
		
		public static void openLetter(){
			getFirstSearchResultOnMailClient().click();
			AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
		}
		
		public static void clickOnSubscribeButtonFromLetter(){
			getSubcribeButtonFromLetter().click();
			AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
		}
		
		
		
		/***
	     * Methods to clear text 
	     *
	     * 
	     */
		
		public static void clearEmailInputOnMailClient(){
			getEmailInputOnMailClient().clear();
		}
		
		public static void clearPasswordInputOnEmailClient(){
			getPasswordInputOnMailClient().clear();
		}
		
		
			
		/***
	     * Methods to set the value into element
	     *
	     */
		
		public static void setEmailInputOnMailClient(String emailForMailProvider){
			clickOnEmailInputOnMailClient();
			clearEmailInputOnMailClient();
			getEmailInputOnMailClient().sendKeys(emailForMailProvider);
			//AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void setPasswordInputOnMailClient(String password){
			clickOnPasswordInputOnMailClient();
			clearPasswordInputOnEmailClient();
			getPasswordInputOnMailClient().sendKeys(password);
			//AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		
		/***
	     * Methods to get the text from elements
	     *
	     * @return String
	     */
		
	    public static String getTextFromSubscriptionConfirmation() {
	        return getSubscribeConfirmationMessage().getText();
	    }
	    
	    
		/***
	     * Method to verify that user is successfully subscribed
	     *
	     * 
	     */
		
		public static void verifyUserIsSuccessfullySubscribed(String subscriptionConfirmationMessage){
			String parentWindow = AQDriver.getCurrentDriver().getWindowHandle();
			Set<String> handles = AQDriver.getCurrentDriver().getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(parentWindow)) {
					AQDriver.getCurrentDriver().switchTo().window(windowHandle);
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				Assert.assertEquals(getTextFromSubscriptionConfirmation(), subscriptionConfirmationMessage);
				
				AQDriver.getCurrentDriver().close();
				AQDriver.getCurrentDriver().switchTo().window(parentWindow);
				}
			}
		
		}
		
}
