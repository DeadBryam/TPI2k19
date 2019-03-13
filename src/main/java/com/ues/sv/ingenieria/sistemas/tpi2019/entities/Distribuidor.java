/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d")
    , @NamedQuery(name = "Distribuidor.findByIdDistribuidor", query = "SELECT d FROM Distribuidor d WHERE d.idDistribuidor = :idDistribuidor")
    , @NamedQuery(name = "Distribuidor.findByDistribuidor", query = "SELECT d FROM Distribuidor d WHERE d.distribuidor = :distribuidor")
    , @NamedQuery(name = "Distribuidor.findByTelefono", query = "SELECT d FROM Distribuidor d WHERE d.telefono = :telefono")})
public class Distribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_distribuidor")
    private Short idDistribuidor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "distribuidor")
    private String distribuidor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistribuidor")
    private List<Compra> compraList;

    public Distribuidor() {
    }

    public Distribuidor(Short idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public Distribuidor(Short idDistribuidor, String distribuidor, String telefono) {
        this.idDistribuidor = idDistribuidor;
        this.distribuidor = distribuidor;
        this.telefono = telefono;
    }

    public Short getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Short idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistribuidor != null ? idDistribuidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.idDistribuidor == null && other.idDistribuidor != null) || (this.idDistribuidor != null && !this.idDistribuidor.equals(other.idDistribuidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Distribuidor[ idDistribuidor=" + idDistribuidor + " ]";
    }
    
}