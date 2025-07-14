Feature: Contact Us form functionality

  Scenario: Submit the contact us form successfully
    Given User is on the Home page
    When User clicks on the Contact Us link
    And User fills the contact form with name, email, subject, and message
    And User clicks the Submit button
    Then A success message "Success! Your details have been submitted successfully." should be displayed
    When User clicks the Home button
    Then User should be redirected to the Home page
