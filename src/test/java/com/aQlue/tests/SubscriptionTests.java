package com.aQlue.tests;

import common.AQUtils;
import junit.framework.TestCase;
import pages.EmailProviderPageManager;
import pages.LandingPageManager;

public class SubscriptionTests extends TestCase {

	// Positive testcase

	public void subscriptionTestcase001SubscribeWithCorrectEmail(String linkToLandingPage, String email,
			String linkToEmailProviderPage, String emailForMailProvider, String passwordForMailProvider,
			String letterName, String subscriptionConfirmationMessage) {
		
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.setEmailInput(email);
		LandingPageManager.clickOnSubscribeButton();
		LandingPageManager.verifyNoSubcribeButton();
		
		AQUtils.openNewTab(linkToEmailProviderPage);
		EmailProviderPageManager.setEmailInputOnMailClient(emailForMailProvider);
		EmailProviderPageManager.setPasswordInputOnMailClient(passwordForMailProvider);
		EmailProviderPageManager.clickOnLoginButtonOnMailClient();
		EmailProviderPageManager.openLetter();
		EmailProviderPageManager.clickOnSubscribeButtonFromLetter();
		EmailProviderPageManager.verifyUserIsSuccessfullySubscribed(subscriptionConfirmationMessage);
	}

	public void testSubscribeTestcase001SubscribeWithCorrectEmail() {
		subscriptionTestcase001SubscribeWithCorrectEmail("http://qa.testing.aqlue.com/", "testalya@mail.ru",
				"https://mail.ru/", "testalya", "1q2w3e4r5t6y", "aQlue", "Subscription Confirmed");
	}

	// Negative testcases

	public void subscriptionTestcase002CannotSubscribeWithEmptyEmailAddress(String linkToLandingPage, String email,
			String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.setEmailInput(email);
		LandingPageManager.clickOnSubscribeButton();
		LandingPageManager.verifyHintEmailMessage(hintMessage);
	}

	public void testSubscriptionTestcase002CannotSubscribeWithEmptyEmailAddress() {
		subscriptionTestcase002CannotSubscribeWithEmptyEmailAddress("http://qa.testing.aqlue.com/", "",
				"Detta fält är obligatoriskt.");
	}

	public void subscriptionTestcase003CannotSubscribeWithInvalidEmailAddressWithOnlyUsername(String linkToLandingPage,
			String email, String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.setEmailInput(email);
		LandingPageManager.clickOnSubscribeButton();
		LandingPageManager.verifyHintEmailMessage(hintMessage);
	}

	public void testSubscriptionTestcase003CannotSubscribeWithInvalidEmailAddressWithOnlyUsername() {
		subscriptionTestcase003CannotSubscribeWithInvalidEmailAddressWithOnlyUsername("http://qa.testing.aqlue.com/",
				"testalya", "Ange en korrekt e-postadress.");
	}

	public void subscriptionTestcase004CannotSubscribeWithInvalidEmailAddressWithOnlyUsernameAndAtSign(
			String linkToLandingPage, String email, String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.setEmailInput(email);
		LandingPageManager.clickOnSubscribeButton();
		LandingPageManager.verifyHintEmailMessage(hintMessage);
	}

	public void testSubscriptionTestcase004CannotSubscribeWithInvalidEmailAddressWithOnlyUsernameAndAtSign() {
		subscriptionTestcase004CannotSubscribeWithInvalidEmailAddressWithOnlyUsernameAndAtSign(
				"http://qa.testing.aqlue.com/", "testalya@", "Ange en korrekt e-postadress.");
	}

	public void subscriptionTestcase005CannotSubscribeWithInvalidEmailAddressWithNoDomain(String linkToLandingPage,
			String email, String hintMessage) {
		AQUtils.openNewTab(linkToLandingPage);
		LandingPageManager.setEmailInput(email);
		LandingPageManager.clickOnSubscribeButton();
		LandingPageManager.verifyHintEmailMessage(hintMessage);
	}

	public void testSubscriptionTestcase005CannotSubscribeWithInvalidEmailAddressWithNoDomain() {
		subscriptionTestcase004CannotSubscribeWithInvalidEmailAddressWithOnlyUsernameAndAtSign(
				"http://qa.testing.aqlue.com/", "testalya@gmail", "Ange en korrekt e-postadress.");
	}

}