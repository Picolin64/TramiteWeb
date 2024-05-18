package com.citizentech.service;

import com.citizentech.model.Respuesta;

public interface InterfazUsuarioDAO {
    public Respuesta iniciarSesion(String usuarioJson);
    public Respuesta registrarUsuario(String usuarioJson);
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, int registrosEliminados);
}
