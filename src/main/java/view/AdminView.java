package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {

    public int showMenu(ArrayList<String> menu , String message)
    {
        Scanner input = new Scanner(System.in);
        int option =-1;
        try{

            while(true)
            {
                System.out.println(message);
                for(int i=0;i<menu.size();i++)
                {
                    System.out.println((i+1)+" "+menu.get(i));
                }
                option = input.nextInt();
                if(option<1 || option>menu.size())
                    continue;
                else break;
            }

        }catch (InputMismatchException e)
        {
            System.out.println("Invalid input, try again .....");
            showMenu(menu,message);
        }

       return option;
    }

    public String askForStringInput(String message){
        String ret = "";
        try{
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            ret = input.nextLine();

        }catch (InputMismatchException e)
        {
            System.out.println("Invalid input, try again .....");
            askForStringInput(message);
        }

        return ret;


    }
    public double askForDoubleInput(String message){
        double ret = 0;
        try{
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            ret = input.nextDouble();

        }catch (InputMismatchException e)
        {
            System.out.println("Invalid input, try again .....");
            askForDoubleInput(message);
        }

        return ret;


    }
    public int askForIntInput(String message){
        int ret = 0;
        try{
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            ret = input.nextInt();

        }catch (InputMismatchException e)
        {
            System.out.println("Invalid input, try again .....");
            askForIntInput(message);
        }

        return ret;


    }

    public void showMessage(String message)
    {
        System.out.println(message);
    }

    public char confirmationMessage(String message){
        char ret = 0;
        Scanner input = new Scanner(System.in);
        try{
            while(true)
            {
                System.out.println(message);
                ret = input.next().charAt(0);
                if(ret=='Y' || ret=='N')
                    break;
                else
                {
                    System.out.println("Invalid input, try again .....");
                    continue;
                }
            }

        }catch(InputMismatchException e)
        {
            System.out.println("Invalid input, try again .....");
        }

        return ret;
    }

    public void showList(ArrayList<String> listOfItems)
    {
        for (int i = 0; i < listOfItems.size(); i++)
            System.out.println((i+1)+" "+listOfItems.get(i));
    }




}
