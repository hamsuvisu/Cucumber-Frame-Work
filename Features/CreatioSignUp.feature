#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Creatio SignUp feature
  I want to use this feature file to validate sign-up page and all the scenarios related to that

  Background: Initialize pages
    Given Initialize all pages

  @Regression
  Scenario Outline: Verify Sign Up Feature
    Given Launch the application
    Then Close the cookies popUp by selecting the option "AllowAll"
    When User click on the SignUp link
    Then SignUp page should be launched
    When User entered <Username> and <Password>
    And Click on Continue button
    And Enter Company Details
    And Click on SignUp button
    Then SignUp should be successful

    Examples: 
      | Username                     | Password             |
      | Bharattechacademy2@gmail.com | Bharattechacademy123 |
