Feature: Word
  As a user I want to be able to guess letters to figure out the hidden word
  Scenario: Letter 'a' is in word "cat"
    Given that the user is on the hangman page
    When the user enters letter "a"
    Then the user sees he has guessed a "correct" letter

 Scenario: Letter 'x' is not in word "cat"
    Given that the user is on the hangman page
    When the user enters letter "x"
    Then the user sees he has a "incorrect" letter