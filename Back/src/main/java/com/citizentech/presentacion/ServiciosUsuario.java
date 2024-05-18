package com.citizentech.presentacion;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.citizentech.model.Respuesta;
import com.citizentech.service.InterfazUsuarioDAO;

@Path("/usuario")
public class ServiciosUsuario {
    static final Logger logger = Logger.getLogger(ServiciosUsuario.class);
    private static final String ERROR = "Error";
    private static final String OPTIONS = "OPTIONS";

    @Inject
    private InterfazUsuarioDAO dao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response postIniciarSesion(String usuarioJson) {
        Respuesta respuesta;

        try {
            respuesta = dao.iniciarSesion(usuarioJson);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuesta)
            .allow(OPTIONS).build();   
    } 

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response postRegistrarUsuario(String usuarioJson) {
        Respuesta respuesta;

        try {
            respuesta = dao.registrarUsuario(usuarioJson);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuesta)
            .allow(OPTIONS).build();
    }
}