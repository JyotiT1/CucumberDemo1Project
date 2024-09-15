Feature: Test scenarios for product categories

Background:
Given navigate user to application page

Scenario: Login page title
Given user is on flipKart site page "https://www.flipkart.com/"
When user gets the title of the page
Then page title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

Scenario: Navigate to product using category
Given user is on flipKart site page "https://www.flipkart.com/"
When user mouse hover to fashion menu
When user click on watch and Accessories
Then verify title should be "Wrist Watches - Buy Branded Watches | Men's & Ladies Wrist/Hand Watches Online at Best Prices - Flipkart.com"

Scenario: Navigate to product using category
Given user is on flipKart site page "https://www.flipkart.com/"
And page title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
Then user gets menu Category
|Grocery|
|Mobiles|
|Fashion|
|Electronics|
|Home & Furniture|
|Appliances|
|Travel|
|Beauty, Toys & More|
|Two Wheelers|
And Menu Category should be 9

