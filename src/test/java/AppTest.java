import Fachada.Controlador;
import Models.Objeto;
import Models.Usuario;
import junit.framework.Test;
import org.apache.log4j.BasicConfigurator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    Controlador controladorTest = new Controlador();

    @org.junit.Test
    public void addUsuario()
    {
        //Introducimos un usuario y miramos que en la lista haya algo
        Usuario u = new Usuario();
        u.setId(4); u.setNombre("Aleix"); u.setPassword("FCBcanovas");
        controladorTest.addUsuario(u);
        assertTrue(controladorTest.getListaUsuariosByName().size() == 4);
    }

    @org.junit.Test
    public void addObjetoToUsuario()
    {
        Objeto o = new Objeto();
        o.setId(1); o.setNombre("Pocion"); o.setDescripcion("Restaura puntos de salud");
        controladorTest.giveObjetoToUsuario(2,o);
        assertTrue(controladorTest.getObjetosFromUsuario(2).size() == 6);
    }
}
