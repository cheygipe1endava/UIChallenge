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
        loginInvalid = homePage.invalidLogin();
        Assert.assertTrue("Error: Invalid email or password, please check your credentials", loginInvalid);
    }

    @When("^The user types in valid credentials$")
    public void theUserTypesInValidCredentials() {
        homePage.validDataInsert();
    }

    @Then("^User should be signed in$")
    public void userShouldBeSignedIn() {
        userLoggedIn = homePage.userLoggedIn();
        Assert.assertFalse("Successfully logged in", userLoggedIn);

    }

}
