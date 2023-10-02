# tendable
This is a testSuite for Tendable application

## Introduction
This repository contains a test automation project using Selenium WebDriver and Cucumber to automate the testing of the Tendable website. The project focuses on verifying the functionality of various elements on the website, such as menus, buttons, forms, and error messages.

## Prerequisites
Before running the tests, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- WebDriver (e.g.,GeckoDriver) compatible with your browser version

## Project Structure
The project is organized as follows:

- `src/test/resources/Features`: Contains Cucumber feature files with Gherkin scenarios.
- `src/test/java/stepDefinitions`: Contains step definitions for Cucumber scenarios.
- `src/test/java/actions`: Contains executable functions for each scenarios.
- `testRunner/TestRunner.java`: Cucumber test runner class.


## Setup
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).

## Running the Tests
To run the tests, follow these steps:

1. Open `testRunner/TestRunner.java`.
2. Add tags for the scenarios to be tested
3. right click, run as JUnit test.


