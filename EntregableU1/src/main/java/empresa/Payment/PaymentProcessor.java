package empresa.Payment;

import empresa.Utils.Result;

public abstract class PaymentProcessor {
    public IPaymentGateway paymentGateway;

    public PaymentProcessor(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract Result processPayment(double amount);
    public abstract Result refundPayment(double amount);

    public IPaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}

