/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseCnt;

/**
 *
 * @author danie
 */
import DataBaseCnt.DataBaseConnector;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class SeleniumDataBaseTestingExample {

    //Test to verify User ID '1' has employee name 'Tiddle'
    @Test(priority = 1)
    public void testVerifySpecificRecord() {
        String sqlQuery  = "select U_UserName from Users WHERE UserID=1";
        String expectedU_UserName = "tiddle";
        //Getting employee name by Id
        String actualU_UserNameById = DataBaseConnector.executeSQLQuery("QA", sqlQuery);
        System.out.println("UserName retrieved from database :" + actualU_UserNameById);
        Assert.assertEquals(expectedU_UserName, actualU_UserNameById);
    }

    //Test to verify Employee table has a record with employee name 'Jack'
    @Test(priority = 2)
    public void testVerifyListOfRecords() {
        boolean flag = false;
        List<String> listOfDBValues = new ArrayList<>();
        String expEmployeeName = "tiddle";
        String sqlQuery = "select U_UserName from Users";
        //Getting list of employee names from employee table
        listOfDBValues = DataBaseConnector.executeSQLQuery_List("QA", sqlQuery);
        for (String strName : listOfDBValues) {
            if (strName.equalsIgnoreCase(expEmployeeName)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag, "Retrieved values are not matching with Expected values");
    }

}