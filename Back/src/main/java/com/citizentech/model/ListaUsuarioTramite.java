package com.citizentech.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaUsuarioTramite implements Iterable<UsuarioTramite> {
    
    private List<UsuarioTramite> lista;
    
    public ListaUsuarioTramite(){
        lista = new ArrayList<UsuarioTramite>();
    }

    public List<UsuarioTramite> getLista() {
        return lista;
    }

    public void setLista(List<UsuarioTramite> lista) {
        this.lista = lista;
    }

    @Override
    public Iterator<UsuarioTramite> iterator() {
        return new UsuarioTramiteIterator(lista);
    }

}
