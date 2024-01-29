class PaymentsFactory {
    // Payment interface
    public interface Payment {
        void processPayment();
    }

    // Concrete payment classes
    public static class CreditCardPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing credit card payment...");
        }
    }

    public static class PayPalPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing PayPal payment...");
        }
    }

    enum PaymentMethod {
        PAYPAL,
        CREDIT_CARD
    }

    // Payment factory interface
    public static class PaymentFactory {
        Payment createPayment(PaymentMethod paymentMethod) {
            return switch (paymentMethod) {
                case PAYPAL -> new PayPalPayment();
                case CREDIT_CARD -> new CreditCardPayment();
            };
        }

    }


    // Client class
    public static class PaymentClient {
        private final PaymentFactory factory;

        public PaymentClient(PaymentFactory factory) {
            this.factory = factory;
        }

        public void makePayment(PaymentMethod paymentMethod) {
            Payment payment = factory.createPayment(paymentMethod);
            payment.processPayment();
        }
    }

    // Example usage
    public class Main {
        public void main(String[] args) {
            // Create payment factories
            PaymentClient paymentClient = new PaymentClient(new PaymentFactory());

            // Make payments using clients
            paymentClient.makePayment(PaymentMethod.CREDIT_CARD);
            paymentClient.makePayment(PaymentMethod.PAYPAL);
        }
    }

}