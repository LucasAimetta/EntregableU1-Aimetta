package empresa.Payment;

import empresa.Utils.Result;

public class PixPaymentProcessor extends PaymentProcessor{

    public PixPaymentProcessor(IPaymentGateway paymentGateway){
        super(paymentGateway);
    }

    @Override
    public Result processPayment(double amount) {
        Result result = new Result();
        if(this.paymentGateway.authorize(amount)){
            result.setMessage("Se ha autorizado el Pago"); //LLAMA AL GATEWAY DE PIX, Y DE AHI PRIMERO EJECUTAMOS EL METODO DE AUTORIZAR Y SI LO HACE REALIZAMOS EL PAGO
            this.paymentGateway.capture();
            result.setSuccess(true);
            return result;
        }
        result.setMessage("Ha ocurrido un error. No se autorizó el pago"); //MISMA LOGICA QUE EN EL PROCESAMIENTO DE UN PAGO
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