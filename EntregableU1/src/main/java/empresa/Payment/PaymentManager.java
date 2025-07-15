package empresa.Payment;

public class PaymentManager {
    PaymentProcessor processor;
    public boolean processPayment(double amount, String paymentProcessor){
        if( processorConstructor(paymentProcessor)){

         if(processor.processPayment(amount)){
             return true;}
        }

         return false;
    }

    public boolean processPaymentRefund(double amount, String paymentProcessor){
        if( processorConstructor(paymentProcessor)){

            if(processor.refundPayment(amount)){
                return true;}
        }

        return false;
    }



    private boolean processorConstructor(String payment){

        switch (payment.toLowerCase()){
            case "pix": processor = new PixPaymentProcessor(new PixPaymentGateway());return true;

            case "mercadopago":  processor = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());return true;

            case "paypal": processor = new PaypalPaymentProcessor(new PaypalPaymentGateway());return true;

            default: System.out.println("Procesador de Pago incorrecto"); return false;
        }}


}


