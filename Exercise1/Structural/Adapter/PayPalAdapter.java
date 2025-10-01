public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.payWithPaypal(amount);
    }
}
