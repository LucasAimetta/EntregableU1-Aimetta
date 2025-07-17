package empresa.Shipping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TruckShippingStrategyTest {

    private TruckShippingStrategy logica;
    @BeforeEach
    void setUp(){
        logica = new TruckShippingStrategy();
    }

    @Test
    void calculateCostOver300Pounds(){
        //ARRANGE
        double weight  = 500;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(24600.0, result);
    }

    @Test
    void calculateCostUnder300Pounds(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(20400.0, result);
    }

    @Test
    void calculateCostOver5000cm3(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 7500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(24800.0, result);
    }

    @Test
    void calculateCostUnder5000cm3(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(20400.0, result);
    }

    @Test
    void calculateCostUnder1000km(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-32.9442);
        coordinatesDestiny.setLongitud(-60.6505);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(20400.0, result);
    }

    @Test
    void calculateCostBetween1000And2000km(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-41.1335);
        coordinatesDestiny.setLongitud(-71.3103);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(23400.0, result);
    }

    @Test
    void calculateCostOver2000km(){
        //ARRANGE
        double weight  = 200;
        double dimensiones = 2500;
        Coordinates coordinatesOrigin = new Coordinates();
        coordinatesOrigin.setLongitud(-61.4867);
        coordinatesOrigin.setLatitud(-31.2503);
        Coordinates coordinatesDestiny = new Coordinates();
        coordinatesDestiny.setLatitud(-54.8019);
        coordinatesDestiny.setLongitud(-68.3030);

        //ACT
        double result  = logica.calculateCost(weight,dimensiones,coordinatesOrigin,coordinatesDestiny);
        //ASSERT
        Assertions.assertEquals(27400.0, result);
    }

}
