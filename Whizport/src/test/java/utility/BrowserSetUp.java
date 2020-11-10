package utility;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.cucumber.listener.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetUp extends BasePage {

	private WebDriver driver;

	// Constructor
	public BrowserSetUp(WebDriver _driver) {

		this.driver = _driver;
	}

	public String browserName;
	
	
	
	
	/**
	 * This is method is use to check for Test environment - like if IP address match with local it will run test in local otherwise it will run it in Remote server 
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	
	public WebDriver openBrowser() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		// Checking for Environment IP Address
		InetAddress localhost = InetAddress.getLocalHost();
		//get the IP address
		String localIP = localhost.getHostAddress().trim();
	
		//This is used to check if the IP is match with local IP then it will open local browsers
		//Make sure to change the LocalMachineIPAddress in the config.properties file to your computer IP address
		//If its not match then the test will look to run the test in remote computer or if there is no remote computer 
		//It will not run it.
		if (localIP.contentEquals(configProperty.readProperty("LocalMachineIPAddress")) ) {
			
			//start local browser in your computer.
			startLocalBrowser();
	
		} else {

			
			//This is used to start remote browser in the remote computer.
			//Make sure to add or change the Remote machine IP Address in the config.properties file.
			startRemoteBrowser(configProperty.readProperty("RemoteMachineIPAddress"));
		}
		return driver;
	}

	
	
	
	
	/**
	 * This method is use to open local browser
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public WebDriver startLocalBrowser() throws IOException, InterruptedException {

		
		browserName = BasePage.configProperty.readProperty("browserType");	
		
		
		// this is browser name pass from pom and read with this line for select browser name from jenkins.
		//String browser = System.getProperty("propertyName");
		
		DesiredCapabilities capabilities =null;
		
		switch (browserName.toLowerCase()) 
		
		{
		
		case "ie":

			WebDriverManager.iedriver().arch32().setup();
			driver=new InternetExplorerDriver();
			capabilities = new DesiredCapabilities();
			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		        capabilities.setCapability("requireWindowFocus", true);
		        capabilities.setCapability("nativeEvents", false);
		        capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		        capabilities.setCapability("ignoreProtectedModeSetting", true);
		        capabilities.setCapability("disable-popup-blocking", true);
		        capabilities.setCapability("enablePersistentHover", true);
		        capabilities.setCapability("ignoreZoomSetting", true);
		        capabilities.setCapability("EnableNativeEvents", false);
		        capabilities.setCapability("ie.ensureCleanSession", true);
		        capabilities.setCapability("allow-blocked-content", true);
		        capabilities.setCapability("-ignore-certificate-errors", true );
		        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		        
		        
			windowManagement();
			System.out.println("Starting 'IE' browser !");
			browserName="Internet Explorer - " +capabilities.getVersion() ;
			break;

		case "chrome":
			WebDriverManager.chromedriver().version("85").setup();

			driver= new ChromeDriver();
			windowManagement();
			//browserName="Chrome - " +capabilities.getVersion();
			System.out.println("Starting 'Chrome' browser !");
			break;
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			capabilities = new DesiredCapabilities();
			driver= new FirefoxDriver();
			windowManagement();
			System.out.println("Starting 'Firefox' browser !");
			browserName="Firefox - " +capabilities.getVersion();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			windowManagement();
			browserName="Chrome - " +WebDriverManager.chromedriver().getVersions();
			System.out.println("User selected browser: " + browser + ", Starting default browser - Chrome!");
			
		}
		return driver;
	}

	
	
	
	

	/**
	 * This method is use to open Remote browser in the selenium Hub server
	 * @param hubURL
	 * @return
	 */
	public WebDriver startRemoteBrowser(String hubURL) {

		DesiredCapabilities capabilities = null;

		try {
			
		// uncomment below if  when browser type select from local config.properties file .
		//if (configProperty.readProperty("browserType").equalsIgnoreCase("Chrome")) { 
			
			
		//uncomment below if when browser type select from jenkins
		 if(System.getProperty("browserType").equalsIgnoreCase("Chrome")) { 
				
				//this chorme option is used to changing the download folder path for customize path	
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory",configProperty.readProperty("downloadFolderPath"));
				 
				
				
				
				 //"+ File.separator + "externalFiles" + File.separator + "downloadFiles
				 //System.getProperty("user.dir") 
				 
				 ChromeOptions options = new ChromeOptions();
			     options.setExperimentalOption("prefs", prefs);
			     capabilities = DesiredCapabilities.chrome();
			     capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			     capabilities.setCapability("applicationCacheEnabled", false);								

			   //this is used to start the test to specific chrome browser in the selenium hub
				capabilities.setCapability("applicationName", configProperty.readProperty("ChromeBrowserNameInSeleniumServer"));
				LoggingPreferences loggingPreferences = new LoggingPreferences();
				loggingPreferences.enable(LogType.BROWSER, Level.SEVERE);
				
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
				this.browserName="Chrome - " +capabilities.getVersion();
				System.out.println("Starting 'Remote Chrome' browser !");
				
			}
		

			else
				// uncomment below if  when browser type select from local config.properties file .
				//if (configProperty.readProperty("browserType").equalsIgnoreCase("IE")) {
				
			//uncomment below if when browser type select from jenkins
			 if(System.getProperty("browserType").equalsIgnoreCase("IE")) {
					
				    capabilities = DesiredCapabilities.internetExplorer();
				    //this is used to start the test to specific IE browser in the selenium hub
				    capabilities.setCapability("applicationName", configProperty.readProperty("IEBrowserNameInSeleniumServer"));
				    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			        capabilities.setCapability("requireWindowFocus", true);
			        capabilities.setCapability("nativeEvents", false);
			        capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			        capabilities.setCapability("ignoreProtectedModeSetting", true);
			        capabilities.setCapability("disable-popup-blocking", true);
			        capabilities.setCapability("enablePersistentHover", true);
			        capabilities.setCapability("ignoreZoomSetting", true);
			        capabilities.setCapability("EnableNativeEvents", false);
			        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			        
			        
			        String path = "\\\\rft01\\C$\\Users\\ajalal\\Desktop\\downloadedFoderForTemporaryFiles\\";
			        String cmd1 = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Default Download Directory\" /T REG_SZ /D "+ path;

					        try {
					            Runtime.getRuntime().exec(cmd1);
					        } catch (Exception e) {
					            System.out.println("Coulnd't change the registry for default directory for IE");
					        }
					        
			     
			        this.browserName="Internet Explorer - " +capabilities.getVersion() ;
				     System.out.println("Starting 'Remote ie' browser !");

			} else 
				
				
		// uncomment below if  when browser type select from local config.properties file .
		// if (configProperty.readProperty("browserType").equalsIgnoreCase("firefox")) {
				
				
		//uncomment below if when browser type select from jenkins		
		if(System.getProperty("browserType").equalsIgnoreCase("Firefox")) { 

				capabilities = DesiredCapabilities.firefox();
				 //this is used to start the test to specific Firefox browser in the selenium hub
				capabilities.setCapability("applicationName", configProperty.readProperty("FirefoxBrowserNameInSeleniumServer"));//this is start the test to specific chrome in the selenium hub
				this.browserName="Firefox - " +capabilities.getVersion() ;
				System.out.println("Starting 'Remote firefox' browser !");

			}
			else {
				
				capabilities = DesiredCapabilities.chrome();
				LoggingPreferences loggingPreferences = new LoggingPreferences();
				capabilities.setCapability("applicationName", "chromeInSeleniumServerRTF01");//this is start the test to specific chrome in the selenium hub
				loggingPreferences.enable(LogType.BROWSER, Level.SEVERE);
				
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
				capabilities.setCapability("applicationCacheEnabled", false);	
				this.browserName="Chrome - " +capabilities.getVersion() ;
				System.out.println("User selected remote browser: " + System.getProperty("browserType").equalsIgnoreCase("Chrome")+ ", Starting default remote browser - Chrome!");
				
			}
			
			
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			
			// this code the local directory to remote directory
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			windowManagement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.addStepLog(e.getMessage());
			assertTrue(false);
		}
		return driver;
	}

	
	
	
	
	
	

	//Page Management setup
	private void windowManagement() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}