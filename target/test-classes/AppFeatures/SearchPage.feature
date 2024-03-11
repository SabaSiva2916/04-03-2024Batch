Feature: Search page Feature

  Background: 
    Given user has already logged in to application
      | username | password   |
      | sabasiva | Greens@890 |

  Scenario: Search page title
    Given user is on search page
    When user get the title of the page
    Then page tittle should be "Adactin.com - Search Hotel"

  Scenario: Search section count
    Given user is on search page
    Then user gets search section
      | Location*         |
      | Hotels            |
      | Room Type         |
      | Number of Rooms*  |
      | Check In Date*    |
      | Check Out Date*   |
      | Adults per Room*  |
      | Children per Room |
    And search section count should be 8
