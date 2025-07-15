package empresa.Payment;

public class PixPaymentGateway implements IPaymentGateway {
    @Override
    public boolean capture() {
        return true;
    }

    @Override
    public boolean authorize(double amount) {
        if(amount < 20000){
        return true;
        }
        return false;
    }
}
