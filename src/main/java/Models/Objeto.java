package Models;

import Interface.EetakemonManager;

/**
 * Created by Roberto on 19/04/2017.
 */
public class Objeto{

    private int id;
    private String nombre, descripcion;

    public Objeto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
