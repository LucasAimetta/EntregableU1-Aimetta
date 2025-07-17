package empresa.Shipping;

public class AirShippingStrategy implements  IShippingStrategy{
    @Override
    public double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny) {
       double totalCost=50000;
       if(weight>300){
           totalCost=totalCost*1.5;
       }else{
           totalCost=totalCost*1.2;
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
