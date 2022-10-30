Feature: Automation Youtube Music

    Scenario: Search singer from Explore Menu
      Given user Open browser
      And user go Youtube Music
      And user go to Explore menu
      And user choose 1 playlist

    Scenario: Play Recommendation video
      Given user Open browser
      And user go Youtube Music
      When user click play button
      Then user success play the video

