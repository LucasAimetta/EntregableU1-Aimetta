package empresa.Shipping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoatShippingStrategyTest {
    private BoatShippingStrategy logica;
    @BeforeEach
    void setUp(){
        logica = new BoatShippingStrategy();
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
        Assertions.assertEquals(49000.0, result);
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
        Assertions.assertEquals(43000.0, result);
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
        Assertions.assertEquals(51250.00000000001, result);
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
        Assertions.assertEquals(43000.0, result);
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
        Assertions.assertEquals(43000.0, result);
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
        Assertions.assertEquals(48000.0, result);
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
        Assertions.assertEquals(53000.0, result);
    }

}

