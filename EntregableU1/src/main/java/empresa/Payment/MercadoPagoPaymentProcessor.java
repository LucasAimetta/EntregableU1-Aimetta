package empresa.Payment;

public class MercadoPagoPaymentProcessor extends  PaymentProcessor{

public MercadoPagoPaymentProcessor(IPaymentGateway paymentGateway){
        super(paymentGateway);
}

    @Override
    public boolean processPayment(double amount) {

    if(this.paymentGateway.authorize(amount)){
        System.out.println("Se ha autorizado el Pago");
        this.paymentGateway.capture();
        return true;
    }
    System.out.println("Ha ocurrido un error. No se autorizó el pago");
        return false;
    }

    @Override
    public boolean refundPayment(double amount) {

        if(this.paymentGateway.authorize(amount)){
            System.out.println("Se ha devuelto el Pago");
            this.paymentGateway.capture();
            return true;
        }
        System.out.println("Ha ocurrido un error. No se devolvió el pago");
        return false;
    }

}
