/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(name = "reserva_hora", catalog = "mejoramostuvida", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaHora.findAll", query = "SELECT r FROM ReservaHora r"),
    @NamedQuery(name = "ReservaHora.findById", query = "SELECT r FROM ReservaHora r WHERE r.id = :id")})
public class ReservaHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @JoinColumn(name = "Id_hora", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private HorasDsponibles idhora;
    @JoinColumn(name = "Id_rut_cliente", referencedColumnName = "Rut", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idrutcliente;

    public ReservaHora() {
    }

    public ReservaHora(Integer id,HorasDsponibles idhora, Cliente idrutcliente) {
        this.id = id;
        this.idhora=idhora;
        this.idrutcliente=idrutcliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HorasDsponibles getIdhora() {
        return idhora;
    }

    public void setIdhora(HorasDsponibles idhora) {
        this.idhora = idhora;
    }

    public Cliente getIdrutcliente() {
        return idrutcliente;
    }

    public void setIdrutcliente(Cliente idrutcliente) {
        this.idrutcliente = idrutcliente;
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
        if (!(object instanceof ReservaHora)) {
            return false;
        }
        ReservaHora other = (ReservaHora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.model.ReservaHora[ id=" + id + " ]";
    }
    
}
