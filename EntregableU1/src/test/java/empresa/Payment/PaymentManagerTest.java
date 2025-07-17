package empresa.Payment;

import empresa.Utils.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentManagerTest {
    private PaymentManager logica;

    @BeforeEach
    void setUp(){
        logica = new PaymentManager();
    }

    @Test
void processPaymentCorreclyWithMercadoPago(){
        //ARRANGE
        double amount = 50000;
        String processor = "mercadopago";
        //ACT
        Result result = logica.processPayment(amount,processor);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha autorizado el Pago", result.getMessage());
    }
    @Test
    void processPaymentCorreclyWithPayPal(){
        //ARRANGE
        double amount = 50000;
        String processor = "paypal";
        //ACT
        Result result = logica.processPayment(amount,processor);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha autorizado el Pago", result.getMessage());
    }
    @Test
    void processPaymentCorreclyWithPix(){
        //ARRANGE
        double amount = 15000;
        String processor = "pix";
        //ACT
        Result result = logica.processPayment(amount,processor);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha autorizado el Pago", result.getMessage());
    }

    @Test
    void processPaymentIncorrecly(){
        //ARRANGE
        double amount = 50000;
        String processor = "mercadopaaago";
        //ACT
        Result result = logica.processPayment(amount,processor);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Procesador de Pago incorrecto", result.getMessage());
    }

    @Test
    void refundPaymentCorrecly(){
        //ARRANGE
        double amount = 50000;
        String processor = "mercadopago";
        //ACT
        Result result = logica.processRefund(amount,processor);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha devuelto el Pago", result.getMessage());
    }

    @Test
    void refundPaymentIncorrecly(){
        //ARRANGE
        double amount = 50000;
        String processor = "mercadopaaago";
        //ACT
        Result result = logica.processRefund(amount,processor);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Procesador de Pago incorrecto", result.getMessage());
    }

}
