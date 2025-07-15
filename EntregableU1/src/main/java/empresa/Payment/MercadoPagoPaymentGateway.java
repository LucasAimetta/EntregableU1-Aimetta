package empresa.Payment;

public class MercadoPagoPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public boolean autorize() {
        return false;
    }
}
