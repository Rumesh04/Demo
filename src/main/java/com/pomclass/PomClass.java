package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class PomClass extends BaseClass {
	
	public PomClass() {
		PageFactory.initElements(driver, this);
	}
	
	//Service section
	@FindBy(xpath = "(//div[text()='Departure From'])[1]")
	private WebElement clickDepartureField;
	
	@FindBy(id = "fl_from_q")
	private WebElement enterCityName;
	
	@FindBy(xpath = "//div[contains(text(),'Chennai,')]")
	private WebElement selectTheCity;
	
	@FindBy(xpath = "(//div[text()='Arrival To'])[1]")
	private WebElement clickArrivalField;
	
	@FindBy(id = "fl_to_q")
	private WebElement enterArrivalCityName;
	
	@FindBy(xpath = "//div[contains(text(),'New Delhi')]")
	private WebElement selectTheArrivalCity;
	
	@FindBy(id = "flights_departure_date")
	private WebElement clickDepartureDate;
	
	@FindBy(xpath = "//div[contains(@class,'day') and normalize-space()='10']")
	private WebElement selectDate;
	
	@FindBy(xpath = "//button[@title='Search Flights']")
	private WebElement clickSearch;
	
	@FindBy(id = "acknowledgeDemoWarning")
	private WebElement handlePopUp;
	
	@FindBy(xpath = "//span[text()='Flights']")
	private WebElement clickFlightsModule;

//	public WebElement getEnterArrivalCityName() {
//		return enterArrivalCityName;
//	}

	public WebElement getClickFlightsModule() {
		return clickFlightsModule;
	}

	public WebElement getHandlePopUp() {
		return handlePopUp;
	}

	public WebElement getClickDepartureField() {
		return clickDepartureField;
	}

	public WebElement getEnterCityName() {
		return enterCityName;
	}

	public WebElement getSelectTheCity() {
		return selectTheCity;
	}

	public WebElement getClickArrivalField() {
		return clickArrivalField;
	}

	public WebElement getEnterArrivalCityName() {
		return enterArrivalCityName;
	}

	public WebElement getSelectTheArrivalCity() {
		return selectTheArrivalCity;
	}

	public WebElement getClickDepartureDate() {
		return clickDepartureDate;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getClickSearch() {
		return clickSearch;
	}
	
	//search result page
	@FindBy(xpath = "(//p[text()='British Airways'])[2]")
	private WebElement checkFlight;
	
	@FindBy(xpath = "//div[@class='p-3 sm:p-4']")
	private List<WebElement> totalFlights;
	
	@FindBy(xpath = "//p[contains(@class,'text-[11px] font-semibold text-gray')]")
	private List<WebElement> flightName;
	
	@FindBy(xpath = "//*[normalize-space()='American Airlines']/ancestor::div[.//button[.//span[normalize-space()='Book Now']]][1]//button[.//span[normalize-space()='Book Now']]")
	private WebElement clickBookBtn;
	
	@FindBy(xpath = "(//select[@class='select'])[1]")
	private WebElement clickDropDown;
	
	@FindBy(xpath = "//option[text()='Price: High to Low']")
	private WebElement checkSortOption;
	
	@FindBy(xpath = "//div[@class='noUi-connect']")
	private WebElement sliderRange;
	
	@FindBy(xpath = "//div[@class='noUi-touch-area']")
	private List<WebElement> slider;
	
	

	public WebElement getSliderRange() {
		return sliderRange;
	}

	public List<WebElement> getSlider() {
		return slider;
	}

	public WebElement getCheckSortOption() {
		return checkSortOption;
	}

	public WebElement getClickDropDown() {
		return clickDropDown;
	}

	public WebElement getCheckFlight() {
		return checkFlight;
	}

	public List<WebElement> getTotalFlights() {
		return totalFlights;
	}

	public List<WebElement> getFlightName() {
		return flightName;
	}

	public WebElement getClickBookBtn() {
		return clickBookBtn;
	}
	
	//booking page
	@FindBy(xpath = "(//select[@class='select'])[1]")
	private WebElement selectTitle;
	
	@FindBy(xpath = "//input[@placeholder='Enter First Name']")
	private WebElement enterFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	private WebElement enterLasttName;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Email'])[2]")
	private WebElement enterEmail;
	
	@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
	private WebElement enterPhNo;
	
	@FindBy(xpath = "(//select[@class='select'])[2]")
	private WebElement clickCountryCode;
	
	@FindBy(xpath = "//h3[text()='Passengers Details']")
	private WebElement scrollToPassengerDetail;
	
	@FindBy(xpath = "(//option[@value='IN'])[1]")
	private WebElement selectCountryCode;
	
	@FindBy(xpath = "(//select[@class='select'])[4]")
	private WebElement selectNationality;
	
	@FindBy(xpath = "//input[@placeholder='6 - 15 Numbers']")
	private WebElement enterPassportCode;
	
	@FindBy(xpath = "(//span[text()='check']/parent::div)[2]")
	private WebElement clickListBox;
	
	@FindBy(xpath = "//button[@class='btn w-full mt-6']")
	private WebElement clickConfirmBtn;

	public WebElement getSelectNationality() {
		return selectNationality;
	}

	public WebElement getEnterPassportCode() {
		return enterPassportCode;
	}

	public WebElement getClickListBox() {
		return clickListBox;
	}

	public WebElement getClickConfirmBtn() {
		return clickConfirmBtn;
	}

	public WebElement getSelectCountryCode() {
		return selectCountryCode;
	}

	public WebElement getSelectTitle() {
		return selectTitle;
	}

	public WebElement getEnterFirstName() {
		return enterFirstName;
	}

	public WebElement getEnterLasttName() {
		return enterLasttName;
	}

	public WebElement getEnterEmail() {
		return enterEmail;
	}

	public WebElement getEnterPhNo() {
		return enterPhNo;
	}

	public WebElement getClickCountryCode() {
		return clickCountryCode;
	}

	public WebElement getScrollToPassengerDetail() {
		return scrollToPassengerDetail;
	}




}
