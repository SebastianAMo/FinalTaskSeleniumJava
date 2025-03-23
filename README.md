# Final Task Selenium WebDriver with Java

## Technologies

- Java 17
- Selenium WebDriver
- JUnit 5
- Maven
- Hamcrest
- SLF4J
- WebDriverManager
- Cucumber

## Browser support

Currently, the project supports the following browsers:

- Firefox
- Edge

## Task description

Launch URL: https://www.saucedemo.com/

**UC-1** Test Login form with empty credentials:
   - Type any credentials into "Username" and "Password" fields.
   - Clear the inputs.
   - Hit the "Login" button.
   - Check the error messages: "Username is required".

**UC-2** Test Login form with credentials by passing Username:
   - Type any credentials in username.
   - Enter password.
   - Clear the "Password" input.
   - Hit the "Login" button.
   - Check the error messages: "Password is required".

**UC-3** Test Login form with credentials by passing Username & Password:
   - Type credentials in username which are under Accepted username are sections.
   - Enter password as secret sauce.
   - Click on Login and validate the title “Swag Labs” in the dashboard.
   - Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.

## Notes about results

- UC-1 and UC-2 failed when clear fields with the `Clear()` method. The error message with this method is : `Epic sadface: Username and password do not match any user in this service`.

  I add two methods the first use `SendKeys(Keys.Control + "a")` method to select all the text in the input and then the `SendKeys(Keys.Delete)` method to delete the text. Other one approach to clearing the fields is to simulate deleting the text character by character.  Using this approach the tests passed.



## How to run the tests

- To run all tests with default values, execute the following command:

  ```bash
  mvn clean test
  ```

- Run tests with specific browser:

  ```bash
  mvn clean test -Dbrowser=firefox
  ```
    
  ```bash
  mvn clean test -Dbrowser=edge
  ```
  
- Run tests with specific browser and headless mode:
S
  ```bash
    mvn clean test -Dbrowser=firefox -Dheadless=true
    ```
- Run tests with specific browser and specific tags:

  This is for Windows OS
  ```bash
  mvn clean test "-Dcucumber.filter.tags=@smoke"
  ```
  


## Author

[Sebastian Agudelo Morales](https://www.linkedin.com/in/sebastianamo) 
