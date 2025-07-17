package empresa.Payment;

import empresa.Utils.Result;

public class PaypalPaymentProcessor extends PaymentProcessor {


    public PaypalPaymentProcessor(IPaymentGateway paymentGateway){
        super(paymentGateway);
    }

    @Override
    public Result processPayment(double amount) {
        Result result = new Result();
        if(this.paymentGateway.authorize(amount)){
            result.setMessage("Se ha autorizado el Pago");
            this.paymentGateway.capture();
            result.setSuccess(true);  //LLAMA AL GATEWAY DE PAYPAL, Y DE AHI PRIMERO EJECUTAMOS EL METODO DE AUTORIZAR Y SI LO HACE REALIZAMOS EL PAGO
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
            result.setMessage("Se ha devuelto el Pago"); //MISMA LOGICA QUE EN EL PROCESAMIENTO DE UN PAGO
            this.paymentGateway.capture();
            result.setSuccess(true);
            return result;
        }
        result.setMessage("Ha ocurrido un error. No se devolvió el pago");
        result.setSuccess(false);
        return result;
    }

}