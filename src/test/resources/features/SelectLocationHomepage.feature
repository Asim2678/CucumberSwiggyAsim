@FunctionalTest
Feature:  A user can add a food in Swiggy web application
Background:
  Given User navigate to  Swiggy web application "https://www.swiggy.com/"
 @FlowTest
  Scenario: User successfully selects Location as Ahmadabad
    When As a Swiggy application user I click on to AhmadAbad
    And User lands onto  I click onto Swiggy Ahmadabad Homepage
    And User clicks onto Pizza Hut
    Then User sets the location as Ahmadabad
@FlowTest
    Scenario: User can add an item to cart
  When As a Swiggy application user I click on to AhmadAbad
  And User lands onto  I click onto Swiggy Ahmadabad Homepage
  And User clicks onto Pizza Hut
  Then User sets the location as Ahmadabad
      When user search 'Vittlebox' in search box and click enter
      And user can see Vitalbox in options and clicks onto it
      And User lands onto VittleBox Foods and clicks onto 'Maxican Hot Pot' to add it to the cart
      Then the user can see 'Maxican Hot Pot' in the cart
