
Feature: Login feature

  @regression
  Scenario: Valid login credentials
    Given The user is on  Orange HRM page
    When The user enters valid user name as "Admin" and  password as "admin123" and user clicks on login button
    Then The user should be able to log in and directed to Dashboard page