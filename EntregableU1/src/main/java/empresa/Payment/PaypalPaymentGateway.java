package empresa.Payment;

public class PaypalPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return true;
    } //UNA VEZ HA SIDO AUTORIZADO SE REALIZA EL CAPTURE, POR ESO NO PUEDE TENER ERRORES Y DEVUELVE SIEMPRE TRUE

    @Override
    public boolean authorize(double amount) {           //SIMULA UNA LOGICA DONDE PAYPAL UNICAMENTE AUTORIZA TRANSFERENCIAS MAYORES A 10000
        if(amount>10000){return  true;}
        return false;
    }
}
