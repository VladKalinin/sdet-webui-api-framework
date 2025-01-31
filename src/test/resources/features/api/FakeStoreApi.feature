@application=API
Feature: Fake Store API

  # Please note as it is Fake API service, values could be static
  # In this example will be shown getters with storing object with by key with List of objects
  # Also will be shown how to make verification via api with parameters
  @regression @id=1
  Scenario: Get all products
    Given get all products
    When get all users
    Then verify user morrison@gmail.com has product Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops in the cart
