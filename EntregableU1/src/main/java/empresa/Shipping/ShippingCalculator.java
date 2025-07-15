package empresa.Shipping;

public class ShippingCalculator {
public IShippingStrategy shippingStrategy;
public Coordinates origin;
public Coordinates destiny;
public double weight;
public double dimentions;

public ShippingCalculator(){}
    public ShippingCalculator(IShippingStrategy shippingStrategy, Coordinates origin, Coordinates destiny, double weight,  double dimentions){
    this.destiny=destiny;
    this.dimentions=dimentions;
    this.shippingStrategy=shippingStrategy;
    this.origin=origin;
    this.weight=weight;
    }

    public void setDestiny(Coordinates destiny) {
        this.destiny = destiny;
    }

    public Coordinates getDestiny() {
        return destiny;
    }

    public Coordinates getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinates origin) {
        this.origin = origin;
    }

    public double getDimentions() {
        return dimentions;
    }

    public void setDimentions(double dimentions) {
        this.dimentions = dimentions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public IShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(IShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateCost(){
    return shippingStrategy.calculateCost(weight,dimentions,origin,destiny);
    }
}
