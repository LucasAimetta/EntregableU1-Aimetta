package empresa.Shipping;

public class DistanceCalculator {

    public DistanceCalculator(){}
    public double distanceInKilometers(Coordinates origin, Coordinates destiny){
        double lat1 = Math.toRadians(origin.getLatitud());
        double lon1 = Math.toRadians(origin.getLongitud());
        double lat2 = Math.toRadians(destiny.getLatitud());
        double lon2 = Math.toRadians(destiny.getLongitud());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
                                                    //APLICAMOS LA Fórmula de Haversine PARA DEVOLVER LA DISTANCIA EN KMS ENTRE DOS COORDENADAS
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371.0 * c;
    }
}
