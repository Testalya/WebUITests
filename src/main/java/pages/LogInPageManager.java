package pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import common.AQConstants;
import common.AQDriver;

public class LogInPageManager {
	
		//Elements accessible by CSS
		public static final String LIP_EMAIL_INPUT = "input[id='username']";
		public static final String LIP_PASSWORD_INPUT = "input[id='password']";
		public static final String LIP_LOGIN_BTN = "button[class='btn btn-default btn-block']";
		public static final String LIP_HINT_MESSAGE = "div[class='text-center']";
		public static final String LIP_FORGOT_PASSWORD_BTN = "a[id='forgotPassword']";
		public static final String LIP_EMAIL_INPUT_ON_FORGOT_PASSWORD_PAGE = "input[id='email']";
		public static final String LIP_SUBMIT_BUTTON_ON_FORGOT_PASSWORD_PAGE = "button[class='btn btn-primary btn-block btn-login']";
		public static final String LIP_FORGOT_PASSWORD_HINT_MESSAGE = "div[class='text-center']";
		

		/***
	     * Methods to get the elements
		 *
		 * @return WebElement
		 */
			
		public static WebElement getEmailInput(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_EMAIL_INPUT));
		}
		
		public static WebElement getPasswordInput(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_PASSWORD_INPUT));
		}
		
		public static WebElement getLoginButton(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_LOGIN_BTN));
		}
		
		public static WebElement getHintMessage(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_HINT_MESSAGE));
		}
		
		public static WebElement getForgotPasswordButton(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_FORGOT_PASSWORD_BTN));
		}
		
		public static WebElement getEmailInputOnForgotPasswordPage(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_EMAIL_INPUT_ON_FORGOT_PASSWORD_PAGE));
		}
		
		public static WebElement getSubmitButtonOnForgotPasswordPage(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_SUBMIT_BUTTON_ON_FORGOT_PASSWORD_PAGE));
		}
		
		public static WebElement getForgotPasswordHintMessage(){
			return AQDriver.getCurrentDriver().findElement(By.cssSelector(LIP_FORGOT_PASSWORD_HINT_MESSAGE));
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
		
		public static void clickOnPasswordInput(){
			getPasswordInput().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnLoginButton(){
			getLoginButton().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnForgotPassword(){
			getForgotPasswordButton().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnEmailInputOnForgotPasswordPage(){
			getEmailInputOnForgotPasswordPage().click();
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void clickOnSubmitButtonOnForgotPasswordPage(){
			getSubmitButtonOnForgotPasswordPage().click();
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
		
		public static void clearPasswordInput(){
			getPasswordInput().clear();
		}
		
		public static void clearEmailInputOnForgotPasswordPage(){
			getEmailInputOnForgotPasswordPage().clear();
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
		
		public static void setPasswordInput(String password){
			clickOnPasswordInput();
			clearPasswordInput();
			getPasswordInput().sendKeys(password);
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		public static void setEmailInputOnForgotPasswordPage(String emailOnForgotPasswordPage){
			clickOnEmailInputOnForgotPasswordPage();
			clearEmailInputOnForgotPasswordPage();
			getEmailInputOnForgotPasswordPage().sendKeys(emailOnForgotPasswordPage);
			AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
		}
		
		
		/***
	     * Methods to get the texts from element
	     *
	     * @return String
	     */
		
	    public static String getHintMessageText() {
	    	AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
	        return getHintMessage().getText();
	    }
	    
	    public static String getForgotPasswordHintMessageText() {
	    	AQDriver.waitFor(AQConstants.LONG_WAIT_TIME);
	        return getForgotPasswordHintMessage().getText();
	    }
	    
	    
	    /***
	     * Methods to verify that hint message is correct
	     *
	     * 
	     */
	    
		public static void verifyHintMessage(String hintMessage){
			assertThat(getHintMessageText(), equalTo(hintMessage));
		}
		
		public static void verifyForgotPasswordHintMessage(String hintMessage){
			assertThat(getHintMessageText(), equalTo(hintMessage));
		}
		
		
		/***
	     * Methods to verify correct input validation
	     *
	     * 
	     */
		
		public static void verifyEmailInputValidation(boolean isValid){
			JavascriptExecutor js=(JavascriptExecutor) AQDriver.getCurrentDriver();
		    boolean emailInputValidation = (Boolean) js.executeScript("return document.getElementById('username').validity.valid");
			assertThat(isValid, equalTo(emailInputValidation));
		}
		
		public static void verifyPasswordInputValidation(boolean isValid){
			JavascriptExecutor js=(JavascriptExecutor) AQDriver.getCurrentDriver();
		    boolean passwordInputValidation = (Boolean) js.executeScript("return document.getElementById('password').validity.valid");
			assertThat(isValid, equalTo(passwordInputValidation));
		}
		
}
