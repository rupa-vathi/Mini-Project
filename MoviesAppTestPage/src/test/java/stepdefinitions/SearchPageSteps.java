package stepdefinitions;

import Pages.HeaderSectionUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
import Pages.SearchPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class SearchPageSteps {
    WebDriver driver = Hooks.getDriver();
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    SearchPageUsingPageFactory searchPage=new SearchPageUsingPageFactory(driver);
    PopularPageUsingPageFactory popularPage=new PopularPageUsingPageFactory(driver);

    @When("I navigate to search page")
    public void navigate_to_search_page(){
        headerSection.NavigateToSearchPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/search");
        Assert.assertTrue(searchPage.verifySearchInputBox(),"search input box not found");
    }
    @And("I search for \"The GodFather\" Movie")
    public void searchForMovie(){
        searchPage.searchMovies("The GodFather");
    }
    @Then("I should see the count of movies displayed")
    public void countMoviesDisplayed() {
        Assert.assertTrue(searchPage.redirectToPage(),"Search for a movies Failed");
        System.out.println("Search for a movies is successfully completed: " + searchPage.countMovies());
    }
    @Then("I should see not found container")
    public void notFoundContainer(){
        Assert.assertTrue(searchPage.notFoundContainer(), "Search for a non-existent movie is successfully completed");
        }
    @And("I search for non-existent Movie")
    public void searchNonExistent(){
       searchPage.clearSearch();
       searchPage.searchMovies("tgd");
    }
    @Then("I click on movie and redirect to the search movie details page")
    public void click_on_movie_in_search(){
        if(popularPage.checkMoviesDisplay(1)){
            popularPage.clickOnImage(1);
            Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/movies/c04a2fc5-8e74-450f-a26d-88590e5ee0be","redirect to movies details page in search page failed");
        }
    }
}
