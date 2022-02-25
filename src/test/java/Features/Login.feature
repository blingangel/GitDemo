Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with Chrome
    When Navigate to "http://www.qaclickacademy.com/" site
    Then Click on Login link in home page to sign in
    And Enter "<username>" and "<password>" and logs in
    Then Verify that user is successfully logged in
    And Close browser

    Examples:
      | username            | password |
      | nbhai1999@gmail.com | Abc123   |
      | test123@gmail.com   | Henlo123 |

