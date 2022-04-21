package com.libraryApp.steps_definitions;

import com.libraryApp.testbase.PagesInitializer;
import com.libraryApp.utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class US_02_StepsDefs extends PagesInitializer {

    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        loginPage.login();
    }
    String actualResult;
    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
    actualResult=dashBoardPage.borrowedBooksNumber.getText();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DBUtils.runQuery("select count(*) from book_borrow where returned_date is null");
        Assert.assertEquals(actualResult,DBUtils.getFirstRowFirstColumn());
    }
}
