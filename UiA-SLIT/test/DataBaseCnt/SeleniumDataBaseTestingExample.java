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
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class SeleniumDataBaseTestingExample {

    //Test to verify Employee ID '1' has employee name 'Jack'
    @Test(priority = 1)
    public void testVerifySpecificRecord() {
        String sqlQuery  = "select EmpName from employee WHERE EmpId="1"";
        String expectedEmpName = "Jack";
        //Getting employee name by Id
        String actualEmpNameById = DataBaseConnector.executeSQLQuery("QA", sqlQuery);
        System.out.println("Employee name retrieved from database :" + actualEmpNameById);
        Assert.assertEquals(expectedEmpName, actualEmpNameById);
    }

    //Test to verify Employee table has a record with employee name 'Jack'
    @Test(priority = 2)
    public void tesVerifyListOfRecords() {
        boolean flag = false;
        List<String> listOfDBValues = new ArrayList<>();
        String expEmployeeName = "Jack";
        String sqlQuery = "select EmpName from employee";
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