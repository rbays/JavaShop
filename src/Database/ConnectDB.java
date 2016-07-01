package Database;

import Logic.CustomerSample;
import Logic.PeopleClasses.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 01-Jul-16.
 */
public class ConnectDB {

    static Statement statement;

    static Connection conn;
    static String username = "root";
    static String password = "Password100";
    static String url = "jdbc:mysql://localhost:3306/computershop?UseSSL=false";

    public static void addUsersToDb(String firstname, String lastname) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = conn.prepareStatement("INSERT INTO USERS (firstname, lastname) VALUES (?,?)");
        statement.setString(1, firstname);
        statement.setString(2, lastname);
        statement.executeUpdate();
        statement.close();
        conn.close();
    }

    public static ArrayList<Customer> getCustomersFromDB() throws Exception {
        ArrayList<Customer> output = new ArrayList<Customer>();


        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        statement = conn.createStatement();
        ResultSet rs;


        rs = statement.executeQuery("SELECT * FROM users order by lastname");

        while (rs.next()) {
            output.add(new Customer(rs.getString(2), rs.getString(3)));
        }
        conn.close();
        return output;
    }
}








