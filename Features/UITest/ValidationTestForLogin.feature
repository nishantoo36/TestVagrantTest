Feature: ValidationTestForLogin

  Background:
    Given User should be on Login Page

  Scenario: Test Validation for invalid UserName with correct format
    Then user should see the "Log in | Typeform"
    When user enter username as "test@test.com"
    When user enter password as "Test@1234"
    When user click on login button
    Then user get error message as "Your login info isn't right. Try again, or reset your password if it slipped your mind. "









