package Interface;

import Models.Objeto;
import Models.Usuario;

import java.util.List;

/**
 * Created by Roberto on 19/04/2017.
 */
public interface EetakemonManager {

    List<Usuario> getListaUsuariosByName();
    void addUsuario(Usuario u);
    void modUsuario(int idUsuario, Usuario modU);
    List<Objeto> getObjetosFromUsuario(int idUsuario);
    void giveObjetoToUsuario(int idUsuario, Objeto o);

}
