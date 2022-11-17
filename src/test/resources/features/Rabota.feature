Feature: Rabota by tests

  Scenario Outline: Search
    Given open home page Rabota by
    When i input search field <searchName>
    Then i check search Name <searchName>
    And i check results quantity <quantity>
    Examples:
      | searchName      | quantity |
      | "QA automation" | 44       |




