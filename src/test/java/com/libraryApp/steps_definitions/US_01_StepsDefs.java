package com.libraryApp.steps_definitions;

import com.libraryApp.utils.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_01_StepsDefs {

    int totalIdCount =0;

    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {
        DBUtils.runQuery("select count(Id) from users ");
        totalIdCount = Integer.parseInt(DBUtils.getFirstRowFirstColumn());
        System.out.println("totalIdCount = " + totalIdCount);
    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {
        DBUtils.runQuery("SELECT  id FROM users GROUP BY  id HAVING COUNT(id) =1");
        int uniqIdCount = DBUtils.getRowCount();
        Assert.assertEquals(totalIdCount,uniqIdCount);
        System.out.println("uniqIdCount = " + uniqIdCount);
    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DBUtils.runQuery("");
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
