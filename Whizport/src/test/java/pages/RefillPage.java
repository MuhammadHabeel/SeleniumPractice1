package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BasePage;

public class RefillPage extends BasePage{
	
															// ################################################
															// # 											  #
															// # 				Page Objects 				  #
															// # 										      #
															// ################################################

			private final String userClickRefillMedByXpath    =    "//*[@id=\"links\"]/a[4]/span";





														
															// ################################################
															// # 											  #
															// # 				Getter Methods 				  #
															// # 										      #
															// ################################################

			public WebElement getuserClickRefillMedByXpath() throws Exception {return wrapper.findApplicationObjectDynamically(By.linkText(userClickRefillMedByXpath));}

}

	
	

	
	
	


