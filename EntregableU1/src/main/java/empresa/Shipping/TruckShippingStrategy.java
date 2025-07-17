package empresa.Shipping;

public class TruckShippingStrategy implements  IShippingStrategy{
    @Override
    public double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny) {
        double totalCost=10000;
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
