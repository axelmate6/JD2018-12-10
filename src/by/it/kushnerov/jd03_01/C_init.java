package by.it.kushnerov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }   catch (ClassNotFoundException e){
            System.out.println("Error loading driver: "+e);
        }
    }

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/","root","");
        Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP SCHEMA IF EXISTS 'kushnerov' ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
