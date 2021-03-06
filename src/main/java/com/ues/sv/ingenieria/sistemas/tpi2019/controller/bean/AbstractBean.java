package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author bryan
 */
public abstract class AbstractBean<T> {

    List<T> listaDatos;
    public final static String EXITO = "Transaccion exitosa.";
    public final static String ERROR = "Ocurrio un error en la transaccion.";

    protected abstract AbstractFacade<T> getFacade();

    public abstract T getEntity();

    public void crear() {
        if (getFacade() != null) {
            try {
                getFacade().create(getEntity());
                mensajeInfo(EXITO);
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError(ERROR);
            }
        }
    }

    public void editar() {
        if (getFacade() != null) {
            try {
                getFacade().edit(getEntity());
                mensajeInfo(EXITO);
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError(ERROR);
            }
        }
    }

    public void eliminar() {
        if (getFacade() != null) {
            try {
                getFacade().remove(getEntity());
                mensajeInfo(EXITO);
                llenarLista();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                mensajeError(ERROR);
            }
        }
    }

    public void llenarLista() {
        if (getFacade().findAll() != null) {
            listaDatos = getFacade().findAll();
        } else {
            listaDatos = Collections.emptyList();
        }
    }

    public List<T> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<T> listaDatos) {
        this.listaDatos = listaDatos;
    }

    public void mensajeInfo(String msg) {
        FacesMessages.info(msg);
    }

    public void mensajeError(String msg) {
        FacesMessages.error(msg);
    }

}
