Feature: User access Website FLip

  @scenario1
  Scenario: Switch the language in Flip website
    Given user Open browser
    And user go Flip website
    And user switch language to English
    And user switch back to Indonesia language

  @scenario2
  Scenario: Check cellular providers supported by Flip
    Given user Open browser
    And user go Flip website
    And user scroll to Pertanyaan Seputar Flip section
    When user click FAQ about virtual product in Flip
    Then user can see cellular providers supported by Flip

  @Scenario3
  Scenario: Change currency money
    Given user Open browser
    And user go Flip globe
    And user choose Poundsterling Currency "GBP"
    When user fills amount "100000" for IDR
    Then user can see exchange rate with fee


