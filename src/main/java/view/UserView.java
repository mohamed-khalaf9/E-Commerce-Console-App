package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {

    public int startMenu(){
        int option = 0;
        try{
            while(true){
                System.out.println("Welcome to the E-Commerce Console Application");
                System.out.println("Please select an option:");
                System.out.println("1. Sign UP");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();

                if(option<1 || option>3){
                    System.out.println("Invalid option");
                    continue;
                }
                else {
                    break;
                }
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid option, try again....");
            startMenu();

        }
        return option;

    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public String[] getSignUpInfo(){
        Scanner scanner = new Scanner(System.in);
        String[] info = new String[2];

        try {
            System.out.println("Enter Name: ");
            info[0] = scanner.nextLine();
            System.out.println("Enter Email: ");
            info[1] = scanner.nextLine();
            System.out.println("Enter Password: ");
            info[2] = scanner.nextLine();

        }catch (InputMismatchException e){
            System.out.println("Invalid input, try again....");
            scanner.nextLine();
            return getSignUpInfo();
        }
        return  info;
    }

}
