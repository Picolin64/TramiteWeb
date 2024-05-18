package com.citizentech.presentacion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.citizentech.model.ListaUsuarioTramite;
import com.citizentech.model.Respuesta;
import com.citizentech.service.InterfazUsuarioTramiteDAO;

@Path("/usuariotramite")
public class ServiciosUsuarioTramite {
    
    static final Logger logger = Logger.getLogger(ServiciosUsuarioTramite.class);
    private static final String ERROR = "Error";
    private static final String OPTIONS = "OPTIONS";

    @Inject
    private InterfazUsuarioTramiteDAO dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_usuario}")
    public Response getHistorialUsuarioTramite(@PathParam("id_usuario") int idUsuario) {

        ListaUsuarioTramite listaUsuarioTramite = new ListaUsuarioTramite();

        try {
            listaUsuarioTramite.setLista(dao.historialUsuarioTramite(idUsuario));
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(listaUsuarioTramite)
            .allow(OPTIONS).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRegistrarUsuarioTramite(String usuarioTramiteJson) {

        Respuesta respuesta;

        try {
            respuesta = dao.registrarUsuarioTramite(usuarioTramiteJson);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuesta)
            .allow(OPTIONS).build();
    }
}
