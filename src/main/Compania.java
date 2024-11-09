package main;

import java.util.ArrayList;

public class Compania {
    private String nombre;
    private String pais;
    private ArrayList<Vuelo> vuelos;

    public Compania(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.vuelos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public void mostrarVuelos() {
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            System.out.println((i + 1) + ". " + vuelo.getOrigen() + " -> " + vuelo.getDestino() +
                               " | Horario: " + vuelo.getHorario() + " | Precio: $" + vuelo.getPrecio());
        }
    }
}
