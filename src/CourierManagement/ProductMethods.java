package CourierManagement;

import java.sql.*;

public class ProductMethods {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    public static void productDatabase(){
        ProductMethods productMethods = new ProductMethods();
        try {
             productMethods.connection = DriverManager.getConnection("jdbc:mysql://DESKTOP-9M33U7D/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            productMethods.statement.executeUpdate("create  table products_table( product varChar(50), product_price int,delivery_price int, Quantity int," +
                    "discount_rate int, inStock Enum('T','F'), category varChar(20))");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }

    public static void addProduct(String productName, int productPrice, int deliveryP, int quantity, int discountPrice, String category){
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        product.setProductName(productName);
        product.setPrice(productPrice);
        product.setDeliveryPrice(deliveryP);
        product.setQuantity(quantity);
        product.setDiscount(discountPrice);
        product.setCategory(category);
      try {
          productMethods.connection = DriverManager.getConnection("jdbc:mysql://DESKTOP-9M33U7D/mydb","root", "Cecilia2002");
          productMethods.statement = productMethods.connection.createStatement();
          productMethods.statement.executeUpdate("insert into products_table (product,product_price,delivery_price, Quantity, discount_rate," +
                  " category) values ('"+product.getProductName()+"', '"+product.getPrice()+"', '"+product.getDeliveryPrice()+"'," +
                  "'"+product.getQuantity()+"', '"+product.getDiscount()+"', '"+product.getCategory()+"')");
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          ProductMethods.close();
      }
    }
    //statement.executeUpdate("insert into voting_database (FirstName,lastName, Gender, State," +
     //       "Age , password, Status) values('"+getFirstName()+"','"+getLastName()+"', '"+getGender()+"', '"+getState()+"','"+getAge()+"'," +
       //     " 'Admin@onlineVoting.com', 'Admin') ");
    public static void close(){
        ProductMethods productMethods = new ProductMethods();
        try {
            if(productMethods.connection != null){
                productMethods.connection.close();
            }
            if(productMethods.statement != null){
                productMethods.statement.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void closeResult(){
        ProductMethods productMethods = new ProductMethods();
        try {
            if(productMethods.resultSet!= null){
                productMethods.resultSet.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
