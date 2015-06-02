/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

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
 * @author Дмитрий
 */
@Entity
@Table(name = "flight_has_plane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightHasPlane.findAll", query = "SELECT f FROM FlightHasPlane f"),
    @NamedQuery(name = "FlightHasPlane.findById", query = "SELECT f FROM FlightHasPlane f WHERE f.id = :id")})
public class FlightHasPlane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "flight_id", referencedColumnName = "idflight")
    @ManyToOne
    private Flight flightId;
    @JoinColumn(name = "plane_id", referencedColumnName = "idplane")
    @ManyToOne
    private Plane planeId;

    public FlightHasPlane() {
    }

    public FlightHasPlane(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane planeId) {
        this.planeId = planeId;
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
        if (!(object instanceof FlightHasPlane)) {
            return false;
        }
        FlightHasPlane other = (FlightHasPlane) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.FlightHasPlane[ id=" + id + " ]";
    }
    
}
