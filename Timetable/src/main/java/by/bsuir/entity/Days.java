/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Дмитрий
 */
@Entity
@Table(name = "days")

public class Days implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddays")
    private Integer iddays;
    @Basic(optional = false)
    @Column(name = "mon")
    private boolean mon;
    @Basic(optional = false)
    @Column(name = "tue")
    private boolean tue;
    @Basic(optional = false)
    @Column(name = "wen")
    private boolean wen;
    @Basic(optional = false)
    @Column(name = "thu")
    private boolean thu;
    @Basic(optional = false)
    @Column(name = "fri")
    private boolean fri;
    @Basic(optional = false)
    @Column(name = "sat")
    private boolean sat;
    @Basic(optional = false)
    @Column(name = "sun")
    private boolean sun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "days")
    private Collection<Flight> flightCollection;

    public Days() {
    }

    public Days(Integer iddays) {
        this.iddays = iddays;
    }

    public Days(Integer iddays, boolean mon, boolean tue, boolean wen, boolean thu, boolean fri, boolean sat, boolean sun) {
        this.iddays = iddays;
        this.mon = mon;
        this.tue = tue;
        this.wen = wen;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    public Integer getIddays() {
        return iddays;
    }

    public void setIddays(Integer iddays) {
        this.iddays = iddays;
    }

    public boolean getMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean getTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean getWen() {
        return wen;
    }

    public void setWen(boolean wen) {
        this.wen = wen;
    }

    public boolean getThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean getFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean getSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean getSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddays != null ? iddays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Days)) {
            return false;
        }
        Days other = (Days) object;
        if ((this.iddays == null && other.iddays != null) || (this.iddays != null && !this.iddays.equals(other.iddays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.Days[ iddays=" + iddays + " ]";
    }
    
}
