package Main;

import Fachada.Controlador;
import org.apache.log4j.BasicConfigurator;
/**
 * Created by Roberto on 19/04/2017.
 */
public class Main {

    public static void main(String[] args){

        BasicConfigurator.configure();
        Controlador controlador = new Controlador();
        
    }

}
