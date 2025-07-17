package empresa.Shipping;

public class BoatShippingStrategy implements IShippingStrategy{
    @Override
    public double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny) {
        double totalCost=25000;
        if(weight>300){
            totalCost=totalCost*1.3;        //SIMULA UNA LOGICA DONDE EL COSTO VA A VARIAR DEPENDIENDO DE:
                                            // SI EL PESO ES MAYOR A 300G
                                            // LAS DIMENSIONES MAYORES A 5000CM3
                                            // LA DISTANCIA MENOR A 1000KM, ENTRE 1000 Y 2000KM Y MAYOR A 2000KM
        }else{
            totalCost=totalCost*1.1;
        }

        if(dimensiones<5000){
            totalCost=totalCost*1.2;
        }else{totalCost=totalCost*1.5;}

        DistanceCalculator calculator = new DistanceCalculator();
        double distance = calculator.distanceInKilometers(coordinatesOrigin,coordinatesDestiny);
        if(distance<1000){
            totalCost+=10000;
        } else if (distance<2000) {
            totalCost+=15000;
        }else {
            totalCost+=20000;
        }

        return totalCost;
    }
}
