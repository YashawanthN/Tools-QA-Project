package utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseQA.baseFile;

public class generatereports extends baseFile {
	public ITestContext context;
	
	public generatereports(ITestContext context) {
		this.context = context;
	}

	public void createReport ()
	{
		// Get current date and time to create folder and file names
				String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
				String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

				// Define the report file name with Test suite name and timestamp
				String reportName = context.getSuite().getName()+"- "+timestamp + ".html";
				
				// Define the complete folder path where reports will be saved
				String folderPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + folderName;
				File folder = new File(folderPath);

				// Create the folder if it doesn't exist
				if (!folder.exists()) {
					boolean folderCreated = folder.mkdirs();
					if (!folderCreated) {
						System.err.println("Failed to create directory: " + folderPath);
						// Exit if folder creation failed
					}
				}
				String reportPath = folderPath + File.separator + reportName;
				File file = new File(reportPath);
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
				extentReport = new ExtentReports();
				extentReport.attachReporter(sparkReporter);

				extentReport.setSystemInfo("OS", System.getProperty("os.name"));
				extentReport.setSystemInfo("browser", System.getProperty("browser.name"));
			}
	
}
