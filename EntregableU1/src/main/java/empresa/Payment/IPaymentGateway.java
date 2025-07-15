package empresa.Payment;

public interface IPaymentGateway {
     boolean capture();
     boolean authorize(double amount);

}
