package view;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    Scanner inuput=new Scanner(System.in);
    public void showMenu(ArrayList<String> lst , String headLine){
        System.out.println(headLine +":");
        for(int i=0 ; i<lst.size() ; i++ ){
            System.out.println((i+1)+ ". " + lst.get(i));
        }
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
    public void informMessage(String message){
        System.out.println(message);
    }


    }

