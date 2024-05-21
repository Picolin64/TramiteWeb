package com.citizentech.model;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class UsuarioTramiteIterator implements Iterator<UsuarioTramite> {
    private List<UsuarioTramite> lista;
    private int posicion = 0;

    public UsuarioTramiteIterator(List<UsuarioTramite> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public UsuarioTramite next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return lista.get(posicion++);
    }
}