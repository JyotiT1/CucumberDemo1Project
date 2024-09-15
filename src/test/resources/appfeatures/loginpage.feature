Feature: Test scenarios on login page feature

Background:
Given navigate user to application page

Scenario: Login page title
Given user is on flipKart site page "https://www.flipkart.com/"
When user gets the title of the page
Then page title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!1111"


Scenario: Login with invalid correct credentials
Given user navigate to login page
When user enters blank Request OTP ""
And user clicks on Request OTP button
Then verify validation messaage "Please enter valid Email ID/Mobile number"


