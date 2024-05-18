package com.citizentech.service;

import java.sql.ResultSet;
import java.util.List;

import com.citizentech.model.Respuesta;
import com.citizentech.model.UsuarioTramite;

public interface InterfazUsuarioTramiteDAO {
    public Respuesta registrarUsuarioTramite(String usuarioTramiteJson);
    public List<UsuarioTramite> historialUsuarioTramite(int idUsuario);
    public UsuarioTramite procesarUsuarioTramite(ResultSet resultSet);
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, int registrosEliminados);
}
