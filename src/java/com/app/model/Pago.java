/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(catalog = "mejoramostuvida", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findById", query = "SELECT p FROM Pago p WHERE p.id = :id"),
    @NamedQuery(name = "Pago.findByFechapago", query = "SELECT p FROM Pago p WHERE p.fechapago = :fechapago"),
    @NamedQuery(name = "Pago.findByTotal", query = "SELECT p FROM Pago p WHERE p.total = :total")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Fecha_pago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Basic(optional = false)
    @Column(nullable = false)
    private int total;
    @JoinColumn(name = "Id_rut_cliente", referencedColumnName = "Rut", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idrutcliente;
    @JoinColumn(name = "Id_rut_user", referencedColumnName = "Rut", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idrutuser;

    public Pago() {
    }

    public Pago(Integer id) {
        this.id = id;
    }

    public Pago(Integer id, Date fechapago, int total,Cliente idrutcliente,Usuario idrutuser) {
        this.id = id;
        this.fechapago = fechapago;
        this.total = total;
        this.idrutcliente=idrutcliente;
        this.idrutuser=idrutuser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getIdrutcliente() {
        return idrutcliente;
    }

    public void setIdrutcliente(Cliente idrutcliente) {
        this.idrutcliente = idrutcliente;
    }

    public Usuario getIdrutuser() {
        return idrutuser;
    }

    public void setIdrutuser(Usuario idrutuser) {
        this.idrutuser = idrutuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.model.Pago[ id=" + id + " ]";
    }
    
}
