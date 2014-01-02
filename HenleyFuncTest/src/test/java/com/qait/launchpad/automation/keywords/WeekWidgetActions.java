package com.qait.launchpad.automation.keywords;

import org.openqa.selenium.WebDriver;
import static com.qait.automation.utils.YamlReader.getYamlValue;

import com.qait.launchpad.automation.pageuiobjects.WeekWidgetUi;

public class WeekWidgetActions extends StudentHomePageActions{

	WeekWidgetUi weekWidgetPge;
	WebDriver driver;
	int numbr;
	String currentWeek;
	int yweek;

	public WeekWidgetActions(WebDriver driver) {
		super(driver);
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
	
	public void verifyConceptMapButton()
	{
		weekWidgetPge.btn_conceptMap.isDisplayed();
		
	}
}	

