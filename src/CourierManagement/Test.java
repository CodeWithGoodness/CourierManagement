package CourierManagement;

import java.util.Scanner;

public class Test {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        ProductMethods productMethods = new ProductMethods();
        Product product = new Product();
       // ProductMethods.productDatabase();

        System.out.print("Name: ");
        String name = input.next();
        System.out.print("price ");
        int Price = input.nextInt();
        System.out.print("delivery price ");
        int delPrice = input.nextInt();
        System.out.print(" quantity");
        int Qty = input.nextInt();
        System.out.print(" discount");
        int discount = input.nextInt();
        System.out.print(" category");
        String category = input.next();

        ProductMethods.addProduct(name, Price, delPrice, Qty, discount, category);
    }
}
