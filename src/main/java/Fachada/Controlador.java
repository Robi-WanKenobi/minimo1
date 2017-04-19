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

    final Logger logger = Logger.getLogger("myLogger");
    protected static Hashtable<Integer,Usuario> hastableusuarios;

    public Controlador() {
        hastableusuarios = new Hashtable<Integer, Usuario>();
        List<Objeto> objetos1 = new ArrayList<Objeto>();
        objetos1.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        objetos1.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        objetos1.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        objetos1.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        Usuario u1 = new Usuario(1,"Roberto", "robrobrob");
        u1.setObjetos(objetos1);
        hastableusuarios.put(u1.getId(),u1);
        List<Objeto> objetos2 = new ArrayList<Objeto>();
        objetos2.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos2.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos2.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos2.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos2.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        Usuario u2 = new Usuario(2,"Ivan", "ivanyvienen");
        u2.setObjetos(objetos2);
        hastableusuarios.put(u2.getId(),u2);
        List<Objeto> objetos3 = new ArrayList<Objeto>();
        objetos3.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos3.add(new Objeto(1,"Revivir", "Hace que tu Eetakemon vuelva a la vida"));
        objetos3.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        objetos3.add(new Objeto(1,"Poción", "Restaura vida al tomarla"));
        Usuario u3 = new Usuario(3,"Daniel", "sobsobsob");
        u3.setObjetos(objetos3);
        hastableusuarios.put(u3.getId(),u3);
    }

    public List<Usuario> getListaUsuariosByName(){

        logger.info("Lista de usuarios:");
        List<Usuario> search = Collections.list(hastableusuarios.elements());

        for (Usuario u: search){
            logger.info(u.getId()+ ", "+u.getNombre());
        }

        logger.info("Lista de usuarios ordenada por orden alfabético:");

        Collections.sort(search);

        for (Usuario u: search){
            logger.info(u.getId()+ ", "+u.getNombre());
        }
        return search;
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
