package pages;

import helper.HookHelper;
import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.awaitility.Awaitility.await;


public class HomePage extends BasePage
{
    private WebDriver webDriver;
    private WebElement passwordInput;
    private WebElement loginButton;
    private WebElement incorrectCredentials;
    private WebElement logOut;
    private WebElement verifyLogout;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @FindBy(className = "fb-masthead-login")
    private WebElement loginDiv;

    @FindBy(id = "emailAddress")
    private WebElement emailInput;


    private WebElement loggedInDiv;


    public void openLoginFormOverlay()
    {
        loginDiv.click();
    }

    public void invalidDataInsert()
    {
        WebDriverWait wait = new WebDriverWait(webDriver,Long.parseLong("5"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Modal__modalcontent__2yJz6")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("1234@gmail.com");
        passwordInput = webDriver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("1234");
    }

    public void validDataInsert()
    {
        WebDriverWait wait = new WebDriverWait(webDriver,Long.parseLong("5"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Modal__modalcontent__2yJz6")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("testdummy4785692@gmail.com");
        passwordInput = webDriver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("sD4eMa9TKtsFdJGs");
    }

    public void loginButton()
    {
        loginButton = webDriver.findElement(By.xpath("//*[contains(text(), 'Iniciar')]/."));
        loginButton.click();
    }


    public boolean invalidLogin()
    {
        WebDriverWait wait = new WebDriverWait(webDriver,Long.parseLong("10"));
        incorrectCredentials = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Login__message__3fDqw")));
        boolean invalidLoginMessage = incorrectCredentials.isEnabled();
        return invalidLoginMessage;
    }

    public boolean userLoggedIn()
    {
        boolean loggedIn = false;
        WebDriverWait wait = new WebDriverWait(webDriver, Long.parseLong("5"));
        loggedInDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-login-modal']/div/div/div")));
        String getloginText = loggedInDiv.getText();
        if (getloginText.contains("Bienvenid@,"))
        {
            loggedIn = true;
        }
        return loggedIn;
    }

    public void hoverAccountOptions()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, Long.parseLong("5"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-login-modal']/div/div/div")));
        WebElement hoverAction = webDriver.findElement(By.xpath("//*[@id='header-login-modal']/div/div/div"));
        Actions builder = new Actions(webDriver);
        builder.moveToElement(hoverAction).perform();
    }

    public void clickLogout()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, Long.parseLong("5"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fb-filter-header__list")));
        logOut = webDriver.findElement(By.xpath("//*[@class='fb-filter-header__list']/li/a[@href='#']"));
        logOut.click();
    }

    public boolean verifyLogout()
    {
        boolean loggedOut = false;
        WebDriverWait wait = new WebDriverWait(webDriver, Long.parseLong("5"));
        verifyLogout = wait.until(ExpectedConditions.elementToBeClickable(loginDiv));
        String getVerifyLogoutText = verifyLogout.getText();
        if (getVerifyLogoutText.contains("Inicia"))
        {
            loggedOut = true;
        }
        return loggedOut;

    }







}