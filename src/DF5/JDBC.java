package DF5;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class JDBC {
    public static void main(String[] args) {
        Connection connection;
        var input = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties prop = new Properties();
            prop.put("user","root");
            prop.put("password","");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", prop);
            ResultSet resultSet;
            Statement statement;

            statement = connection.createStatement();
            //insert some values
            System.out.println("Enter student id");
            int newId = input.nextInt();
            System.out.println("Enter student name");
            input.next();//consume trailing space
            String newName = input.nextLine();

            statement.execute(String.format("INSERT INTO `students` (`roll_no`,`name`) VALUES(%d,'%s');",newId,newName));


            resultSet = statement.executeQuery("SELECT * FROM `students`");
            int rollNo;
            String name;

            while (resultSet.next()) {
                rollNo = resultSet.getInt("roll_no");
                name = resultSet.getString("name");
                System.out.printf("%2d. %s \n", rollNo, name);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
