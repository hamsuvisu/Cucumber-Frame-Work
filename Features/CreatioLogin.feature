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
Feature: Creatio Login feature
  I want to use this feature file to validate login-up page, cookies consent pop-up and all the scenarios related to that

  Background: Initialize pages
    Given Initialize all pages

  Scenario: Verify cookies popup is displayed
    Given Launch the application
    Then Verify cookies popup is displayed successfully

  Scenario Outline: Verify cookies popup content
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    And Verify cookies popUp <Content>
    And Verify Cookies popup logos
    And Verify Cookies popup selection buttons

    Examples: 
      | Content                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | We may use cookies and similar technologies to collect information about the ways you interact with and use the website, to support and enhance features and functionality, to monitor performance, to personalize content and experiences, for marketing and analytics, and for other lawful purposes. We also may share information about your use of our site with our social media, advertising and analytics partners who may combine it with other information that you’ve provided to them or that they’ve collected from your use of their services. Please, see more details on the "About" tab |

  @Regression
  Scenario: Verify cookies popup switch button
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    And Verify cookies popup necessary button is disabled
    And Verify Cookies popup switch buttons are displayed and enabled

  Scenario: Verify cookies popup view details link
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    When User click on show details link
    Then User should be able to get expanded view of cookies popup

  Scenario: Verify accept cookies with Accept All
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    When User click on "AllowAll" button
    Then Cookies popup should be disappeared

  Scenario Outline: Verify Application Login
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    When User click on "AllowAll" button
    Then Cookies popup should be disappeared
    When User enter <Username> and <Password>
    And Click on Login button
    Then Login Should be successful

    Examples: 
      | Username                      | Password               |
      | bharathtechacademy4@gmail.com | BharathTechAcademy@123 |
      | invalid@test.com              | Invalid@123            |
