package com.citizentech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.citizentech.model.Respuesta;
import com.citizentech.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioDAO implements InterfazUsuarioDAO {

    static final Logger logger = Logger.getLogger(UsuarioDAO.class);
    private static final String ERROR = "Error";

    private final String QRY_INICIAR_SESION = ""
        + " SELECT u.numero_identificacion, u.contraseña "
        + " FROM usuario u";

    private final String QRY_REGISTRAR = ""
        + " INSERT INTO public.usuario (numero_identificacion, nombres, "
        + "     apellidos, contraseña) ";

    @Override
    public Respuesta iniciarSesion(String usuarioJson) {
        String sql = QRY_INICIAR_SESION;
        sql += " WHERE numero_identificacion = ? ";
        sql += " AND contraseña = ? ";

        Respuesta respuesta = procesarRespuesta(false, 0, 0, 0);

        try (Connection c = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){

            ObjectMapper mapper = new ObjectMapper();
            Usuario usuario = mapper.readValue(usuarioJson, Usuario.class);

            preparedStatement.setString(1, usuario.getNumeroIdentificacion());
            preparedStatement.setString(2, usuario.getContraseña());

            try (ResultSet resultSet = preparedStatement.executeQuery();){
                respuesta = procesarRespuesta(resultSet.next(), 0, 0, 0);
            } catch (Exception e){
                logger.error(ERROR, e);
            }
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return respuesta;
    }

    @Override
    public Respuesta registrarUsuario(String usuarioJson) {
        String sql = QRY_REGISTRAR;
        sql += " VALUES (?, ?, ?, ?) ";
        sql += " ON CONFLICT DO NOTHING ";

        int resultado;
        Respuesta respuesta = procesarRespuesta(false, 0, 0, 0);

        try (Connection c = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){

            ObjectMapper mapper = new ObjectMapper();
            Usuario usuario = mapper.readValue(usuarioJson, Usuario.class);
            
            preparedStatement.setString(1, usuario.getNumeroIdentificacion());
            preparedStatement.setString(2, usuario.getNombres());
            preparedStatement.setString(3, usuario.getApellidos());
            preparedStatement.setString(4, usuario.getContraseña());

            resultado = preparedStatement.executeUpdate();

            respuesta = procesarRespuesta(resultado > 0, resultado, 0, 0);
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return respuesta;
    }

    @Override
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, int registrosEliminados) {
        Respuesta respuesta = new Respuesta();

        if (exito){
            respuesta.setEstado("exito");
        } else {
            respuesta.setEstado("fallido");
        }
        
        if (registrosInsertados == 0){
            respuesta.setRegistrosInsertados(null);
        } else {
            respuesta.setRegistrosInsertados(registrosInsertados);
        }
        
        if (registrosActualizados == 0){
            respuesta.setRegistrosActualizados(null);
        } else {
            respuesta.setRegistrosActualizados(registrosActualizados);
        }
        
        if (registrosEliminados == 0) {
            respuesta.setRegistrosEliminados(null);
        } else {
            respuesta.setRegistrosEliminados(registrosEliminados);
        }

        return respuesta;
    }
    
}
