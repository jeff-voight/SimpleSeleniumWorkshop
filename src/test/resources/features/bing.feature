@smoke
Feature: Google Search Demonstration
  As a beginner cook
  I want to search google.com for recipes
  so that I can cook meals for my friends and family
  

  @search
  Scenario Outline: Simple Bing Search
    Given I visit bing.com
    When I search bing for <searchTerm>
    Then bing retrieves more than one page of <searchTerm>
    

    Examples:
    | searchTerm |
    | fish lip recipes |
    | chicken beak recipes |
    | banana shake recipes |
    | mango shake recipes  |
    | Chicken banana recipes |
    | testing |
    | testing 2 |
    | ice tea |
   
