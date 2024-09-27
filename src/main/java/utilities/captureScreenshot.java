package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseQA.baseFile;

public class captureScreenshot extends baseFile{
	public static String getScreenshot(String testName)
	{
		 // Get current date and time to create folder and file names
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
     // Define the screenshot file name with test name and timestamp
        String screenshotName = testName + "_" + timestamp + ".png";
			

     // Define the complete folder path where screenshots will be saved
        String folderPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + folderName;
        File folder = new File(folderPath);

        // Create the folder if it doesn't exist
        if (!folder.exists()) {
            boolean folderCreated = folder.mkdirs();
            if (!folderCreated) {
                System.err.println("Failed to create directory: " + folderPath);
                return null; // Exit if folder creation failed
            }
        }
        	
        //TakeScreenshot
		TakesScreenshot  takeScreenshot = (TakesScreenshot) driver;
		File sourceFile=	takeScreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = folderPath + File.separator + screenshotName;
		File destinationFile = new File(screenshotPath);
		//Save the screenshot
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot saved at: " + screenshotPath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("screenshot saved successfully");
		return screenshotPath;
	
	}
	

}
