package empresa.Payment;

public abstract class PaymentProcessor {
    public IPaymentGateway paymentGateway;

    public PaymentProcessor(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract boolean processPayment(double amount);
    public abstract boolean refundPayment(double amount);

    public IPaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}

