package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HookHelper;
import org.junit.Assert;
import pages.RegistrationPage;

public class InvalidRegistrationStep {

    private boolean cellphoneEmptyMessage;




    RegistrationPage registrationPage = new RegistrationPage(HookHelper.getWebDriver());

    @Given("^The user is in Falabella's home page$")
    public void theUserIsInFalabellaSHomePage() {
    }

    @And("^Goes to the registration page$")
    public void goesToTheRegistrationPage() {

        registrationPage.searchRegister();
    }

    @When("^The user fills all fields excepting 'celular'$")
    public void theUserFillsAllExceptingCelular()  {
        registrationPage.insertData();
    }

    @And("^Tries to save its data$")
    public void triesToSaveItsData() {
        registrationPage.saveButtonClick();
    }

    @Then("^Web page displays error message to the user$")
    public void webPageDisplaysErrorMessageToTheUser() {
        cellphoneEmptyMessage = registrationPage.registrationCellphoneNotFound();
        Assert.assertTrue("Error: Cellphone field is empty", cellphoneEmptyMessage);
    }


}
