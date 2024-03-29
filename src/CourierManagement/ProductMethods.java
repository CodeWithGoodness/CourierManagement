package CourierManagement;

import java.sql.*;

public class ProductMethods {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    public static void productDatabase(){
        ProductMethods productMethods = new ProductMethods();
        try {
             productMethods.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            productMethods.statement.executeUpdate("create  table products_table( Product varChar(50), Price int, Quantity int, Percent_Discount int, Category varChar(20), Password varChar (10)");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public static void locationDatabase(){
        //lists of delivery locations and prices
        ProductMethods productMethods = new ProductMethods();
        try {
            productMethods.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            productMethods.statement = productMethods.connection.createStatement();
            productMethods.statement.executeUpdate("create  table location( State varChar(50), Price int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public static void addProduct(String productName, int productPrice, int quantity, int discountPrice, String category){
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        product.setProductName(productName);
        product.setPrice(productPrice);
        product.setQuantity(quantity);
        product.setDiscount(discountPrice);
        product.setCategory(category);
      try {
          productMethods.connection = DriverManager.getConnection("jdbc:mysql:///mydb","root", "Cecilia2002");
          productMethods.statement = productMethods.connection.createStatement();
          productMethods.statement.executeUpdate("insert into products_table (Product,Price, Quantity, Percent_Discount," +
                  " Category) values ('"+product.getProductName()+"', '"+product.getPrice()+"','"+product.getQuantity()+"'," +
                  " '"+product.getDiscount()+"', '"+product.getCategory()+"')");
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          ProductMethods.close();
      }
    }
    public void RemoveProduct(String productName){
        //remove a product from database
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("delete from products_table where product = '"+productName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void updateProductName(String newProductName, String oldProductName){
        //change a product's name
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("update products_table set product = '"+newProductName+"' where product ='"+oldProductName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void updateProductPrice(String productName, int newPrice){
        //change a product's price
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = productMethods.connection.createStatement();
            statement.executeUpdate("update products_table set Price  = '"+newPrice+"' where product = '"+productName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }

    public void updateDeliveryPrice(String location, int newDeliveryPrice){
        //change a delivery price
        Product product = new Product();
        ProductMethods productMethods = new ProductMethods();
        Customer customer = new Customer();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = productMethods.connection.createStatement();
            statement.executeUpdate("update location set delivery_price = '"+newDeliveryPrice+"' where state = '"+location+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void addDeliveryLocation(String location, int price){
        Product product = new Product();
        Customer customer = new Customer();
        customer.setLocation(location);
        product.setDeliveryPrice(price );
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("insert into location (state, price) values ('"+customer.getLocation()+"', '"+product.getDeliveryPrice()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void removeDeliveryLocation( String location){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("delete from location where state = '"+location+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void updateQuantity( String productName, int NewQty){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("update products_table set Quantity = '"+NewQty+"' where product = '"+productName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void updateDiscount(String productName, int newDiscount){
        try {
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
           statement = connection.createStatement();
           statement.executeUpdate("update products_table set Percent_discount = '"+newDiscount+"' where product = '"+productName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void updateCategory(String productName, String newCategory){
        Product product = new Product();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            statement.executeUpdate("update products_table set category = '"+newCategory+"' where product = '"+productName+"'  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void displayCategories(){
        Product product = new Product();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from products_table");
            while (resultSet.next()){
                System.out.println(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }
    public void displayProducts(String input){
        Product product = new Product();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "Cecilia2002");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from products_table where category = '"+input+"'");
            while (resultSet.next()){
                System.out.println("product: " + resultSet.getString(1));
                System.out.println("price: " + resultSet.getString(2));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ProductMethods.close();
        }
    }

    public static void close(){
        //close connections and database
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
        //close result set
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
