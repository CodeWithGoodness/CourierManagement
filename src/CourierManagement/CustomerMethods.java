package CourierManagement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerMethods {
    public static void customerDatabase(){
        ProductMethods productMethods = new ProductMethods();
        try {
            productMethods.connection = DriverManager.getConnection("jdbc:mysql://DESKTOP-9M33U7D/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            productMethods.statement.executeUpdate("create  table customers_table(Name varChar(50), ProductBought varChar(50)," +
                    "Quantity int,location varChar(20)), Date date");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
}
