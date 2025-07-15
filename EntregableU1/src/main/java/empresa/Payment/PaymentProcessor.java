package empresa.Payment;

public abstract class PaymentProcessor {
    private IPaymentGateway paymentGateway;
    private boolean processPayment(){
        return  false;
    }
    private boolean refundPayment(){
        return  false;}
}

