Feature:This feature will make sure that the home page's slider is working properly.


  Scenario Outline:The “find out more”, “start shopping”, “Pre-order now” button is visible
  and intractable on the slider.

    Given the user is on the homepage
    Then the user should be able to see "<buttonName>" button on the <slide>
    When the user click "<buttonName>" button on the <slide>
    Then the user should be able to navigate to "<related_Url>"

    Examples:
      | slide | buttonName     | related_Url                                                                                        |
      | 0     | Find out more  | https://www.playstation.com/en-gb/editorial/this-month-on-playstation/ultimate-review-of-the-year/ |
      | 1     | Start shopping | https://store.playstation.com/en-gb/category/1bc5f455-a48e-43d1-b429-9c52fa78bb4d                  |
      | 2     | Pre-order now  | https://www.playstation.com/en-gb/games/horizon-forbidden-west/                                    |
      | 3     | Find out more  | https://www.playstation.com/en-gb/ps5/games/                                                       |
      | 4     | Find out more  | https://www.playstation.com/en-gb/games/grand-theft-auto-v/                                        |








