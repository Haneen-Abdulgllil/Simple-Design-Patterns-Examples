// Interface defining the payment strategy
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete implementation for Credit Card payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
        // Additional logic specific to credit card payment
    }
}

// Concrete implementation for PayPal payment
class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal.");
        // Additional logic specific to PayPal payment
    }
}

// Context class that allows clients to use different payment strategies
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code demonstrating the usage of different payment strategies
public class PaymentExample {
    public static void main(String[] args) {
        PaymentStrategy creditCardStrategy = new CreditCardPayment("1234 5678 9012 3456", "12/25", "123");
        PaymentStrategy paypalStrategy = new PayPalPayment("example@example.com", "password");

        PaymentContext paymentContext = new PaymentContext(creditCardStrategy);
        paymentContext.processPayment(100.00); // Pay via Credit Card

        paymentContext.setPaymentStrategy(paypalStrategy);
        paymentContext.processPayment(50.00); // Pay via PayPal
    }
}