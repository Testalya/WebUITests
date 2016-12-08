package pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.AQConstants;
import common.AQDriver;

public class LandingPageManager {
	
	//Elements accessible by NAME
	public static final String LP_EMAIL_INPUT = "EMAIL";
	public static final String LP_SUBSCRIBE_BTN = "subscribe";
	
		
	//Elements accessible by CSS-selectors
	public static final String LP_HINT_MESSAGE = "div[class='mce_inline_error']";
	public static final String LP_LOGIN_BTN = "a[class='login-btn']";
	public static final String LP_LOGIN_BLOCK = "form[id='form_login']";
	
		
		
	/***
     * Methods to get the elements
	 *
	 * @return WebElement
	 */
		
	public static WebElement getEmailInput(){
		return AQDriver.getCurrentDriver().findElement(By.name(LP_EMAIL_INPUT));
	}
	
	public static WebElement getSubscribeButton(){
		return AQDriver.getCurrentDriver().findElement(By.name(LP_SUBSCRIBE_BTN));
	}
	
	public static WebElement getHintMessage(){
		return AQDriver.getCurrentDriver().findElement(By.cssSelector(LP_HINT_MESSAGE));
	}
	
	public static WebElement getLoginButton(){
		return AQDriver.getCurrentDriver().findElement(By.cssSelector(LP_LOGIN_BTN));
	}
	
	public static WebElement getLoginBlock(){
		return AQDriver.getCurrentDriver().findElement(By.cssSelector(LP_LOGIN_BLOCK));
	}
	
	
	

	/***
	 * Methods to click on the elements
	 *
	 * 
	 */
	
	public static void clickOnEmailInput(){
		getEmailInput().click();
		AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
	}
	
	public static void clickOnSubscribeButton(){
		getSubscribeButton().click();
		AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
	}
	
	public static void clickOnLoginButton(){
		getLoginButton().click();
		AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
	}
	
	
	/***
     * Methods to clear text 
     *
     * 
     */
	
	public static void clearEmailInput(){
		getEmailInput().clear();
	}
	
	
	/***
     * Methods to set the value into element
     *
     */
	
	public static void setEmailInput(String email){
		clickOnEmailInput();
		clearEmailInput();
		getEmailInput().sendKeys(email);
		AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
	}
	
	
	/***
     * Methods to get the texts from element
     *
     * @return String
     */
    public static String getHintMessageText() {
        return getHintMessage().getText();
    }
	
	
	/***
     * Method to verify that subscribe button disappeared
     *
     * 
     */
	public static void verifyNoSubcribeButton(){
		AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
        boolean isDisplayed = getSubscribeButton().isDisplayed();
        assertThat(isDisplayed, equalTo(false));
	}
	
	
	/***
     * Method to verify that hint message is correct
     *
     * 
     */
	public static void verifyHintEmailMessage(String hintMessage){
		assertThat(getHintMessageText(), equalTo(hintMessage));
	}
	
	/***
     * Method to verify that login block is present
     *
     * 
     */
	public static void verifyLoginBlockIsPresent(){
		AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
        boolean isDisplayed = getLoginBlock().isDisplayed();
        assertThat(isDisplayed, equalTo(true));
	}
	
}
