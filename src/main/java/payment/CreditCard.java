package payment;

import java.util.Scanner;

public class CreditCard  implements PaymentMethod{
    private String cardNumber;
    private String expiryDate;
    private int cvv;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCvv() {
        return cvv;
    }
    public boolean readData(){
        try {
            Scanner input=new Scanner(System.in);
            System.out.println("Enter Card Number: ");
          String number=  input.next();
          if(number=="")
              throw new IllegalArgumentException("Enter a valid number");
          else
              setCardNumber(number);

          System.out.println("Enter Expiry Date: ");
          String date=input.next();
          if (date=="")
              throw new IllegalArgumentException("Enter a valid date");
          else
              setExpiryDate(date);

          System.out.println("Enter CVV: ");
          int cvv=input.nextInt();
          setCvv(cvv);
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
              return false;
        }

    }
    public void processPayment(double amount){
        System.out.println(amount+"$ has been deducted from your card");
    }
}
