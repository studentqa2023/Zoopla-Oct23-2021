Feature: Zoopla login test
#Description:
#Background:
Scenario: As a zoopla user, I should be able to login using valid credentials
Given open the browser and pass the URL
When enter valid username and password
Then Login should be successful