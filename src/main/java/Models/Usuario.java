package Models;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Roberto on 19/04/2017.
 */
public class Usuario implements Comparable<Usuario> {

    private int id;
    private String nombre, password;
    private List<Objeto> objetos;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
    public int compareTo(Usuario o) {
        return this.getNombre().compareToIgnoreCase(o.getNombre());
    }
}
