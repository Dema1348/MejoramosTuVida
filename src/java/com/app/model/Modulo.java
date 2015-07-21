/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(name = "modulo", catalog = "mejoramostuvida", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findById", query = "SELECT m FROM Modulo m WHERE m.id = :id"),
    @NamedQuery(name = "Modulo.findByIncio", query = "SELECT m FROM Modulo m WHERE m.incio = :incio"),
    @NamedQuery(name = "Modulo.findByTermino", query = "SELECT m FROM Modulo m WHERE m.termino = :termino")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Incio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date incio;
    @Basic(optional = false)
    @Column(name = "Termino", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date termino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmodulo")
    private Collection<HorasDsponibles> horasDsponiblesCollection;

    public Modulo() {
    }

    public Modulo(Integer id) {
        this.id = id;
    }

    public Modulo(Integer id, Date incio, Date termino) {
        this.id = id;
        this.incio = incio;
        this.termino = termino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIncio() {
        return incio;
    }

    public void setIncio(Date incio) {
        this.incio = incio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    @XmlTransient
    public Collection<HorasDsponibles> getHorasDsponiblesCollection() {
        return horasDsponiblesCollection;
    }

    public void setHorasDsponiblesCollection(Collection<HorasDsponibles> horasDsponiblesCollection) {
        this.horasDsponiblesCollection = horasDsponiblesCollection;
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
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.model.Modulo[ id=" + id + " ]";
    }
    
}
