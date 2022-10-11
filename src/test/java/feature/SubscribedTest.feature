Feature: STCtv feature Validations

  @Subscribed
  Scenario: To Validate User able to lands on STC tv home page
    Given User enter STCtv URL
    Then Validate STCtv home page displayed correctly and title matches

  @Subscribed
  Scenario Outline: To Validate user able to validate the subscription details of each country 
    Given User to validate title of the page
    Then Validate <Country> Subscription Packages and price populated correctly
    
   Examples:
		| Country |
		| Bahrain |
		| KSA     |
		| Kuwait  |
    
   
