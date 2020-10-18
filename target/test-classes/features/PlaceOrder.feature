@UI
Feature: Place an Order
User want to place an order from DEMO ONLINE SHOP

@UI @PlaceOrder @Test
Scenario: Verify if the user able to place an order from the DEMO ONLINE SHOP
Given user open the site DEMO ONLINE SHOP
And user navigate to "Laptop" and select "Sony vaio i5" and click on "Add to cart" and accept pop up confirmation.
And user navigate to home page
And user navigate to "Laptop" and select "Dell i7 8gb" and click on "Add to cart" and accept pop up confirmation.
And user navigate to "Cart" and Delete "Dell i7 8gb" from cart.
When user click on "Place order".
And user Fill in all web form fields and 
And user click on "Purchase" and capture and log purchase Id and Amount.
Then purchase amount equals expected.
And Click on "Ok"

