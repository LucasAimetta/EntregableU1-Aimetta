package empresa.Payment;

import empresa.Utils.Result;

public class MercadoPagoPaymentProcessor extends  PaymentProcessor{

public MercadoPagoPaymentProcessor(IPaymentGateway paymentGateway){
        super(paymentGateway);
}

    @Override
    public Result processPayment(double amount) {
Result result = new Result();
    if(this.paymentGateway.authorize(amount)){
        result.setMessage("Se ha autorizado el Pago");
        this.paymentGateway.capture();
        result.setSuccess(true);
        return result;
    }
result.setMessage("Ha ocurrido un error. No se autorizó el pago");
    result.setSuccess(false);
  return result;
    }

    @Override
    public Result refundPayment(double amount) {
        Result result = new Result();
        if(this.paymentGateway.authorize(amount)){
            result.setMessage("Se ha devuelto el Pago");
            this.paymentGateway.capture();
            result.setSuccess(true);
            return result;
        }
result.setMessage("Ha ocurrido un error. No se devolvió el pago");
        result.setSuccess(false);
        return result;
    }

}
