@test
Feature: Tendable Website Test

  #Background:
  #Given I am on the Tendable website homepage
  
  Scenario: Confirm the presence of the top-level menus
    Given I am on the Tendable website homepage
    When I navigate to the Home page
    Then I should see that the "Our Story" menu is accessible
    And I should see that the "Our Solution" menu is accessible
    And I should see that the "Why Tendable?" menu is accessible

  Scenario: Verify the presence and activity of "Request a Demo" button
    When I navigate to the "Our Story" page
    Then I verify the presence and activity of the "Request a Demo" button in "Our Story" page
    When I navigate to the "Our Solution" page
    Then I verify the presence and activity of the "Request a Demo" button in "Our Solution" page
    When I navigate to the "Why Tendable?" page
    Then I verify the presence and activity of the "Request a Demo" button in "Why Tendable?" page

  Scenario: Test the "Contact Us" form with missing "Message" field
    When I navigate to the Contact Us section
    And I choose Contact under Marketing label
    And I complete the form excluding the Message field
    And I submit the form
    Then I should see an error message displayed
    And I mark the test as PASS

  Scenario: Report a bug if the error message is not displayed
    When I navigate to the Contact Us section
    And I choose Contact under Marketing label
    And I complete the form excluding the Message field
    And I submit the form
    Then I should not see an error message displayed
    And I mark the test as FAIL
