package empresa.Payment;

public class PaypalPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return true;
    }

    @Override
    public boolean authorize(double amount) {
        if(amount>10000){return  true;}
        return false;
    }
}
