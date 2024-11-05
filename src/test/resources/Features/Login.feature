Feature: Login Feature

  Scenario: Login Positive Scenario
    Given I open Koel login page
    When I enter email "tatevik.hovhannisyan1@testpro.io"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am logged in
