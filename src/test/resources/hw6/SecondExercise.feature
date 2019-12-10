Feature: Cucumber Second Exercise

  Scenario: User Table Page test
    Given I open EPAM JDI Site
    And I login as user 'epam' with password '1234' on the Home page
    When I click on 'SERVICE' subcategory in the header on the Home page
    And I click on 'USER TABLE' in the Service sub menu on the Home Page
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns should be displayed on Users Table on User Table Page
    And 6 User names should be displayed on Users Table on User Table Page
    And 6 Description images should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select 'vip' checkbox for 'Sergey Ivan' user
    Then log row 'Vip: condition changed to true' text should be displayed in log section
    When I click on dropdown in column Type for user 'Roman'
    Then dropdown list should contain values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |