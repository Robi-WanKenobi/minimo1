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
        Usuario u = new Usuario(4,"Aleix", "fcbcanovas");
        controladorTest.addUsuario(u);
        assertTrue(controladorTest.getListaUsuariosByName().size() == 4);
    }

    @org.junit.Test
    public void addObjetoToUsuario()
    {
        Objeto o = new Objeto(1,"Poción", "Restaura vida al tomarla");
        controladorTest.giveObjetoToUsuario(2,o);
        assertTrue(controladorTest.getObjetosFromUsuario(2).size() == 6);
    }
}
