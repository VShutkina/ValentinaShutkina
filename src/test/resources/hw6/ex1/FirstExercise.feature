Feature: Cucumber First Exercise

  Scenario: Home page test
    Given I open EPAM JDI Site
    When I login as user 'epam' with password '1234' on the Home page
    Then username should be 'PITER CHAILOVSKII' on the Home page
    And pictures should be displayed on the Home page
    And pictures texts should be displayed on the Home page
    And headline should be 'EPAM FRAMEWORK WISHES…' on the Home page
    And description should start with 'LOREM IPSUM' on the Home page
    When I click on 'SERVICE' subcategory in the header on the Home page
    Then Service drop down should contain in the header
      | SUPPORT            |
      | DATES              |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
    When I click on 'Service' subcategory in the left section on the Home page
    Then Service drop down should contain in the left section
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |

  Scenario: Different Elements page test
    Given I open EPAM JDI Site
    And I login as user 'epam' with password '1234' on the Home page
    When I click on 'SERVICE' subcategory in the header on the Home page
    And I click on 'DIFFERENT ELEMENTS' in the Service sub menu on the Home Page
    Then checkboxes should be displayed on the Different Elements page
    And radio buttons should be displayed on the Different Elements page
    And dropdown should be displayed on the Different Elements page
    And button should be displayed on the Different Elements page
    And default button should be displayed on the Different Elements page
    And Right Section should be displayed on the Different Elements page
    And Left Section should be displayed on the Different Elements page
    When I select 'Water' checkboxes on the Different Elements page
    Then log row should be 'Water: condition changed to true' on the Different Elements page
    When I select 'Wind' checkboxes on the Different Elements page
    Then log row should be 'Wind: condition changed to true' on the Different Elements page
    When I select 'Selen' radio button on the Different Elements page
    Then log row should be 'value changed to Selen' on the Different Elements page
    When I select 'Yellow' value in dropdown on the Different Elements page
    Then log row should be 'Colors: value changed to Yellow' on the Different Elements page
    When I select 'Water' checkboxes on the Different Elements page
    Then log row should be 'Water: condition changed to false' on the Different Elements page
    When I select 'Wind' checkboxes on the Different Elements page
    Then log row should be 'Wind: condition changed to false' on the Different Elements page