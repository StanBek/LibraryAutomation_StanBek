package com.libraryApp.steps_definitions;

import com.libraryApp.utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class US_03_StepsDefs {

    String actualResult;
    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DBUtils.runQuery("SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
                "FROM book_borrow INNER JOIN books ON book_borrow.book_id = books.id\n" +
                "INNER JOIN book_categories ON\n" +
                "books.book_category_id = book_categories.id GROUP BY book_categories.name\n" +
                "ORDER BY countofbookcategories DESC;");
        actualResult = DBUtils.getFirstRowFirstColumn();
    }

    @Then("verify that {string} is the most popular book genre.")
    public void verifyThatIsTheMostPopularBookGenre(String book) {
        Assert.assertEquals(actualResult,book);
        System.out.println("actualresult = " + actualResult);
        System.out.println("book = " + book);
    }
}
