package factory;

import payment.CreditCard;
import payment.DebitCard;
import payment.PaymentMethod;

public class PaymentMethodFactory {
    public static PaymentMethod createPaymentMethod(String method){
        if(method=="Debit card")
            return new DebitCard();
        else
            return new CreditCard();
    }
}
