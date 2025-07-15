package empresa.Payment;

public class MercadoPagoPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return true;
    }

    @Override
    public boolean authorize(double amount) {
        if(amount<100 || amount>1000000){
            return false;
        }
        return true;

    }
}
