package main;

import java.util.ArrayList;

public class Vuelo {
    private String id;
    private String origen;
    private String destino;
    private String horario;
    private double precio;
    private int maxPasajeros;
    private ArrayList<String> asientosReservados;

    public Vuelo(String id, String origen, String destino, String horario, double precio, int maxPasajeros) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horario = horario;
        this.precio = precio;
        this.maxPasajeros = maxPasajeros;
        this.asientosReservados = new ArrayList<>();
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getHorario() {
        return horario;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean reservarAsiento(String asiento) {
        if (asientosReservados.size() < maxPasajeros && !asientosReservados.contains(asiento)) {
            asientosReservados.add(asiento);
            return true;
        }
        return false;
    }
}
