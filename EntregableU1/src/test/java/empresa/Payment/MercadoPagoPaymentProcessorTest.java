
package empresa.Payment;

import empresa.Utils.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MercadoPagoPaymentProcessorTest {
    private MercadoPagoPaymentProcessor logica;


    @BeforeEach
    void setUp(){
        IPaymentGateway mercadoPagoPaymentGateway = new MercadoPagoPaymentGateway();
        logica = new MercadoPagoPaymentProcessor(mercadoPagoPaymentGateway);
    }

    @Test
    void testProcessPaymentCorrectly(){
        //ARRANGE
        double amount = 250000;
        //ACT
        Result result = logica.processPayment(amount);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha autorizado el Pago",result.getMessage());
    }

    @Test
    void testProcessPaymentIncorrectlyHigherThanMillion(){
        //ARRANGE
        double amount = 5000000;
        //ACT
        Result result = logica.processPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se autorizó el pago",result.getMessage());
    }
    @Test
    void testProcessPaymentIncorrectlyLowerThanHundred(){
        //ARRANGE
        double amount = 50;
        //ACT
        Result result = logica.processPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se autorizó el pago",result.getMessage());
    }
    @Test
    void testRefundPaymentCorrectly(){
        //ARRANGE
        double amount = 250000;
        //ACT
        Result result = logica.refundPayment(amount);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha devuelto el Pago",result.getMessage());
    }

    @Test
    void testRefundPaymentIncorrectlyHigherThanMillion(){
        //ARRANGE
        double amount = 5000000;
        //ACT
        Result result = logica.refundPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se devolvió el pago",result.getMessage());
    }
    @Test
    void testRefundPaymentIncorrectlyLowerThanHundred(){
        //ARRANGE
        double amount = 50;
        //ACT
        Result result = logica.refundPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se devolvió el pago",result.getMessage());
    }
}
