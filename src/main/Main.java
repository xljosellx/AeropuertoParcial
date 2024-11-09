package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear aeropuertos
        Aeropuerto elDorado = new Aeropuerto("El Dorado", "Bogotá", "Colombia", false, "", 50000000);
        Aeropuerto jfk = new Aeropuerto("JFK", "Nueva York", "USA", true, "Louis Vuitton, Rolex", 0);
        Aeropuerto heathrow = new Aeropuerto("Heathrow", "Londres", "Reino Unido", false, "", 30000000);

        // Crear compañías
        Compania avianca = new Compania("Avianca", "Colombia");
        avianca.agregarVuelo(new Vuelo("001", "Bogotá", "Medellín", "08:00 AM", 500000, 64));
        avianca.agregarVuelo(new Vuelo("002", "Bogotá", "Cartagena", "10:00 AM", 650000, 64));
        avianca.agregarVuelo(new Vuelo("003", "Bogotá", "Lima", "12:00 PM", 1200000, 64));

        Compania delta = new Compania("Delta Airlines", "USA");
        delta.agregarVuelo(new Vuelo("D01", "Nueva York", "Atlanta", "09:00 AM", 450000, 100));
        delta.agregarVuelo(new Vuelo("D02", "Nueva York", "Los Ángeles", "11:00 AM", 800000, 100));
        delta.agregarVuelo(new Vuelo("D03", "Nueva York", "Londres", "05:00 PM", 2000000, 100));

        Compania britishAirways = new Compania("British Airways", "Reino Unido");
        britishAirways.agregarVuelo(new Vuelo("BA01", "Londres", "Edimburgo", "07:00 AM", 300000, 64));
        britishAirways.agregarVuelo(new Vuelo("BA02", "Londres", "París", "10:00 AM", 700000, 64));
        britishAirways.agregarVuelo(new Vuelo("BA03", "Londres", "Tokio", "03:00 PM", 5000000, 64));

        elDorado.agregarCompania(avianca);
        jfk.agregarCompania(delta);
        heathrow.agregarCompania(britishAirways);

        // Datos del usuario
        System.out.println("Ingrese sus datos personales:");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Número de pasaporte: ");
        String pasaporte = sc.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();
        Usuario usuario = new Usuario(nombre, pasaporte, nacionalidad);

        // Menú: selección de aeropuerto
        System.out.println("\nSeleccione el tipo de aeropuerto:");
        System.out.println("1. Privado");
        System.out.println("2. Público");
        int opcionAeropuerto = sc.nextInt();
        Aeropuerto aeropuertoSeleccionado = null;
        if (opcionAeropuerto == 1) {
            System.out.println("\nSeleccione un aeropuerto privado:");
            System.out.println("1. JFK (Nueva York)");
            System.out.println("2. Heathrow (Londres)");
            System.out.println("3. El Dorado (Bogotá)");
            int opcionPrivado = sc.nextInt();
            if (opcionPrivado == 1) aeropuertoSeleccionado = jfk;
            if (opcionPrivado == 2) aeropuertoSeleccionado = heathrow;
            if (opcionPrivado == 3) aeropuertoSeleccionado = elDorado;
        } else {
            System.out.println("\nSeleccione un aeropuerto público:");
            System.out.println("1. El Dorado (Bogotá)");
            System.out.println("2. Heathrow (Londres)");
            System.out.println("3. JFK (Nueva York)");
            int opcionPublico = sc.nextInt();
            if (opcionPublico == 1) aeropuertoSeleccionado = elDorado;
            if (opcionPublico == 2) aeropuertoSeleccionado = heathrow;
            if (opcionPublico == 3) aeropuertoSeleccionado = jfk;
        }

        // Menú: selección de compañía
        System.out.println("\nSeleccione una compañía:");
        for (int i = 0; i < aeropuertoSeleccionado.getCompanias().size(); i++) {
            System.out.println((i + 1) + ". " + aeropuertoSeleccionado.getCompanias().get(i).getNombre());
        }
        int opcionCompania = sc.nextInt();
        Compania companiaSeleccionada = aeropuertoSeleccionado.getCompanias().get(opcionCompania - 1);

        // Menú: selección de vuelo
        System.out.println("\nSeleccione un vuelo:");
        companiaSeleccionada.mostrarVuelos();
        int opcionVuelo = sc.nextInt();
        Vuelo vueloSeleccionado = companiaSeleccionada.getVuelos().get(opcionVuelo - 1);

        // Menú: selección de asiento
        Asiento asientos = new Asiento();
        asientos.mostrarAsientos();
        System.out.print("Seleccione su asiento: ");
        sc.nextLine(); // Limpiar buffer
        String asientoSeleccionado = sc.nextLine();
        while (!vueloSeleccionado.reservarAsiento(asientoSeleccionado)) {
            System.out.println("Asiento no disponible. Intente nuevamente:");
            asientoSeleccionado = sc.nextLine();
        }

        // Mostrar factura
        System.out.println("\n--- FACTURA ---");
        usuario.mostrarInfo();
        System.out.println("Aeropuerto: " + aeropuertoSeleccionado.getNombre());
        System.out.println("Compañía: " + companiaSeleccionada.getNombre());
        System.out.println("Vuelo: " + vueloSeleccionado.getOrigen() + " -> " + vueloSeleccionado.getDestino());
        System.out.println("Asiento reservado: " + asientoSeleccionado);
        System.out.println("Precio total: $" + vueloSeleccionado.getPrecio());

        sc.close();
    }
}
