package empresa.Payment;

public class PaypalPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public boolean autorize() {
        return false;
    }
}
