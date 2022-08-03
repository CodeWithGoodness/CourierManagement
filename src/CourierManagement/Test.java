package CourierManagement;

import java.util.Scanner;

public class Test {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        ProductMethods productMethods = new ProductMethods();
        Product product = new Product();
        CustomerMethods customerMethods = new CustomerMethods();
        System.out.println(CustomerMethods.generateRandom());
    }
}
