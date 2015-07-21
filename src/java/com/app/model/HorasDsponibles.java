/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(name = "horas_dsponibles", catalog = "mejoramostuvida", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorasDsponibles.findAll", query = "SELECT h FROM HorasDsponibles h"),
    @NamedQuery(name = "HorasDsponibles.findById", query = "SELECT h FROM HorasDsponibles h WHERE h.id = :id"),
    @NamedQuery(name = "HorasDsponibles.findByEstado", query = "SELECT h FROM HorasDsponibles h WHERE h.estado = :estado"),
    @NamedQuery(name = "HorasDsponibles.findByValor", query = "SELECT h FROM HorasDsponibles h WHERE h.valor = :valor")})
public class HorasDsponibles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Estado", nullable = false)
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "Valor", nullable = false)
    private int valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhora")
    private Collection<ReservaHora> reservaHoraCollection;
    @JoinColumn(name = "Id_modulo", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Modulo idmodulo;
    @JoinColumn(name = "Id_calentadrio", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Calendario idcalentadrio;
    @JoinColumn(name = "Id_rut_user", referencedColumnName = "Rut", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idrutuser;

    public HorasDsponibles() {
    }

    public HorasDsponibles(Integer id) {
        this.id = id;
    }

    public HorasDsponibles(Integer id, boolean estado, int valor,Modulo idmodulo,Calendario idcalentadrio,Usuario idrutuser) {
        this.id = id;
        this.estado = estado;
        this.valor = valor;
        this.idmodulo=idmodulo;
        this.idcalentadrio=idcalentadrio;
        this.idrutuser=idrutuser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<ReservaHora> getReservaHoraCollection() {
        return reservaHoraCollection;
    }

    public void setReservaHoraCollection(Collection<ReservaHora> reservaHoraCollection) {
        this.reservaHoraCollection = reservaHoraCollection;
    }

    public Modulo getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Modulo idmodulo) {
        this.idmodulo = idmodulo;
    }

    public Calendario getIdcalentadrio() {
        return idcalentadrio;
    }

    public void setIdcalentadrio(Calendario idcalentadrio) {
        this.idcalentadrio = idcalentadrio;
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
        if (!(object instanceof HorasDsponibles)) {
            return false;
        }
        HorasDsponibles other = (HorasDsponibles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.model.HorasDsponibles[ id=" + id + " ]";
    }
    
}
