package stepdefinitions;

import Pages.HomePageUsingPageFactory;
import Pages.MoviesDetailsUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MoviesDetailsSteps {
    WebDriver driver = Hooks.getDriver();
    HomePageUsingPageFactory homePage=new HomePageUsingPageFactory(driver);
    PopularPageUsingPageFactory popularPage=new PopularPageUsingPageFactory(driver);
    MoviesDetailsUsingPageFactory movieDetails=new MoviesDetailsUsingPageFactory(driver);
    @When("I click on any one movie on home page")
    public void clickOnMovieOnHomePage(){
        homePage.clickOnTrendingNowMovies(2);
    }
    @Then("I test all the UI elements present in it")
    public void testFunctionalities(){
        Assert.assertTrue(movieDetails.getTitleOfMovie(),"Movie Title not found");
        Assert.assertTrue(movieDetails.getOverViewOfMovie(),"Overview not found");
        Assert.assertTrue(movieDetails.movieReviewContainer(),"Movie Review Container failed");
        Assert.assertTrue(movieDetails.checkPlayBtn(),"play button not displayed");
        Assert.assertTrue(movieDetails.genreOfMovie(),"Genre not displayed");
        Assert.assertTrue(movieDetails.audioOptionsInMovie(),"Audio options not displayed");
        Assert.assertTrue(movieDetails.getRatingHeading(0) && movieDetails.getRatingText(0),"Rating heading and text not found");
        Assert.assertTrue(movieDetails.getRatingHeading(1) && movieDetails.getRatingText(1),"Rating Heading and text 2 not found");
        Assert.assertTrue(movieDetails.getBudgetHeading(0) && movieDetails.getBudgetText(0),"Budget heading and text not found");
        Assert.assertTrue(movieDetails.getBudgetHeading(1) && movieDetails.getBudgetText(1),"Budget heading and text 2 not found");
        Assert.assertEquals(movieDetails.getSimilarMoviesHeading(),"More like this","More like this heading failed");
        System.out.println(movieDetails.getCountOfSimilarMovies());
    }
    @And("I click on any one movie on popular page")
    public void clickOnMovieOnPopularPage(){
        popularPage.clickOnImage(5);
    }
    @And("I test the footer section")
    public void testTheFooterSection(){
        Assert.assertTrue(movieDetails.checkFooterSection(),"footer section icons failed to check");
        Assert.assertEquals(movieDetails.getContactUsHeading(),"Contact Us","contact us heading text failed");
    }
}
