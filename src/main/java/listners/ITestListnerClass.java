package listners;



import org.testng.ITestListener;
import org.testng.ITestResult;


import utilities.captureScreenshot;


public class ITestListnerClass  implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		captureScreenshot.getScreenshot(result.getMethod().getMethodName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
