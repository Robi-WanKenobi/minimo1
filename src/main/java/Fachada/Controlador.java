package Fachada;

import Interface.EetakemonManager;
import Models.Objeto;
import Models.Usuario;
import groovy.lang.Singleton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Roberto on 19/04/2017.
 */
@Singleton
public class Controlador implements EetakemonManager {

    final Logger logger = Logger.getLogger("Controlador Logger");
    protected static Hashtable<Integer,Usuario> hastableusuarios;

    public Controlador() {
        hastableusuarios = new Hashtable<Integer, Usuario>();
        Objeto pocion = new Objeto();
        pocion.setId(1); pocion.setNombre("Poción"); pocion.setDescripcion("Restaura puntos de salud.");
        Objeto revivir = new Objeto();
        revivir.setId(2); revivir.setNombre("Revivir"); revivir.setDescripcion("Hacer que tu Eetakemon vuelva a la vida.");
        List<Objeto> objetos1 = new ArrayList<Objeto>();
        objetos1.add(pocion); objetos1.add(pocion); objetos1.add(pocion); objetos1.add(revivir);
        Usuario u1 = new Usuario();
        u1.setId(2); u1.setNombre("Roberto"); u1.setPassword("robrobrob"); u1.setObjetos(objetos1);
        hastableusuarios.put(u1.getId(),u1);
        List<Objeto> objetos2 = new ArrayList<Objeto>();
        objetos2.add(revivir); objetos2.add(revivir); objetos2.add(revivir); objetos2.add(revivir); objetos2.add(pocion);
        Usuario u2 = new Usuario();
        u2.setId(3); u2.setNombre("Ivan"); u2.setPassword("ivanyvienen"); u2.setObjetos(objetos2);
        hastableusuarios.put(u2.getId(),u2);
        List<Objeto> objetos3 = new ArrayList<Objeto>();
        objetos3.add(revivir); objetos3.add(revivir); objetos3.add(pocion); objetos3.add(pocion);
        Usuario u3 = new Usuario();
        u3.setId(1); u3.setNombre("Daniel"); u3.setPassword("sobsobsob"); u3.setObjetos(objetos3);
        hastableusuarios.put(u3.getId(),u3);
    }

    public List<Usuario>getListaUsuarios(){

        logger.info("Lista de usuarios:");
        List<Usuario> search = Collections.list(hastableusuarios.elements());

        for (Usuario u: search){
            logger.info(u.getId()+ ", "+u.getNombre());
        }

        return search;
    }

    public List<Usuario> getListaUsuariosByName(){

        List<Usuario> ordenar = getListaUsuarios();

        logger.info("Lista de usuarios ordenada por orden alfabético:");

        Collections.sort(ordenar);

        for (Usuario u: ordenar){
            logger.info(u.getId()+ ", "+u.getNombre());
        }
        return ordenar;
    }

    public void addUsuario(Usuario u) {
        hastableusuarios.put(u.getId(),u);
    }

    public void modUsuario(int id, Usuario modU){
        Usuario modificado = hastableusuarios.get(id);
        modificado = modU;
        hastableusuarios.put(modificado.getId(),modificado);
    }

    public List<Objeto> getObjetosFromUsuario(int idUsuario) {

        for (Objeto o : hastableusuarios.get(idUsuario).getObjetos()){
            logger.info(o.getId()+ ", "+o.getNombre());
        }

        return hastableusuarios.get(idUsuario).getObjetos();
    }

    public void giveObjetoToUsuario(int idUsuario, Objeto o) {

        hastableusuarios.get(idUsuario).getObjetos().add(o);
    }
}
