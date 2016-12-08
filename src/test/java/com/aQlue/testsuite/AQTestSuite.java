package com.aQlue.testsuite;

import java.net.MalformedURLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.aQlue.tests.LoginTests;
import com.aQlue.tests.LayoutRegressionTest;
import com.aQlue.tests.SubscriptionTests;
import common.AQDriver;

@RunWith(Suite.class)
// Specify an array of test classes
@Suite.SuiteClasses({ SubscriptionTests.class, 
					  LayoutRegressionTest.class, 
					  LoginTests.class })

// The actual class should be empty
public class AQTestSuite {

	@BeforeClass
	public static void beforeClass() throws MalformedURLException {
		String platform = "Chrome";
		AQDriver.setup(platform);
	}

	@AfterClass
	public static void afterClass() {
		AQDriver.quit();
	}

}