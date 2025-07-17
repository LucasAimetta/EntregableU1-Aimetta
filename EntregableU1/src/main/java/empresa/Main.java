package empresa;

import empresa.Payment.PaymentManager;
import empresa.Shipping.*;
import empresa.Utils.Result;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;


public class Main {
    static boolean continuar = true;
    static Scanner scanner = new Scanner(System.in);
    static PaymentManager logicaPayment = new PaymentManager();
    static ShippingCalculator logicaShipping = new ShippingCalculator();
static Result resultado = new Result();
    public static void main(String[] args) {

        while (continuar){

mostarAcciones();
int accion = Integer.parseInt(scanner.nextLine());
switch (accion){
    case 1:
        CompletableFuture
                .supplyAsync(()->procesarPago())
                .thenAccept(result -> System.out.println(result.getMessage()))
                .join();
        break;
    case 2:
        CompletableFuture
                .supplyAsync(()->procesarReembolzo())
                .thenAccept(result -> System.out.println(result.getMessage()))
                .join();
        break;
    case 3:

        CompletableFuture
                .supplyAsync(()->calcularCosto())
                .thenAccept( costo->System.out.println("El costo del envio es $"+ costo))
                .join();
        break;
    case 4:continuar=false;break;


}


        }


    }
private static void mostarAcciones(){
        System.out.println("¿Que desea realizar?");
    System.out.println("1= Procesar Pago");
    System.out.println("2= Procesar Reembolzo");
    System.out.println("3= Calcular Costo de Envio");
    System.out.println("4= Salir");
    }

    private static Result procesarPago(){
        System.out.println("Ingrese el monto: ");
        double amount = Integer.parseInt(scanner.nextLine());

        System.out.println("1. mercado pago ");
        System.out.println("2. pix ");
        System.out.println("3. paypal ");
        System.out.println("Ingrese el metodo de pago ");
         int processor = Integer.parseInt(scanner.nextLine());
         String processorString = "";
         switch (processor){
             case 1:processorString="mercadopago";break;
             case 2:processorString="pix";break;
             case 3:processorString="paypal";break;
             default: System.out.println("Ha ingresado un numero incorrecto");break;
         }
        Result result = logicaPayment.processPayment(amount,processorString);
         return result;
    }

    private static Result procesarReembolzo(){
        System.out.println("Ingrese el monto: ");
        double amount = Integer.parseInt(scanner.nextLine());

        System.out.println("1. mercado pago ");
        System.out.println("2. pix ");
        System.out.println("3. paypal ");
        System.out.println("Ingrese el metodo de pago ");
        int processor = Integer.parseInt(scanner.nextLine());
        String processorString = "";
        switch (processor){
            case 1:processorString="mercadopago";break;
            case 2:processorString="pix";break;
            case 3:processorString="paypal";break;
            default: System.out.println("Ha ingresado un numero incorrecto");break;
        }
        Result result = logicaPayment.processRefund(amount,processorString);
        return result;
    }

    private static Double calcularCosto(){

        System.out.println("1. Barco ");
        System.out.println("2. Camion ");
        System.out.println("3. Avion ");
        System.out.println("Ingrese el metodo de envio ");
        int envio = Integer.parseInt(scanner.nextLine());
        IShippingStrategy strategy = null;
        switch (envio){
            case 1:   strategy = new BoatShippingStrategy();break;
            case 2:  strategy = new TruckShippingStrategy();break;
            case 3:  strategy = new AirShippingStrategy();break;
            default:System.out.println("Ha ingresado un numero incorrecto");break;
        }
        System.out.print("Ingrese latitud de Origen: ");
        double latitud = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese longitud de Origen: ");
        double longitud = Double.parseDouble(scanner.nextLine());

        Coordinates coordenadas = new Coordinates();
        coordenadas.setLongitud(longitud);
        coordenadas.setLatitud(latitud);

        System.out.print("Ingrese latitud de Destino: ");
        double latitudDestino = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingrese longitud de Destino: ");
        double longitudDestino = Double.parseDouble(scanner.nextLine());

        Coordinates coordenadasDestino = new Coordinates();
        coordenadasDestino.setLongitud(longitudDestino);
        coordenadasDestino.setLatitud(latitudDestino);

        System.out.println("Ingrese las dimensiones del paquete ");
        int dimensiones = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el peso del paquete ");
        int peso = Integer.parseInt(scanner.nextLine());

        logicaShipping.setShippingStrategy(strategy);
        logicaShipping.setDimentions(dimensiones);
        logicaShipping.setWeight(peso);
        logicaShipping.setOrigin(coordenadas);
        logicaShipping.setDestiny(coordenadasDestino);
        double costo = logicaShipping.calculateCost();
return costo;
    }


}