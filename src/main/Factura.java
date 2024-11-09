package main;

public class Factura {
    public static void generar(Pasajero pasajero, Aeropuerto aeropuerto, String vuelo, String asiento) {
        System.out.println("\n---- FACTURA ----");
        System.out.println("AEROPUERTO: " + aeropuerto.getNombre());
        System.out.println("TIPO: " + aeropuerto.getTipo());
        System.out.println("VUELO: " + vuelo);
        System.out.println("ASIENTO: " + asiento);
        System.out.println("NOMBRE: " + pasajero.getNombre());
        System.out.println("PASAPORTE: " + pasajero.getPasaporte());
        System.out.println("NACIONALIDAD: " + pasajero.getNacionalidad());
        System.out.println("-----------------");
    }
}
