package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public abstract class AbstractBean<T> {

    List<T> listaDatos;

    protected abstract AbstractFacade<T> getFacade();

    public abstract T getEntity();

    public void crear() {
        if (getFacade() != null) {
            try {
                getFacade().create(getEntity());
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void editar() {
        if (getFacade() != null) {
            try {
                getFacade().edit(getEntity());
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void eliminar() {
        if (getFacade() != null) {
            try {
                getFacade().remove(getEntity());
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void llenarLista() {
        if (getFacade().findAll() != null) {
            listaDatos = getFacade().findAll();
            System.out.println("REGISTROS EN BASE: " + getFacade().count());
        } else {
            listaDatos = Collections.EMPTY_LIST;
        }
    }

    public List<T> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<T> listaDatos) {
        this.listaDatos = listaDatos;
    }
}
