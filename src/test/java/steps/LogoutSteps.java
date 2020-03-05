package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HookHelper;
import org.junit.Assert;
import pages.HomePage;

public class LogoutSteps {

    private boolean loggedOut = false;

    HomePage homePage = new HomePage(HookHelper.getWebDriver());

    @Given("^The user is currently logged in Falabella's home page$")
    public void theUserIsCurrentlyLoggedInFalabellaSHomePage() {
    }

    @When("^The user hover on account div$")
    public void theUserHoverOnAccountDiv() {
        homePage.hoverAccountOptions();
    }

    @And("^Clicks logout option$")
    public void clicksLogoutOption() {
        homePage.clickLogout();
    }

    @Then("^The user should be signed out$")
    public void theUserShouldBeSignedOut() {
        loggedOut = homePage.verifyLogout();
        Assert.assertFalse("User successfully logged out", loggedOut);
    }

}
