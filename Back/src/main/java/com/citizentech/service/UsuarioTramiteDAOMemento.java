package com.citizentech.service;

import java.util.ArrayList;
import java.util.List;


class UsuarioTramiteDAOMemento {
    private final List<UsuarioTramiteDAO> estado;

    public UsuarioTramiteDAOMemento(List<UsuarioTramiteDAO> estado) {
        this.estado = new ArrayList<>(estado);
    }

    public List<UsuarioTramiteDAO> getEstado() {
        return estado;
    }
}


class CareTaker {
    private final List<UsuarioTramiteDAOMemento> mementos = new ArrayList<>();

    public void guardarMemento(UsuarioTramiteDAOMemento memento) {
        mementos.add(memento);
    }

    public UsuarioTramiteDAOMemento obtenerUltimoMemento() {
        if (mementos.isEmpty()) {
            return null;
        }
        return mementos.get(mementos.size() - 1);
    }
}