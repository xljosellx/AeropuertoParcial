package main;

import java.util.ArrayList;

public class Asiento {
    private ArrayList<String> asientosDisponibles;

    public Asiento() {
        asientosDisponibles = new ArrayList<>();
        asientosDisponibles.add("0A");
        asientosDisponibles.add("1B");
        asientosDisponibles.add("2C");
        asientosDisponibles.add("3D");
        asientosDisponibles.add("4E");
        asientosDisponibles.add("5F");
        asientosDisponibles.add("6G");
    }

    public void mostrarAsientos() {
        System.out.println("\nOpciones de asiento:");
        for (String asiento : asientosDisponibles) {
            System.out.println(asiento);
        }
    }
}
