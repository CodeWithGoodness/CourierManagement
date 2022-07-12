package CourierManagement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class CustomerMethods {
    Customer customer = new Customer();
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

    public void confirmPurchase(String paymentCode){
            if(paymentCode.equals(generateRandom())){
                System.out.println("Payment successful!");
                customer.setPaid(true);

            }else {
                System.out.println("Payment unsuccessful!");
                customer.setPaid(false);
            }
    }
    public static String generateRandom(){
        //This program uses a code to confirm payment(An assumption).
        // A radom string is generated, if the buyer enters the string correctly, payment is confirmed.
        UUID randomUUID  = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
}
