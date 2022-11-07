Feature: Rabota by tests

  Scenario Outline: Search
    Given open home page Rabota by
    When i input search field <searchName>
    Then i check search Name <searchName>
    Examples:
      | searchName      |
      | "QA Automation" |




