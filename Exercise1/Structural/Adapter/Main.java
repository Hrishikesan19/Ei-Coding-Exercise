public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(150.0);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(200.0);
    }
}
