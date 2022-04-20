package com.libraryApp.steps_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US_01_StepsDefs {

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
