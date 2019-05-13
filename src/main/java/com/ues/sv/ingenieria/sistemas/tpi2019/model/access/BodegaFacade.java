/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bryan
 */
@Stateless
public class BodegaFacade extends AbstractFacade<Bodega> {

    @PersistenceContext(unitName = "com.ues.sv.ingenieria.sistemas.tpi2019_inventarioLibreria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BodegaFacade() {
        super(Bodega.class);
    }
    
    public List<Bodega> bodegaPorSucursal(String sucursal){
        return executeQuery("SELECT b FROM Bodega b WHERE b.sucursal.idSucursal = :sucursal").setParameter("sucursal", sucursal).getResultList();
    }
    
    public List<Bodega> findLike(String sucursal, String like){
        return executeQuery("SELECT b FROM Bodega b WHERE b.bodegaPK.idSucursal = :sucursal AND b.bodegaPK.idArticulo LIKE '%:like%'")
                .setParameter("sucursal", sucursal).setParameter("like", like).getResultList();
    }
}