package stepDefinitions;
import static org.BaseClass.*;

import org.BaseClass;

import static actions.TendableTest.*;
import io.cucumber.java.en.*;

public class Tendable_StepDef extends BaseClass {


@Given("I am on the Tendable website homepage")
public void i_am_on_the_tendable_website_homepage() {
	launchApplication();
	launchApplicationTendable();
}

@When("I navigate to the Home page")
public void i_navigate_to_the_Home_page() {
	homePage();

}

@Then("I should see that the {string} menu is accessible")
public void i_should_see_that_the_our_story_menu_is_accessible(String menu) {
	confirmMenuAccessibility(menu);
}

@When("I navigate to the {string} page")
public void i_navigate_to_the_page(String menu) {
	clickOnMenu(menu);
}

@Then("I verify the presence and activity of the {string} button in {string} page")
public void i_verify_the_presence_and_activity_of_the_button(String button, String menuName) {
	verifyDemoButton(button,menuName );
}

@When("I navigate to the Contact Us section")
public void i_navigate_to_the_section() {
	navigateToContactUs();

}

@When("I choose Contact under Marketing label")
public void i_choose_Contact_under_Marketing_label() {
	clickOnMarketingContact();
}

@When("I complete the form excluding the Message field")
public void i_complete_the_form_excluding_the_Message_field() {
	completeForm();
}

@When("I submit the form")
public void i_submit_the_form() {
	submitForm();
}

@Then("I should see an error message displayed")
public void i_should_see_an_error_message_displayed() {
	isErrorMessageDisplayed();
}

@Then("I mark the test as PASS")
public void i_mark_the_test_as_pass() {
	setErrorMessage();
}

@Then("I should not see an error message displayed")
public void i_should_not_see_an_error_message_displayed() {
	isErrorMessageDisplayed();

}

@Then("I create a bug report")
public void i_create_a_bug_report() {
}

@Then("I mark the test as FAIL")
public void i_mark_the_test_as_fail() {
	setErrorMessage();
}
}

