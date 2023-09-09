Feature: User access Website FLip

  @scenario-positive
  Scenario: Switch the language in Flip website
    Given user Open browser
    And user go Flip website
    And user switch language to English
    And user switch back to Indonesia language
