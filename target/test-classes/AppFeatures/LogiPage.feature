
Feature: Login page Feature

Scenario: Login page Title
 Given user is on login page
 When user get the title of the page
 Then page tittle should be "Adactin.com - Hotel Reservation System"
 
 Scenario: Forgot password link
 Given user is on login page
 Then forgot password link should be displayed
 
 Scenario: login with correct credentials
  Given user is on login page
  When user enter username "sabasiva"
  And user enter password "Greens@890"
  And user click on login button
  Then user get the title of the page
  And page tittle should be "Adactin.com - Search Hotel"
  
   