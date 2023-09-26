Feature: Login feature

  Background: Given I open Login page

  Scenario: Login valid credentials
    Given I open Login page
    When I enter email "james.patterson@testpro.io"
    And I enter password "te$t$tudent"
    And I click submit button
    And I am logged in
    Then I close my browser


    Scenario: Login Incorrect Password


      Scenario: Login Email Not Existing
