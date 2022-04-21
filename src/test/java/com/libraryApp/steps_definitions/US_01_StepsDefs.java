package com.libraryApp.steps_definitions;

import com.libraryApp.utils.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class US_01_StepsDefs {

    int totalIdCount;
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DBUtils.runQuery("select count(Id) from users ");
        totalIdCount = Integer.parseInt(DBUtils.getFirstRowFirstColumn());
        System.out.println("totalIdCount = " + totalIdCount);
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        DBUtils.runQuery("SELECT  id FROM users GROUP BY  id HAVING COUNT(id) =1");
        int uniqIdCount = DBUtils.getRowCount();
        Assert.assertEquals(totalIdCount,uniqIdCount);
        System.out.println("uniqIdCount = " + uniqIdCount);
        DBUtils.runQuery("select id from users");
        List<String> listOfId=DBUtils.getColumnDataAsList(1);
        Assert.assertTrue(!DBUtils.isDuplicate(listOfId));
    }

    List<String> listOfAllColum;
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
    DBUtils.runQuery("select * from users");
    listOfAllColum=DBUtils.getAllColumnNamesAsList();

    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expected) {
        Assert.assertEquals(listOfAllColum,expected);
        System.out.println("listOfAllColum = " + listOfAllColum);
        System.out.println("expected = " + expected);
    }

}
