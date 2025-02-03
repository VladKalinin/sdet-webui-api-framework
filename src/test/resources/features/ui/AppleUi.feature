Feature: Apple Website UI tests

  @regression @us @id=1
  Scenario: Verify Donate to 2025 Southern California wildfires is displayed
    When browser is on Home Page
    Then California wildfires popup is displayed on Home Page

  @regression @all @desktop @id=2
  Scenario: Verify top header is displayed on Home Page
    When browser is on Home Page
    Then Top header is displayed on Home Page

  @regression @all @desktop @id=3
  Scenario: Verify possible to redirect to Watch page via top header
    Given browser is on Home Page
    When click on watch tab on Home Page
    Then browser is on Watch Page

  @regression @all @id=4
  Scenario: Verify possible to redirect to Watch page via top header
    When opens Watch Page
    Then welcome video is displayed on Watch Page