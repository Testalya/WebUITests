package com.aQlue.tests;

import java.io.IOException;
import common.AQUtils;
import junit.framework.TestCase;

public class LayoutRegressionTest extends TestCase {

	public void testLayoutRegression() throws IOException, InterruptedException {

		AQUtils.takeScreenshotOfWholeLandingPage("http://qa.testing.aqlue.com/", "screenshots/LandingPage.png", "png");
		AQUtils.compareScreenshots("screenshots/LandingPage.png", "screenshots/DesignFile.png",
				"screenshots/LayoutDifferences.png", "png");
	}

}
