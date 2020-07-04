#@smoke
#Feature: Google Search Demonstration
#  As a beginner cook
#  I want to search google.com for recipes
#  so that I can cook meals for my friends and family
#
#
#  @search
#  Scenario Outline: Simple Google Search
#    Given I visit google.com
#    When I search google for <searchTerm>
#    Then google retrieves more than one page of <searchTerm>
#
#
#    Examples:
#    | searchTerm |
#    | fish lip recipes |
#    | chicken beak recipes |
