package com.aQlue.tests;

import common.AQUtils;
import junit.framework.TestCase;
import pages.LandingPageManager;
import pages.LogInPageManager;

public class LoginTests extends TestCase {

	public void loginTestcase001UnregisteredUserCannotLogin(String linkToLandingPage, String email, String password,
			String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.clickOnLoginButton();
		LandingPageManager.verifyLoginBlockIsPresent();
		LogInPageManager.setEmailInput(email);
		LogInPageManager.setPasswordInput(password);
		LogInPageManager.clickOnLoginButton();
		LogInPageManager.verifyHintMessage(hintMessage);
	}

	public void testLoginTestcase001UnregisteredUserCannotLogin() {
		loginTestcase001UnregisteredUserCannotLogin("http://qa.testing.aqlue.com/", "test@gmail.com", "11111111",
				"Inloggning misslyckades");
	}

	public void loginTestcase002CheckEmailInputValidation(String linkToLandingPage, String email, boolean isValid) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.clickOnLoginButton();
		LandingPageManager.verifyLoginBlockIsPresent();
		LogInPageManager.setEmailInput(email);
		LogInPageManager.verifyEmailInputValidation(isValid);
	}

	public void testLoginTestcase002aCheckFilledEmailInputValidation() {
		loginTestcase002CheckEmailInputValidation("http://qa.testing.aqlue.com/", "test@gmail.com", true);
	}

	public void testLoginTestcase002bCheckEmptyEmailInputValidation() {
		loginTestcase002CheckEmailInputValidation("http://qa.testing.aqlue.com/", "", false);
	}

	public void loginTestcase003CheckPasswordInputValidation(String linkToLandingPage, String password,
			boolean isValid) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.clickOnLoginButton();
		LandingPageManager.verifyLoginBlockIsPresent();
		LogInPageManager.setPasswordInput(password);
		LogInPageManager.verifyPasswordInputValidation(isValid);
	}

	public void testLoginTestcase003aCheckFilledPasswordInputValidation() {
		loginTestcase003CheckPasswordInputValidation("http://qa.testing.aqlue.com/", "password", true);
	}

	public void testLoginTestcase003bCheckEmptyPasswordInputValidation() {
		loginTestcase003CheckPasswordInputValidation("http://qa.testing.aqlue.com/", "", false);
	}

	public void loginTestcase004ForgotPasswordOption(String linkToLandingPage, String emailOnForgotPasswordPage,
			String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.clickOnLoginButton();
		LandingPageManager.verifyLoginBlockIsPresent();
		LogInPageManager.clickOnForgotPassword();
		LogInPageManager.setEmailInputOnForgotPasswordPage(emailOnForgotPasswordPage);
		LogInPageManager.clickOnSubmitButtonOnForgotPasswordPage();
		LogInPageManager.verifyForgotPasswordHintMessage(hintMessage);
	}

	public void testLoginTestcase004ForgotPasswordHintMessageAppears() {
		loginTestcase004ForgotPasswordOption("http://qa.testing.aqlue.com/", "test@gmail.com",
				"Om du har ett konto kommer du att få ett mail");
	}

}
