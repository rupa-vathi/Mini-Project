package stepdefinitions;

import Pages.AccountPageUsingPageFactory;
import Pages.HeaderSectionUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPageSteps {
    WebDriver driver=Hooks.getDriver();
    AccountPageUsingPageFactory accountPage=new AccountPageUsingPageFactory(driver);
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    @When("I Test navigation to the account page")
    public void navigate_to_the_account_page(){
        headerSection.navigateAccountPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account","Navigate to account page failed");
    }
    @Then("I test all UI elements on the page")
    public void TestAccountPageUI(){
        Assert.assertEquals(accountPage.getHeadOfAccPage(),"Account","Heading not matched");
        System.out.println(accountPage.getHeadOfMemberShip());
        System.out.println(accountPage.getMemberShipDetails());
        System.out.println(accountPage.getPlanDetails());
    }
    @And("I test the logout functionality")
    public void LogoutFunctionality(){
        accountPage.ClickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login","logout function failed");
    }
}
