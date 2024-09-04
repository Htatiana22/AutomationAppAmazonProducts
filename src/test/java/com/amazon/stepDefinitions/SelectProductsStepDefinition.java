package com.amazon.stepDefinitions;

import com.amazon.questions.ValidateProductName;
import com.amazon.tasks.HomePageTask;
import com.amazon.tasks.SearchProductsTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SelectProductsStepDefinition {

    @Given("User enters the Amazon application")
    public void userEntersTheAmazonApplication() {
    }

    @When("User searches for the products and adds them to the shopping cart")
    public void userSearchesForTheProductsAndAddsThemToTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                HomePageTask.open(),
                SearchProductsTask.search()
        );
    }

    @Then("User validates the name of the selected products")
    public void userValidatesTheNameOfTheSelectedProducts() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateProductName.productName(), Matchers.equalTo(true)
                )
        );
    }
}
