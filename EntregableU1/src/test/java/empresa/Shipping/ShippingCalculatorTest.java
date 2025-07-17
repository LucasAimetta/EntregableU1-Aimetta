package empresa.Shipping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShippingCalculatorTest {
    ShippingCalculator logica;
    @BeforeEach
    void setUp(){
        logica = new ShippingCalculator();
    }

    @Test
    void calculateCostTest(){
        //ARRANGE
        IShippingStrategy mock = mock(IShippingStrategy.class);
        double weight  = 500;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);
        when(mock.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny)).thenReturn(49000.0);
        logica.setShippingStrategy(new BoatShippingStrategy());
        logica.setDestiny(coordinatesDestiny);
        logica.setOrigin(coordinatesOrigin);
        logica.setDimentions(dimensiones);
        logica.setWeight(weight);
        //ACT
double result = logica.calculateCost();
        //ASSERT
        Assertions.assertEquals(49000.0,result);
    }
}
