package CourierManagement;

import java.util.Scanner;

public class Test {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        ProductMethods productMethods = new ProductMethods();
        Product product = new Product();
       // productMethods.displayCategories();
        productMethods.displayProducts("stationery");
   //     ProductMethods.locationDatabase();
//        productMethods.addDeliveryLocation("imo", 900);
//        productMethods.addDeliveryLocation("Lagos", 2000);
//        productMethods.addDeliveryLocation("kano", 500);
//        productMethods.addDeliveryLocation("Enugu", 100);
//        productMethods.addDeliveryLocation("Anambra", 1500);
       // ProductMethods.productDatabase();
//        CustomerMethods.customerDatabase();
//

//       System.out.print("Product: ");
//       String name = input.next();
//       System.out.print("Price: ");
//       int Price = input.nextInt();
//       System.out.print("Quantity: ");
//       int Qty = input.nextInt();
//       System.out.print("Discount: ");
//       int discount = input.nextInt();
//       System.out.print("Category: ");
//       String category = input.next();
//        ProductMethods.addProduct(name, Price, Qty, discount, category);
      // productMethods.updateProductName("pencil", "samsung");
//        productMethods.updateProductPrice("samsung", 200000);
//        productMethods.updateCategory("samsung", "Technology");
//        productMethods.updateDiscount("samsung", 20);
    }
}
