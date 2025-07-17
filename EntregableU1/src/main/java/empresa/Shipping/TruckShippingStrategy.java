package empresa.Shipping;

public class TruckShippingStrategy implements  IShippingStrategy{
    @Override
    public double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny) {
        double totalCost=10000;
        //SIMULA UNA LOGICA DONDE EL COSTO VA A VARIAR DEPENDIENDO DE:
// SI EL PESO ES MAYOR A 300G
// LAS DIMENSIONES MAYORES A 5000CM3
// LA DISTANCIA MENOR A 1000KM, ENTRE 1000 Y 2000KM Y MAYOR A 2000KM
        if(weight>300){
            totalCost=totalCost*1.4;
        }else{
            totalCost=totalCost*1.1;
        }

        if(dimensiones<5000){
            totalCost=totalCost*1.4;
        }else{totalCost=totalCost*1.8;}
        DistanceCalculator calculator = new DistanceCalculator();
        double distance = calculator.distanceInKilometers(coordinatesOrigin,coordinatesDestiny);
        if(distance<1000){
            totalCost+=5000;
        } else if (distance<2000) {
            totalCost+=8000;
        }else {
            totalCost+=12000;
        }

        return totalCost;
    }
}
