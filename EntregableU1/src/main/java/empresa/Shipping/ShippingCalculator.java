package empresa.Shipping;

public class ShippingCalculator {
public IShippingStrategy shippingStrategy;
public Coordinates origin;
public Coordinates destiny;
public double weight;
public double dimentions;

public ShippingCalculator(){}


    public void setDestiny(Coordinates destiny) {
        this.destiny = destiny;
    }



    public void setOrigin(Coordinates origin) {
        this.origin = origin;
    }



    public void setDimentions(double dimentions) {
        this.dimentions = dimentions;
    }



    public void setWeight(double weight) {
        this.weight = weight;
    }



    public void setShippingStrategy(IShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateCost(){
    return shippingStrategy.calculateCost(weight,dimentions,origin,destiny);
    }
}
