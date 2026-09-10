Feature: Verify Php travels Flights Module

Scenario: Book The  Flight Ticket from Flight Module

Given User launches the Php Travels application
When User Clicks Flight module from Service section
Then User Navigate to flight search page and page title should be "#flights"
When User clicks Departure field and Enter the Departure city
And User Selects the city from suggestions
And User clicks Arrival field and Enter the Arrival city
And User selects the city from suggestion
And User clicks Departure date field and selects the date
And User clicks Search icon button
Then Verify that User navigate to Flight Search result page is displayed
When User clicks Sort Dropdown and Selects "Price: High to Low"
Then User Checks sort dropdown has displayed "Price: High to Low"
When User Checks the Price Range slider
When User clicks "American Airlines" Flight from search result page
Then User should navigate to the Booking details page

When User select the title
And User enters "john" in the first name field
And User enters "david" in the last name field
And User enter "john@gmail.com" in the email field
And User selects the country code
And User enters "8870708989" in the phone number field 
And User Scrolls to Passenger Details section
And User Selects the Nationality
And User Enters the Passport Number
And User checks I agree to the policy and condition listbox
And User clicks the confirm Booking button
Then  User should be navigate to Invoice detials page
