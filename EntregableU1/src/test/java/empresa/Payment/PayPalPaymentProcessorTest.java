package empresa.Payment;

import empresa.Utils.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayPalPaymentProcessorTest {
    private PaypalPaymentProcessor logica;

    @BeforeEach
      void setUp(){
        IPaymentGateway paypalPaymentGateway = new PaypalPaymentGateway();
        logica = new PaypalPaymentProcessor(paypalPaymentGateway);
    }

    @Test
    void testProcessPaymentCorrectly(){
        //ARRANGE
        double amount = 15000;
        //ACT
  Result result = logica.processPayment(amount);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha autorizado el Pago",result.getMessage());
    }

    @Test
    void testProcessPaymentIncorrectly(){
        //ARRANGE
        double amount = 5000;
        //ACT
        Result result = logica.processPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se autorizó el pago",result.getMessage());
    }
    @Test
    void testRefundPaymentCorrectly(){
        //ARRANGE
        double amount = 15000;
        //ACT
        Result result = logica.refundPayment(amount);
        //ASSERT
        Assertions.assertEquals(true,result.isSuccess());
        Assertions.assertEquals("Se ha devuelto el Pago",result.getMessage());
    }

    @Test
    void testRefundPaymentIncorrectly(){
        //ARRANGE
        double amount = 5000;
        //ACT
        Result result = logica.refundPayment(amount);
        //ASSERT
        Assertions.assertEquals(false,result.isSuccess());
        Assertions.assertEquals("Ha ocurrido un error. No se devolvió el pago",result.getMessage());
    }




}
