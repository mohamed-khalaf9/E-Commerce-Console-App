package view;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    Scanner inuput=new Scanner(System.in);

    public int showMenu(ArrayList<String> lst , String headLine) {
        int option = -1;
        try {
            while (true) {

                System.out.println(headLine + ":");
                for (int i = 0; i < lst.size(); i++) {
                    System.out.println((i + 1) + ". " + lst.get(i));
                }
                option = inuput.nextInt();
                if (option > lst.size() || option < 1)
                    throw new IllegalArgumentException("Enter a proper number");
                else
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            showMenu(lst, headLine);

        }
        return option;
    }
  


    public int askForInput(String str){
        System.out.println(str);

       int option= inuput.nextInt();
        return option;
    }
    public int[] getCartItemInfo(){
        int[]arr=new int[2];
        System.out.println("Enter product number : ");
        int number=inuput.nextInt();
        arr[0]=number;
        System.out.println("Enter the quantity");
        int quantity=inuput.nextInt();

        arr[1]=quantity;
        return arr;
    }
    public void printCartItems(ArrayList<String> lst ,String headLine){
        for(int i=0;i<lst.size();i++){
            System.out.println((i+1)+". "+lst.get(i));
        }

    }
    public void informMessage(String message){
        System.out.println(message);
    }
    public char confirmationMessage(){
        Scanner input =new Scanner(System.in);
        System.out.print("Confirm your order (Y/N) : ");
        char ch=input.next().charAt(0);
        return ch;
    }
    public boolean showCategoryProducts(ArrayList<String> lst,String headLine){
        if(lst.size()==0) {
           return false;
        }
        else {
            System.out.println(headLine);
            for (int i = 0; i < lst.size(); i++) {
                System.out.println((i + 1) + ". " + lst.get(i));
            }
            return true;
        }
    }
    public void printTotalPrice(double price){
         String str="Total price:  $"+price;
         System.out.println(str);

    }


    }

