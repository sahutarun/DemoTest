@API @DemoPetStoreOperations
Feature: Demo Pet Store
User want to test Pet from Demo Pet Store

@API @DemoPetStoreOperations @Test
Scenario: Verify if the user able to add and delete Pet from pet Store
Given user add a new pet in pet store and check if a pet is added
And user update the status of the pet as "sold"
When user delete the pet from the store
Then pet should be deleted

