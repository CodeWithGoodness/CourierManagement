package CourierManagement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMethods {
    public static void writePassword (){
        ProductMethods productMethods = new ProductMethods();
        try {
            productMethods.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            productMethods.statement.executeUpdate("insert into customers_table(Password) values ('admins@.courierServices.com')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public static void editPassword (String  newPassword,String oldPassword, String confirmNewPassword){
        ProductMethods productMethods = new ProductMethods();
        Admin admin = new Admin();
        try {
            productMethods.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            ResultSet resultSet = productMethods.statement.executeQuery("select * from customers_table");
            while (resultSet.next()){
                if (oldPassword.equals(resultSet.getString("password"))){
                    if (confirmNewPassword.equals(newPassword)){
                        productMethods.statement.executeUpdate("update customers_table set Password = '"+newPassword+"'");
                    }
                else
                    System.out.println("Password mismatch!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public static void logIn (String password){
        ProductMethods productMethods = new ProductMethods();
        Admin admin = new Admin();
        try {
            productMethods.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            ResultSet resultSet = productMethods.statement.executeQuery("select * from customers_table");
            while (resultSet.next()){
                if (password.equals(resultSet.getString("password"))){
                    System.out.println("1. Add a product \n2. Remove a product \n3. update product details");
                }
                else{
                    System.out.println(" Wrong password!");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
}
