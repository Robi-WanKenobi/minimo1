package RESTService;

import Fachada.Controlador;
import Models.Objeto;
import Models.Usuario;
import org.apache.log4j.Logger;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roberto on 21/03/2017.
 */

@Path("/json")
public class JSONController {

    final Logger logger = Logger.getLogger("REST Logger");
    protected Controlador controlador;

    @Singleton
    public JSONController(){
        controlador = new Controlador();
    }

    @GET
    @Path("/usuario/got_all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios(){

        return controlador.getListaUsuarios();
    }

    @POST
    @Path("/usuario/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario usuario) {

        controlador.addUsuario(usuario);
        String yesResult = "Usuario guardado: " + usuario.getNombre();
        return Response.status(201).entity(yesResult).build();
    }

    @POST
    @Path("/usuario/modified/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyUsuario(@PathParam("id") int id, Usuario usuario) {

        controlador.modUsuario(id,usuario);
        String yesResult = "Usuario modificado: " + usuario.getNombre()+ "; En la posición: "+id;
        return Response.status(201).entity(yesResult).build();
    }

    @GET
    @Path("/usuario/got/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") int id){

        Usuario consulta = new Usuario();
        List<Usuario> recorrido = controlador.getListaUsuarios();

        for (int i= 0; i<recorrido.size(); i++)
        {
            if (recorrido.get(i).getId()==id)
            {
                consulta = recorrido.get(i);
            }
        }

        logger.info("Usuario: "+consulta.getNombre());
        return consulta;
    }

    @GET
    @Path("/usuario/got/{id}/objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Objeto> getObjectosFromUsuario(@PathParam("id") int id){

        List<Objeto> objetosUsuarios = controlador.getObjetosFromUsuario(id);
        return objetosUsuarios;
    }

    @POST
    @Path("/usuario/{id}/add_objeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuarioInJSON(@PathParam("id") int id, Objeto o) {

        controlador.giveObjetoToUsuario(id,o);
        String yesResult = "Objeto añadido: " + o.getNombre()+ "; Al usuario con identificador: "+id;
        return Response.status(201).entity(yesResult).build();
    }
}
