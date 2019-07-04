Feature: Login into application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And click on login Link in home page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is succesefully logged in
And close browser



Examples:
|username           |password    |
|test99@gmail.com   |123456      |




































































































