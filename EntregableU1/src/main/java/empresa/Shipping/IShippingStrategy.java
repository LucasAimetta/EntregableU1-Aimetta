package empresa.Shipping;

import java.awt.*;

public interface IShippingStrategy {
    double calculateCost(double weight, double dimensiones, Coordinates coordinatesOrigin, Coordinates coordinatesDestiny );
}
