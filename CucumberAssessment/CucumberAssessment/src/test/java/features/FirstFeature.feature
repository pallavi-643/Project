#Author: pallavisukhwal.s@infosys.com

@tag
Feature: Verify Order details 

  @TestCase01
  Scenario: Verify that user is able to order a T-shirt on YourLogo website
    Given User is on Your Logo Website page
    When  User click signUp button and enter valid userId and password 
    And   User click on T-shirt button and Add to the cart
    And   click on Proceed for payment  
    And   close the error pop ups and proceed for payment through Bankwire Method 
    Then  Assert that newly created order is displayed in order history page
    
 
  
