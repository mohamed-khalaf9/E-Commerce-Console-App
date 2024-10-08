package payment;

public interface PaymentMethod {
    public boolean readData();
    public void processPayment(double amount);
}
