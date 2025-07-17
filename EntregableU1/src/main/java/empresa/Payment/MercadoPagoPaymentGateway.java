package empresa.Payment;

public class MercadoPagoPaymentGateway implements IPaymentGateway{
    @Override
    public boolean capture() {
        return true;
    }       //UNA VEZ HA SIDO AUTORIZADO SE REALIZA EL CAPTURE, POR ESO NO PUEDE TENER ERRORES Y DEVUELVE SIEMPRE TRUE

    @Override
    public boolean authorize(double amount) {
        if(amount<100 || amount>1000000){       //EL AMOUNT PASADO COMO PARAMETRO SERA EL MISMO QUE EL USUARIO INGRESE AL PAYMENTMANAGER
                                                //SIMULA UNA LOGICA DONDE MERCADO PAGO UNICAMENTE AUTORIZA CUANDO EL MONTO ES ENTRE 100 Y 1000000
            return false;
        }
        return true;

    }
}
