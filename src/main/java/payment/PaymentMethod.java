package payment;

public interface PaymentMethod {
    public abstract boolean readData();
    public abstract void processPayment(double amount);
}
