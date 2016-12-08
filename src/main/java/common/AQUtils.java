package common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AQUtils {

	public static void openNewTab(String link) {
		AQDriver.getCurrentDriver().get(link);
		AQDriver.getCurrentDriver().manage().window().maximize();
		AQDriver.waitFor(AQConstants.SHORT_WAIT_TIME);
	}

	public static File takeScreenshotOfWholeLandingPage(String landingPageUrl, String pathToSaveTakenScreenshot,
			String landingPageScreenshotExtesion) throws IOException {
		AQUtils.openNewTab(landingPageUrl);
		Screenshot expected = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(AQDriver.getCurrentDriver());
		BufferedImage landingPageBI = expected.getImage();
		File landingPageScreenshot = new File(pathToSaveTakenScreenshot);
		ImageIO.write(landingPageBI, landingPageScreenshotExtesion, landingPageScreenshot);
		return landingPageScreenshot;
	}

	public static void compareScreenshots(String pathToLangingPageScreenshot, String pathToDesignFile,
			String pathWhereToSaveScreenshotComparator, String screenshotComparatorFileExtenstion)
			throws IOException, InterruptedException {
		BufferedImage actualBufferedImage = ImageIO.read(new File(pathToLangingPageScreenshot));
		BufferedImage expectedBufferedImage = ImageIO.read(new File(pathToDesignFile));

		ImageDiff diff = new ImageDiffer().makeDiff(expectedBufferedImage, actualBufferedImage);
		Assert.assertFalse(diff.hasDiff());

		BufferedImage diffImage = diff.getMarkedImage();
		File outputfile = new File(pathWhereToSaveScreenshotComparator);
		ImageIO.write(diffImage, screenshotComparatorFileExtenstion, outputfile);
	}

}
