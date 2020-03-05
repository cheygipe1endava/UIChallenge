package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HookHelper;
import org.junit.Assert;
import pages.HomePage;


public class LoginSteps {

    private boolean loginInvalid = false;
    private boolean  userLoggedIn = false;

    HomePage homePage = new HomePage(HookHelper.getWebDriver());

    @And("^Opens login form overlay$")
    public void opensLoginFormOverlay() {
        homePage.openLoginFormOverlay();
    }

    @When("^The user types in invalid credentials$")
    public void theUserTypesInInvalidCredentials() {
        homePage.invalidDataInsert();
    }

    @And("^Clicks login button$")
    public void clicksLoginButton() {
        homePage.loginButton();
    }

    @Then("^Page shows error with email or password to the user$")
    public void pageShowsErrorWithEmailOrPasswordToTheUser() {
        Assert.assertTrue("Error: Invalid email or password, please check your credentials", homePage.invalidLogin());
    }

    @When("^The user types in valid credentials$")
    public void theUserTypesInValidCredentials() {
        homePage.validDataInsert();
    }

    @Then("^User should be signed in$")
    public void userShouldBeSignedIn() {
        Assert.assertFalse("Successfully logged in", homePage.userLoggedIn());

    }

}
