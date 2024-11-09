package main;

import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private boolean esPrivado;
    private String patrocinadores;
    private double presupuesto;
    private ArrayList<Compania> companias;

    public Aeropuerto(String nombre, String ciudad, String pais, boolean esPrivado, String patrocinadores, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.esPrivado = esPrivado;
        this.patrocinadores = patrocinadores;
        this.presupuesto = presupuesto;
        this.companias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Compania> getCompanias() {
        return companias;
    }

    public void agregarCompania(Compania compania) {
        companias.add(compania);
    }
}
