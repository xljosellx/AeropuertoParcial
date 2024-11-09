package main;

public class Usuario {
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    public Usuario(String nombre, String pasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Pasaporte: " + pasaporte);
        System.out.println("Nacionalidad: " + nacionalidad);
    }
}
