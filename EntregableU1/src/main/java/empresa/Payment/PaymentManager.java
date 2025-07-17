package empresa.Payment;

import empresa.Utils.Result;

public class PaymentManager {
    PaymentProcessor processor;
    Result result;

    public Result processPayment(double amount, String paymentProcessor){
        if( processorConstructor(paymentProcessor)){
 result = processor.processPayment(amount);
         if(result.isSuccess()){
             return result;}
        }
        result = new Result();
result.setSuccess(false);
        result.setMessage("Procesador de Pago incorrecto");
         return result;
    }

    public Result processRefund(double amount, String paymentProcessor){
        if( processorConstructor(paymentProcessor)){
            result = processor.refundPayment(amount);
            if(result.isSuccess()){
                return result;}
        }
        result = new Result();
        result.setSuccess(false);
        result.setMessage("Procesador de Pago incorrecto");
        return result;
    }



    private boolean processorConstructor(String payment){

        switch (payment.toLowerCase()){
            case "pix": processor = new PixPaymentProcessor(new PixPaymentGateway());return true;

            case "mercadopago":  processor = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());return true;

            case "paypal": processor = new PaypalPaymentProcessor(new PaypalPaymentGateway());return true;

            default: return false;
        }}


}


