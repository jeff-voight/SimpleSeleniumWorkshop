@smoke
Feature: Firefox Craigslist Search Demonstration

  Background:
    Given I am using the Firefox browser

  @search
  Scenario Outline: Simple Firefox Craigslist Search
    Given I visit <locality> craigslist
    When I search craigslist for <searchTerm>
    Then craigslist retrieves more than one result with <searchTerm>

    Examples:
      | locality        | searchTerm |
      | dc              | car        |
      | dc              | bike       |
      | dc              | wood       |
      | charlottesville | car        |
      | charlottesville | bike       |
      | charlottesville | wood       |
    