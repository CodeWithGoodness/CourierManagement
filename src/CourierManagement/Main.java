package CourierManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        System.out.println("Online courier services \nSelect your status: \n1. Admin \n2. Customer");
        Scanner input = new Scanner(System.in);
        String user = input.next();
        switch (user){
            case "1":
                System.out.println("1. Add product \n2. update \n3. Edit password");
                System.out.println("Enter name and password to log in");
                break;
            case "2":
                System.out.println("1. Buy a product \n2. Check price of products");
                break;
            default:
                System.out.println("select 1 or 2");
        }


    }
}
