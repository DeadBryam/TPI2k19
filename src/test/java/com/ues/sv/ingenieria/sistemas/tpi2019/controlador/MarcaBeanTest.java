/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Marca;

/**
 *
 * @author arevalo
 */
public class MarcaBeanTest extends AbstractBeanTest<Marca>{

    @Override
    public Marca getEntity() {
        return new Marca();
    }

    @Override
    protected AbstractFacade<Marca> getFacade() {
        return new MarcaFacade();
    }

    @Override
    protected AbstractBean<Marca> getBean() {
        return new MarcaBean();
    }
    
}
