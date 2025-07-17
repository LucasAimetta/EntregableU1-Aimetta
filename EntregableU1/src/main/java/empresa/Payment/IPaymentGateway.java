package empresa.Payment;
//DEFINIMOS INTERFAZ CON 2 METODOS
public interface IPaymentGateway {
     boolean capture();
     boolean authorize(double amount);

}
