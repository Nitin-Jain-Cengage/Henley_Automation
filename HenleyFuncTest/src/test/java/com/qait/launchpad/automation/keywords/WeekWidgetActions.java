package com.qait.launchpad.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import com.qait.launchpad.automation.pageuiobjects.WeekWidgetUi;

public class WeekWidgetActions extends StudentHomePageActions{

	WeekWidgetUi weekWidgetPge;
	WebDriver driver;
	int numbr;
	String currentWeek;
	int yweek;
	static String activity_heading;

	public WeekWidgetActions(WebDriver driver) {
		super(driver);
		this.driver=driver;
		weekWidgetPge = new WeekWidgetUi(driver);
	}
	
	public boolean verifyTotalNoOfWeeks(){
		if(weekWidgetPge.totalNoOfWeeks.size()==weekWidgetPge.NoOfWeeksOnSlider.size())
        {
			 System.out.println("Total no. of weeks:->"+weekWidgetPge.totalNoOfWeeks.size());
			 System.out.println("Total no of weeks on divider:->"+weekWidgetPge.NoOfWeeksOnSlider.size());
            return true;
        }
		else return false;
    }

	public void switchToNewWindow()
	{
		weekWidgetPge.getWindowHandle();
	}
	
	public void getCurrentDispWeek()
	{
		currentWeek = weekWidgetPge.getCurrentVisibleWeekValue.getText();
		numbr=Integer.parseInt(currentWeek.substring(currentWeek.indexOf(" ") + 1, currentWeek.indexOf(" ")+2));
		yweek= Integer.parseInt(getYamlValue("week.weeknumber"));
	
		do{
			
			if (yweek>numbr)
			{
	
				weekWidgetPge.nextWeekArrow.click();
				numbr++;
			}
			else
			{
				weekWidgetPge.previousWeekArrow.click();
				numbr--;
			}
		}while(yweek!=numbr);
	}
		
	public void getTitleOfActivity(){
		activity_heading=weekWidgetPge.titleOfActivity_Clickable().getText();
		System.out.println("Activity Title:->"+ activity_heading);
	}
		
	public void verifyActivityStatusDisplayAsCompleted() {
		Assert.assertTrue(weekWidgetPge.getPreocessingIndicator(activity_heading).isDisplayed());
		weekWidgetPge.waitForSync();
	}
	
	public void verifyConceptMapButton()
	{
		weekWidgetPge.btn_conceptMap.isDisplayed();
		
	}
	
	public void clickOnAllApps()
	{
		weekWidgetPge.btn_allApps.isDisplayed();
		weekWidgetPge.btn_allApps.click();
	}
	public void clickOnMerriamWebsterApp()
	{
			for (int i=0;i<weekWidgetPge.lbl_appName.size();i++){
		   System.out.println(weekWidgetPge.lbl_appName.get(i).getAttribute("alt")); 
		   
		   if (weekWidgetPge.lbl_appName.get(i).getAttribute("alt").equals("Merriam-Webster's Dictionary")){
			   weekWidgetPge.appNameLink.get(i).click();
		    getverifyMerriamWebsterApp();
		    
		   }else{
			   weekWidgetPge.appNameLink.get(i).click();
		    getVerify(weekWidgetPge.lbl_appName.get(i).getAttribute("alt"));
		   }
  
		   weekWidgetPge.btn_allApps.click();
		  }  
			weekWidgetPge.btn_allApps.click();
	}
	
	 public void getVerify(String appName){
		  weekWidgetPge.getHeadingNameOfTheApp(appName);
		  Assert.assertTrue(weekWidgetPge.getHeadingNameOfTheApp(appName).isDisplayed());
		  weekWidgetPge.getHeadingNameOfTheApp(appName);
		  
		  Assert.assertTrue(weekWidgetPge.getCollapse(appName).isDisplayed());
		  weekWidgetPge.getCollapse(appName).click();
	}
		 
	 public void getverifyMerriamWebsterApp(){
		 		 	  
		 weekWidgetPge.getHeadingNameOfMerriamWebsterApp();
		 weekWidgetPge.getHeadingNameOfMerriamWebsterApp().isDisplayed();
		 weekWidgetPge.getHeadingNameOfMerriamWebsterApp();
		 Assert.assertTrue(weekWidgetPge.getCollapseForMerriamWebsterApp().isDisplayed());
		 weekWidgetPge.getCollapseForMerriamWebsterApp().click();
		  
	 }
}



