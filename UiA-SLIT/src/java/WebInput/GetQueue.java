package WebInput;


 import javax.naming.InitialContext;

 import java.sql.*;
import java.sql.Statement;
 import java.sql.DriverManager;
 import javax.naming.Context;
 import java.sql.ResultSet;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;
import java.sql.Connection;
 import javax.sql.DataSource;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author root
 */
@Stateless
public class GetQueue {
    public String count;

    public GetQueue() throws NamingException, SQLException {
          InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }
            String query = "SELECT COUNT(D_ID) FROM Deliverable WHERE D_DeliverableStatus=0;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                
            int ID = rs.getInt(1);
            
//            System.out.println(cnt + "is this");
//            System.out.println(ID + "Should be");
//            System.out.println(Integer.toString(ID));
                count = Integer.toString(ID); 
            }
//                System.out.println("FEIL?!");
//        count = "Feil i søk";
    
    }
    public String getCount() {
        return count;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
