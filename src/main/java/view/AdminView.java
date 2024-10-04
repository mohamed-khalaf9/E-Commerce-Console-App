package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {

    public int showMenu(ArrayList<String> menu , String message)
    {
        Scanner input = new Scanner(System.in);
        int option =0;
        try{

            while(true)
            {
                System.out.println(message);
                for(int i=0;i<menu.size();i++)
                {
                    System.out.println((i+1)+menu.get(i));
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

}
