package utility;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.maven.doxia.logging.LogEnabled;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.cucumber.listener.Reporter;

import cucumber.api.java.it.Data;
import stepDefinitions.Hooks;

public class Wrapper {
	
	
	
	
	
	private WebDriver driver;
	
	public boolean isDemoMode = false;
	public boolean checkError =false;

	//Constructor
	public Wrapper(WebDriver _driver) {
		driver = _driver;
	}

	
	/**
	 * This method is use to wait for an object to be successfully present in the DOM and located
	 * @param by - User can find by xpath, id, name and CSSSelector
	 * @return	- DOM object
	 * @throws Exception
	 */
	public WebElement findApplicationObjectDynamically(By by) throws Exception {
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return myDynamicElement;
	}

	

	
	
	/**
	 * This method is use to wait for an object to be successfully present in the DOM and located
	 * @param by - User can find by xpath, id, name and CSSSelector
	 * @return	- DOM object
	 * @throws Exception
	 */
	public List<WebElement> findApplicationObjectsDynamically(By by) throws Exception {
		List<WebElement> myDynamicElement = (new WebDriverWait(driver, 300))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return myDynamicElement;
	}
	
	
	/**
	 * This method is use to wait for an object to be successfully visible in the DOM and located
	 * @param by - User can find by xpath, id, name and CSSSelector
	 * @return - DOM object
	 * @throws Exception
	 */
	public WebElement findApplicationObjectDynamicallyByVisibilityOfElement(By by) throws Exception {

		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				
				.until(ExpectedConditions.visibilityOfElementLocated(by));
			
		return myDynamicElement;

	}
	
	
	
	
	
	/**
	 * This Method is use to Highlight elaments
	 * @param element
	 * @throws Exception
	 */
	
	public void elementHighlight(WebElement element) throws Exception {

		if (isDemoMode == true) {
			for (int i = 0; i < 2; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 3px solid red; background-color:red");
		
				Thread.sleep(1000);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			}
		}
	}
	
	
	/**
	 * This Method is use to Highlight select type of element
	 * @param element
	 * @throws Exception
	 */
	
	public void elementHighlight(Select element) throws Exception {

		if (isDemoMode == true) {
			for (int i = 0; i < 2; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 3px solid red; background-color:#000000");
		
				Thread.sleep(1000);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			}
		}
	}
	
	
	
	
	/**
	 * This is method is use to only highlight the text field backbround with yellow color
	 * @param element
	 */
	
	public void highLightText(WebElement element){
		if (isDemoMode == true) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}
	}
	
	
	
	
	

	/***
	 * This method clicks any given invisible web-element using java-script executor
	 * 
	 * @param by
	 */
	public void clickInvisibleWebElement(By by) {
		
			WebElement invisibleElem = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", invisibleElem);
	
	}

	/***
	 * This method clicks any given invisible web-element using java-script executor
	 * 
	 * @param by
	 */
	public void clickInvisibleWebElement(WebElement element) {
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		
	}

	/***
	 * This method clicks any given invisible web-element using java-script executor
	 * 
	 * @param by
	 * @throws Exception 
	 */
	public void clickWebElement(WebElement element) throws Exception {
	
			elementHighlight(element);
			String elementText = element.getText().toString();
			Thread.sleep(1000);
			element.click();

			System.out.println("Clicking On Button -" + elementText);
	
	}


	/**
	 * This method is use to switch window based on the window URL
	 * @param browserUrl - Need give URL of any window you want to switch to.
	 * @return - driver
	 * @throws InterruptedException 
	 */

	public WebDriver switchWindows(String browserUrl) throws InterruptedException {
	
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				Thread.sleep(1000);
				driver.switchTo().window(window);
				String currentUrl = driver.getCurrentUrl();
				if (browserUrl.contains(currentUrl)) {
					break;
				}
			}
		
		return driver;
	}
	
	

	/**
	 * This method is use to switch window by index
	 * 
	 * @param byIndex need a number
	 */
	public void switch_Window(int byIndex) {

		Set<String> windows = driver.getWindowHandles();

		ArrayList<String> singleWindow = new ArrayList<String>(windows);

		driver.switchTo().window(singleWindow.get(byIndex));

	}

	
	/**
	 * This Method is use to switch to frame in the DOM
	 * @param by
	 */
	public void switchToIframe(By by) {
		WebElement iframeElem = driver.findElement(by);
		driver.switchTo().frame(iframeElem);
	}

	/**
	 * This Method is use to switch to frame in the DOM
	 * @param by
	 */
	public void switchToIframeByIndexNumber(int indexNumbery) {
	
		driver.switchTo().frame(indexNumbery);
	}

	
	
	/**
	 * This method is use to switch back to default page like if you switch from window one to window
	 *  two, if you use this method it switch you back to one window.
	 */
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	
//	public String getIPAddressOfCurrentSystem() throws UnknownHostException {
//		
//		//Checking for Environment IP Address
//		InetAddress localhost = InetAddress.getLocalHost();
//		String localIP = localhost.getHostAddress().trim();
//		return localIP;
//	}
	
	
	
	/**
	 * This method is use to get the current system time
	 * @return - time
	 */
	public String getCurrentTime() {
		Date date = new Date();
		String tempTime = new Timestamp(date.getTime()).toString();
		String finalTimeStamp = tempTime.replace(":", "_").replace("-", "_").replace(" ", "_").replace(".", "_");
		// System.out.println("TempTime: " + tempTime);
		// System.out.println("FinalTime: " + finalTimeStamp);
		return finalTimeStamp;
	}
	
	
	
	/**
	 * This method is use to get the current time stamp
	 * @return - time stamp
	 */
	public String getCurrentTimeStamp() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		String dateToStr = format.format(date).replace("-", "").replace(" ", "").replace(":", "");
		System.out.println(dateToStr);

		return dateToStr;
	}

	
	/**
	 * This method is use to get the current Url
	 * @return - Current Url
	 * 
	 */
	
	public WebDriver getCurrentUrl() throws InterruptedException {
		
		
				
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("www.linkedin.com")) {
			System.out.println("Verification passed");

		}else {
			System.out.println("Verification failed");
		}
		return driver;
		

	
	}
	
	
	/**
	 * This method is use to navigate back
	 * 	
	 * 
	 */
	
	public void navigateBack() {
		driver.navigate().back();
		
	}
	
	public void navigateForward() {
		driver.navigate().forward();;
		
	}
	/**
	 * This method is use to enter text into fields
	 * @param element - Object Name
	 * @param userInputValue - Text need to be enter
	 * @throws Exception
	 */
	public void enterTextField(WebElement element, String userInputValue) throws Exception {
		elementHighlight(element);
		highLightText(element);
		element.clear(); // clear the text box and delete the default value
		//System.out.println("driver 2 -" + driver);
		element.sendKeys(userInputValue);
		System.out.println("Entering '" + userInputValue + "' to text-field");
		
	}

	
	/**
	 * This method is use to enter text into fields
	 * @param element - Object Name
	 * @param userInputValue - Text need to be enter
	 * @throws Exception
	 */
	public void enterPassword(WebElement element, String userInputValue) throws Exception {
		elementHighlight(element);
		highLightText(element);
		element.clear(); // clear the text box and delete the default value
		//System.out.println("driver 2 -" + driver);
		element.sendKeys(userInputValue);
		System.out.println("Entering '" + "**********" + "' to text-field");
		Reporter.addStepLog("**********");
	}
	
	/***
	 * This method enters given input to the text fields
	 * 
	 * @param by
	 * @param userInputValue
	 * @throws Exception
	 */
	public void enterTextField(By by, String userInputValue) throws Exception {
		WebElement element = driver.findElement(by);
		elementHighlight(element);
		highLightText(element);
		element.clear(); // clear the text box and delete the default value
		element.sendKeys(userInputValue);
		System.out.println("Entering '" + userInputValue + "' to text-field");
	}

	/***
	 * This method selects drop-down elements using visible text option
	 * 
	 * @param by
	 * @param userOptionValue
	 * @throws Exception
	 */
	public void selectDropDown(WebElement dropDownName, String userOptionValue) throws Exception {

		Select dropdown = new Select(dropDownName);
		
		elementHighlight(dropdown);
		dropdown.selectByVisibleText(userOptionValue);
		System.out.println("Selecting '" + userOptionValue + "'");
		Thread.sleep(2000);
	}
	
	/***
	 * This method selects drop-down elements using visible text option
	 * 
	 * @param by
	 * @param userOptionValue
	 * @throws Exception
	 */
	public void selectDropDown(WebElement dropDownName, int indexNumber) throws Exception {

		Select dropdown = new Select(dropDownName);
		
		elementHighlight(dropdown);
		dropdown.selectByIndex(indexNumber);
	//	System.out.println("Selecting '" + userOptionValue + "'");
		Thread.sleep(2000);
	}

	

	/***
	 * This method return selects drop-down elements using visible text option
	 * 
	 * @param by
	 * @param userOptionValue
	 * @throws Exception
	 */
	public String selectDropDown(WebElement dropDownName) throws Exception {

		Select dropdown = new Select(dropDownName);
		String strCurrentValue = dropdown.getFirstSelectedOption().getText();

		elementHighlight(dropdown);
		
		return strCurrentValue;
	}
	/**
	 * This method is use to upload file This method used Java Robot Class
	 * 
	 * @param imagePath
	 * @throws InterruptedException 
	 */

	public void uploadFile(String imagePath) throws InterruptedException {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(50);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	
	}
	
	
	
	/**
	 * This method is used to upload a file with send key.
	 * @param fileUploadElem
	 * @param filePath
	 */
	
	public void fileUpload(WebElement fileUploadElem, String filePath)
	{

			
			fileUploadElem.sendKeys(filePath);
				
		
	}

	
	


	
	/**
	 * This method is used to check broken links (option) and call a private method 
	 * to verify for broken link, if found report it
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void checkBrokenSelectLink(String tag, String attribute) throws IOException, InterruptedException {

		List<WebElement> links = driver.findElements(By.tagName(tag));

		//System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute(attribute);

			verifyBrokenLink(url);

		}
		
	}
	
	

	/**
	 * This method is use to collect all links (a) and call a private method to
	 * verify for broken link, if found reported.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void checkBrokenLink() throws IOException, InterruptedException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

//		System.out.println("Total links are " + links.size());
//		Reporter.addStepLog("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");
			

			verifyBrokenLink(url);
			
		}

	}
	
	

	/** new code
	 * This method is use to collect all links (a) and call a private method to
	 * verify for broken link, if found reported.
	 * @throws Exception 
	 * example:wrapper.checkBrokenLink("*", "src");wrapper.checkBrokenLink("*", "href");
	 */

	public void checkBrokenLink(String byTag, String byAttribute) throws Exception {
		
		List<WebElement> links = findApplicationObjectsDynamically(By.cssSelector(byTag));

		//System.out.println("Total links are " + links.size());
		//Reporter.addStepLog("Total links are " + links.size());
		
		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute(byAttribute);

				verifyBrokenLink(url);
			
		}

	}
	
	
	/**
	 * This is a helper method for checking for broken links in the Application
	 * 
	 * @param linkUrl - this variable need a link address like (href)
	 * @throws IOException
	 * 
	 * Whenever we click on a link it will send a Request to Server and we get response. However, the HttpURLConnection class help us to connect to server.
	 */

	private void verifyBrokenLink(String linkUrl) throws IOException {
		
		ArrayList<String> errorMessages = new ArrayList<String>();
		
		try {
			
			
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {

				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());

				
			}
			
			
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				errorMessages.add(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
				
				//assertTrue(false);
				
			}
			
			if (httpURLConnect.getResponseCode() == 404) {
		       	  
				errorMessages.add(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
			
			
			}
			if (httpURLConnect.getResponseCode() == 400) {
		      
				errorMessages.add(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_BAD_REQUEST);
				
				
			
				
			}
			
			if (httpURLConnect.getResponseCode() == 500) {
			
				errorMessages.add(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_INTERNAL_ERROR);
			
				
			}
			
		
			
	
			 if(errorMessages.size()>0) {
				 checkError=true;
			 
				for(String message :errorMessages ) {
					
					System.out.println(message);
					Reporter.addStepLog(message);

				}
			 }
		} catch (Exception e) {
			
	
		}
	}
	
	
	
	
	/** Muhammad Habeel Hazrat
	 * This method is use to get the list of all links and images 
	 * 	 * @throws Exception 
	 * example:wrapper.checkBrokenLink("*", "src");wrapper.checkBrokenLink("*", "href");
	 */

	
public void collectlinksList(String byTag, String byAttribute) throws Exception {
		
		List<WebElement> linksList = findApplicationObjectsDynamically(By.tagName(byTag));
		linksList.addAll(driver.findElements(By.tagName(byTag)));

		System.out.println("Total number of links and images are:" + linksList.size());
		Reporter.addStepLog("Entire links are and images exists in the app is:     " + linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for (int i = 0; i < linksList.size(); i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") !=null && (!linksList.get(i).getAttribute("href").contains("tel"))&&(!linksList.get(i).getAttribute("href").contains("javascript")))  {
				activeLinks.add(linksList.get(i));
				
			}	
		}
		System.out.println(" Size of active links and images "+activeLinks.size());
		Reporter.addStepLog("total number of active links and images are: "+activeLinks.size());
		
		for(int j=0; j<activeLinks.size(); j++) {
			
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"----->"+ response);
		}

	}
	

	/**
	 * This method is use to mouse hover to any object in DOM
	 * 
	 * @param toElement - Here provide an object
	 * @throws Exception 
	 */

	public void moveMouseToElement(WebElement toElement) throws Exception {
		
			Actions action = new Actions(driver);
			elementHighlight(toElement);
			action.moveToElement(toElement).build().perform();
	
	}
	
	public void moveMouseToElementAndClickIt(WebElement toElement) throws Exception {
		
		Actions action = new Actions(driver);
		elementHighlight(toElement);
		action.moveToElement(toElement).click().build().perform();

}

	
	
	/**
	 * This method is use to take screenshot
	 * 
	 * @param driver
	 * @return
	 */
	public String getScreenshot3() {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = "/src/test/resources/screenshot/" + "--" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}

		return path;
	}
	
	
	
	public void getEmbedScreenShot() throws IOException {
		

	     String screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BASE64);
	   
	    Reporter.addScreenCaptureFromPath("data:image/jpg;base64, " + screenshot);
	    
	}
	
	
	
	
	/**
	 * This method is used to take screenshot outside of the browser.
	 */
	public void getWindowsEmbededScreenShot() {
		
		 try {
			Reporter.addScreenCaptureFromPath("data:F/jpg;base64, " + takeScreenshot());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	private final String takeScreenshot() {
  	    String base64 = "";
  	    try {

  	        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
  	        BufferedImage capture;

  	        capture = new Robot().createScreenCapture(screenRect);

  	        BufferedImage bufferedThumbnail = new BufferedImage(capture.getWidth(null), capture.getHeight(null),
  	                BufferedImage.TYPE_INT_RGB);
  	        bufferedThumbnail.getGraphics().drawImage(capture, 0, 0, null);
  	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
  	        ImageIO.write(bufferedThumbnail, "png", baos);
  	        baos.flush();
  	        byte[] imageInByte = baos.toByteArray();
  	        baos.close();
  	        byte[] encodedArr = Base64.encodeBase64(imageInByte);
  	        // base64 = encodedArr.toString();
  	        base64 = new String(encodedArr);
  	     
  	        
  	        
  	    } catch (Exception e) {
  	        e.printStackTrace();
  	        System.out.println("Error While Getting Screen Shot" + e.getLocalizedMessage());
  	    }
  	    return base64;
  	}
	
	
	
	
	
	

	/**
	 * This method is use to return the name of the method which is running
	 * 
	 * @return
	 */

	public String getMethodNameInMainClass() {

		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[3];// maybe this number needs to be corrected
		String methodName = e.getMethodName();

		return methodName;
	}
	
	
	/**
	 * This method is used to capture Error Message.
	 */
//	public void captureMessage() {
//		
//		String capMessage = driver.findElement(By.xpath());
//		System.out.println(capMessage);
//	}
	/**
	 * This method is use to check the application there is any image which has not
	 * been loaded correctly. Used HTTPClient library to check status codes of the
	 * images on a page. If they don't load correctly
	 * @throws Exception 
	 */

	public void validateInvalidImages() throws Exception {
		
			
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			// System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					elementHighlight(imgElement);
					verifyimageActive(imgElement);
					// Reporter.addStepLog(imgElement.getText());
				}

			}

			// System.out.println("Total no. of invalid images are " + invalidImageCount);

	
	}
	
	

	/**
	 * This is a helper method to find the image which HTTP status code is not equal
	 * to 200 (mean invalid image)
	 * 
	 * @param imgElement - Here add all image tag like (img)
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private void verifyimageActive(WebElement imgElement) throws ClientProtocolException, IOException {
		
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200) {
				//invalidImageCount++;
//				String temp = getScreenshot3();
//				Reporter.addScreenCaptureFromPath(temp);
				
				//getEmbedScreenShot();
				
				Reporter.addStepLog(response.getStatusLine().toString());
				assertTrue(false);
				
			}
		
		}
	
	
	
	/**
	 * This method is use to look for any type of Java Script error in the application pages.
	 * @throws IOException
	 */
	
	public void extractJavaScriptError() throws IOException {
		
	LogEntries logEntries=	driver.manage().logs().get(LogType.BROWSER);
	//Boolean checkError = false;
	for(LogEntry entry:logEntries) {
		
		System.out.println( "ERROR: " +entry.getLevel()+ " "+ entry.getMessage());
		
		Reporter.addStepLog("ERROR: " +entry.getLevel()+ " "+ entry.getMessage());
		checkError=true;
		
		
	}
		
	}
	
	
	
	
	/**
	 * This method is use to click on a link inside a table
	 * @param by - locate object
	 * @param dataCellIndexNumber - cell index# in the table where link is located 
	 * @throws Exception
	 */
	public void clickOnLinksInsideTableByIndex(WebElement table, int dataCellIndexNumber) throws Exception {
		
		

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		

		for (int i = 0; i < rows.size(); i++)

		{

			List<WebElement> cell = rows.get(i).findElements(By.tagName("td"));

			{
				int a=0;
				for (int j = 0; j < cell.size(); j++) {
					
					
					clickInvisibleWebElement(cell.get(dataCellIndexNumber).findElement(By.tagName("a")));
					a++;
					if(a==0) {
					
						
					break;
					}

				}

			}
		}
	
		
		
		
	}
	
	
	
	
	/**
	 * This Method is use to click on child link based on locating parent object of the link
	 * @param parentObject
	 * @param childLinkIndexNumber
	 */
	
	public void clickOnLinkByIndexNumber(WebElement parentObject, int childLinkIndexNumber) {
		
		List<WebElement> links = parentObject.findElements(By.tagName("a"));
		int a=0;
		
		for (int i = 0; i < links.size(); i++) {
			
				links.get(0).click();
				
		}
		
	}
	
	
	

	
	/**
	 * This method is use to mark a checkbox in a table by provide below parameters.
	 * @param parentTableBy		 - Table WebelemtnObject
	 * @param tagNameBy  		 - by Elmenet TagName like (tr or td)
	 * @param checkBoxElementBy  - provide the checkbox Object inside the table
	 * @param totolNumberOfItem  - provide the number of checkbox that need to check mark
	 * @throws Throwable
	 */
	public void checkACheckBoxItemsInsideATable(By parentTableObjectBy, By tagNameBy, By checkBoxObjectBy, int totolNumberOfItem) throws Throwable {
		Thread.sleep(5000);
		WebElement table= findApplicationObjectDynamically(parentTableObjectBy);
		
		List<WebElement> rows=table.findElements(tagNameBy);
		int a=0;
		for(int i=0;i<rows.size();i++) {
			
			
			rows.get(i).findElement(checkBoxObjectBy).click();
			a++;
			if(a==totolNumberOfItem) {
				Reporter.addStepLog("Total Document Selected  - "+totolNumberOfItem);
			break;
			}
		}
	
	}
	
	
	
	/**
	 * This method is use to double click on an element.
	 */
	
	public void doubleClick() {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("ID"));
		actions.doubleClick(elementLocator).build().perform();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This method is use to scroll by pixels of the page.
	 * @param pixels - like 1000 or 500
	 */
	
	public void scrollingInThePageByPixels(int pixels) {
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,"+pixels+")");
	}

	
	
	/**
	 * This method is use to scroll the page to any select object in the page
	 * @param elementObjectToscrollOn - Weblement Object Type - like a Table or a Button
	 * @throws InterruptedException 
	 */
	public void scrollingThePageByWebObject(WebElement elementObjectToscrollOn) throws InterruptedException {
		Thread.sleep(1000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", elementObjectToscrollOn);
	}
	
	
	

	

	
	
	public void waitForPageToBeFullyLoaded(WebDriver driver)

	{
	    new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	
	
	
	/**
	 * This method is use to select only a date in the calendar drop down
	 * @param calendarName - calendar object
	 * @param expectedDate -  day number like ( 28 or 20 or 1)
	 */
	public void selectADateInCalendar(WebElement calendarName,String expectedDate) {
		
		
		List<WebElement> rows=calendarName.findElements(By.tagName("tr"));
		for(WebElement row:rows) {
			
		
		List<WebElement> allDates=row.findElements(By.xpath("td"));
		
		for(WebElement date:allDates)
		{
			
			List<WebElement>days=date.findElements(By.tagName("a"));
			
			for(WebElement day:days) {
			
				if(day.getText().equalsIgnoreCase(expectedDate))
			{
				
					date.click();
				
					break;
			}
			
			}
			
		}
		}
	}
	
	
	
	
	
	
	
public WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(
        		
     new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                }
                }
);
                           return  foo;              }     ;
	
	
	
                           
                           
                           
                           
      public void customWait(int waitSeconds) throws InterruptedException {
    	  
    	  
    	  Thread.sleep(waitSeconds);
    	  
    	  
      }
                           
	
	
   
   /**
    * This method is used to check if a machine is up and running through the machine IP address
    * @param remoteMachineIPAddress - provide the expected machine IP Address
    */
      
      
      public void checkIfRemoteMachineIsUpAndRunningWithIPAddress(String remoteMachineIPAddress) {

          //Don't forget to leave a space after ping
          String pingcmd = "ping " + remoteMachineIPAddress;
          Runtime r = Runtime.getRuntime();
          Process p;
      try {
          p = r.exec(pingcmd);
          BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String inputLine;
         while ((inputLine = in.readLine()) != null) {

         System.out.println(inputLine);
          }
      }
       catch (IOException ex) {
         
    	   System.out.println("Expected Testing Server is Down! please read the detail message: "+ex.getMessage() );
    	   Reporter.addStepLog("Expected Testing Server is Down! please read the detail message: "+ex.getMessage() );
    	  
      }  
      
      
      }
     
      
      
    
      
      
      /**
       * This method is use to check if the file is downloaded and exist in the downloaded folder.
       * @param downloadPath
       * @param fileName
       * @return
     * @throws InterruptedException 
       */
      public boolean isFileDownloaded(String fileName) throws InterruptedException {
    
    	  
    	  Thread.sleep(6000);
    	  
    	  
    	  File dir = new File(BasePage.configProperty.readProperty("downloadFolderPath"));
    	
    	  File[] dirContents = dir.listFiles();
    	  
    	  boolean t =false;
    	  
    	  
    	  for (int i = 0; i < dirContents.length; i++)
    	  {
    	     
    		  if(dirContents[i].getName().equalsIgnoreCase(fileName) ) 
			 	{
			    
    			  Reporter.addStepLog("Attached file = "+dirContents[i].getName());
    			  t=true;
    			  break;
		    		
		  	
			 	}  
		    		  
		    	
    	  }	  
		    
    	  assertTrue(t);
		    		    	        
    	  
    	      return false;
    	  }
      
      
  
      
      
      
      
      /**
       * This method is used to look a file in a folder if find it return the full absolute path
       * @param fileName - provide the expected file name
       * @return absolute path
     * @throws InterruptedException 
       */
      public String getAttachedFile(String fileName) throws InterruptedException {
		    
       	  File dir = new File(BasePage.configProperty.readProperty("EmailAttachmentFolderPath"));
       	  File[] dirContents = dir.listFiles();
       	  
       	  boolean t =false;
       	  String filePath=null;
       	  
       	  for (int i = 0; i < dirContents.length; i++)
       	  {
       	     
       		  
       
       		  if(dirContents[i].getName().equalsIgnoreCase(fileName) ) 
    		 	{
      			  t=true;
     			 filePath=dirContents[i].getAbsolutePath(); 
     		
      			 break;
    		    			  	
    		 	}  
    		    		  
    		    	
       	  }	  
    		    
       assertTrue(t);
    		    		    	        
       	  return filePath;
       	     
       	  }
      
      
      
      
   /**
    * This method is use to generage only current date with expected date format
    * @return
    */
      public String getCurrentDate(String dateFormat) {
    	  
    	  //"ddMMMyyyy"
    	  Date date = new Date();
		  String dateModified= new SimpleDateFormat(dateFormat).format(date);
		  return dateModified;
      }
      
   
      
      
      
      
      /**
       * This method is use to generage only current date day without any character betweens
       * like: 08NOV2019
       * @return
       */
         public String getCurrentDateDayWithFormatDD() {
       	  
       	  Date date = new Date();
   		  String dateModified= new SimpleDateFormat("dd").format(date);
   		  return dateModified;
         }
      
         

         /**
          * This method is use to generage only current date Month without any character betweens
          * like: 08NOV2019
          * @return
          */
            public String getCurrentDateMonthWithFormatMM() {
          	  
          	  Date date = new Date();
      		  String dateModified= new SimpleDateFormat("MM").format(date);
      		  return dateModified;
            }
            
            
            
            /**
             * This method is use to generage only current date Month without any character betweens
             * like: 08NOV2019
             * @return
             */
               public String getCurrentDateYearWithFormatYYYY() {
             	  
             	  Date date = new Date();
         		  String dateModified= new SimpleDateFormat("YYYY").format(date);
         		  return dateModified;
               }
               
               
               
              public String addDayToTheCurrentDate(int numberOfDays) {
               
       		SimpleDateFormat sdf = new SimpleDateFormat("dd");
    		Calendar c = Calendar.getInstance();
    		c.setTime(new Date()); // Now use today date.
    		c.add(Calendar.DATE, numberOfDays); // Adding 5 days
    		String output = sdf.format(c.getTime());
   
            return output;
              }
               
               
      
      /**
       * This method is use to generage only current date without any character betweens
       * like: 08NOV2019
       * @return
       */
         public String getCurrentTimeFormatHHMMSS() {
       	  
        	   Date date = new Date();
				  String dateModified= new SimpleDateFormat("HHmmss").format(date);
   		  return dateModified;
         }
         
      
         /**
     	 * This method is use to click hidden Element while element
     	 * @param by - User can find by xpath, id, name and CSSSelector
         * @return 
     	 * @return	- DOM object
     	 * @throws Exception
     	 *//*
         public void clickHiddenElement(Object object) {
        		
 			JavascriptExecutor js = (JavascriptExecutor) driver;
 			js.executeScript("arguments[0].click();", object);
 		} 
         */
       /**
        * This method is used to click an item in the list by tag
        * @param parentElement - provide a parent webElement
        * @param tag - provide the element tag like (a)
        * @param itemName - provide specific item
     * @throws Exception 
        */
         
     public void clickSpecificItemInAListByTag(WebElement parentElement,String tag,String expectedItem) throws Exception  {  
    	
    	 
    	 List<WebElement> itemlist=parentElement.findElements(By.tagName(tag));
    	// ,String itemName

    	 
		for(WebElement item:itemlist) {
		
			if(item.getText().equals(expectedItem)) {
				
							clickWebElement(item);
									break;
					}
		}
		
     }
		
		

     
     /**
      * This method is used to verify an item in the list by tag
      * @param parentElement - provide a parent webElement
      * @param tag - provide the element tag like (a)
      * @param itemName - provide specific item
      */
   public void verifySpecificItemInAListByTag(WebElement parentElement,String tag,String expectedItem)  {  
   	
	   List<WebElement> itemlist=parentElement.findElements(By.tagName(tag));
  	
		for(WebElement item:itemlist) {
			
			if(item.getText().equals(expectedItem)) {
				
				assertEquals(expectedItem, item.getText());
				Reporter.addStepLog(expectedItem);
			}
			
		}
  
}
      
      
      
      
      
   
   
   public String splitAndReversAnStringDateTypeAsYYYYMMDD(String text,String separatorSymbol) {
	   
	   String[] arrOfStr = text.split(separatorSymbol);
		  String text2="";
	      for (String a: arrOfStr)
	    	  text2+=a;
	    	  
    
	      
	      String month=text2.substring(0, 2).toString();
	      String day=text2.substring(2, 4).toString();
	      String year=text2.substring(4, 8).toString();
	      String expectedDate=year+month+day;
	      return    expectedDate;
   }
   
   
   
   
   
   
   public String addMonthInTheCurrentDate(int numberOfMonth,String dateFormat) {
	 
	   
	   Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.MONTH, numberOfMonth);
		dt = c.getTime();
		  String dateModified= new SimpleDateFormat(dateFormat).format(dt);
		  
		  return dateModified;
   }
   
   
   
   
   public String minusDaysFromCurrentDate(int numberOfDays,String dateFormat) {
	   
	   
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE,-+numberOfDays);
		dt = c.getTime();
		 String dateModified= new SimpleDateFormat(dateFormat).format(dt);
		  
		  return dateModified;
   }
   
   
   
   public String addDaysInTheCurrentDate(int numberOfDays,String dateFormat) {
	   
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date()); // Now use today date.
		c2.add(Calendar.DATE, numberOfDays); // Adding 5 days
		String output = sdf.format(c2.getTime());
	
		return output;
   }
     
   
   
   public int getTotalNumberOfCharactorInAText(String expectedText) {
	   
	   
	  
	 		int count=0;
	 		
	 		for(int i=0;i<expectedText.length();i++) {
	 			
	 			count++;
	 		}
	 	    
	 		return count;
	 	
   }
   
   
   
   
   
   
   
   public void acceptAlertPopUp() {
	   
	  driver.switchTo().alert().accept();
   }
   
   
   
   
   
   
   public boolean isElementPresent(By by) {
	   try {
	   
		   driver.findElement(by);

	     return true;
	   }
	 catch (org.openqa.selenium.NoSuchElementException e) {
	     return false;
	   }
	 }
   
   
   
   
   public String renameFile(String expectedFilePathToChangeName,String newFilePath,String fileType) {
		   

	File f1 = new File(expectedFilePathToChangeName);
	
	Date date = new Date();
	String dateModified= new SimpleDateFormat("mmddyyyHHmmss").format(date);
	
	File f2 = new File(System.getProperty("user.dir")+newFilePath+"test data -"+dateModified+"."+fileType);
	
	boolean b = f1.renameTo(f2);
	
	System.out.println("File name change:"+b);
		String filePath=f2.getAbsolutePath();

		return filePath ;	
		}
   
   
   public String getAFileNameFromProjectDirectory(String specificFolderReletivePath) {
	   
	   File folder = new File(System.getProperty("user.dir")+specificFolderReletivePath);
		File[] listOfFiles = folder.listFiles();
		String specificFileName=null;
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	specificFileName= file.getAbsolutePath();    
		    }
		}
		return specificFileName;
   }
   
   
  
   
      
      
	}




















