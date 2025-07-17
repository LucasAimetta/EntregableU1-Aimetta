package empresa.Shipping;

public class AirShippingStrategy implements  IShippingStrategy{
    @Override
    public double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny) {
       double totalCost=50000;
       if(weight>300){                                      //SIMULA UNA LOGICA DONDE EL COSTO VA A VARIAR DEPENDIENDO DE:
           totalCost=totalCost*1.5;                         // SI EL PESO ES MAYOR A 300G
       }else{                                               // LAS DIMENSIONES MAYORES A 5000CM3
           totalCost=totalCost*1.2;                         // LA DISTANCIA MENOR A 1000KM, ENTRE 1000 Y 2000KM Y MAYOR A 2000KM
       }

       if(dimensiones<5000){
           totalCost=totalCost*1.2;
       }else{totalCost=totalCost*1.7;}


        DistanceCalculator calculator = new DistanceCalculator();
       double distance = calculator.distanceInKilometers(coordinatesOrigin,coordinatesDestiny);
        if(distance<1000){
            totalCost+=7000;
        } else if (distance<2000) {
            totalCost+=10000;
        }else {
            totalCost+=15000;
        }

        return totalCost;
    }
}

