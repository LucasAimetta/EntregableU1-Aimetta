package empresa.Payment;

public class PixPaymentGateway implements IPaymentGateway {
    @Override
    public boolean capture() {
        return true;
    } //UNA VEZ HA SIDO AUTORIZADO SE REALIZA EL CAPTURE, POR ESO NO PUEDE TENER ERRORES Y DEVUELVE SIEMPRE TRUE

    @Override
    public boolean authorize(double amount) {   //SIMULA UNA LOGICA DONDE PIX UNICAMENTE AUTORIZA TRANSFERENCIAS MENORES A 20000
        if(amount < 20000){
        return true;
        }
        return false;
    }
}
