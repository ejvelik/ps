Feature:This feature will make sure that the Coming soon section is working properly.

  @wip
  Scenario:Navigating coming soon section

    Given the user is on the homepage
    When the user scroll to New releases section
    Then the user should be able to see right arrow (>) to see the Games in Coming soon
    And the user click the right arrow (>) button
    Then the last game tile should be "God of War Ragnarök" in the Coming soon games