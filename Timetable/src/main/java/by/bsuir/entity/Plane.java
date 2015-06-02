/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "plane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p"),
    @NamedQuery(name = "Plane.findByIdplane", query = "SELECT p FROM Plane p WHERE p.idplane = :idplane"),
    @NamedQuery(name = "Plane.findByPlacecol", query = "SELECT p FROM Plane p WHERE p.placecol = :placecol"),
    @NamedQuery(name = "Plane.findByName", query = "SELECT p FROM Plane p WHERE p.name = :name"),
    @NamedQuery(name = "Plane.findByNumber", query = "SELECT p FROM Plane p WHERE p.number = :number")})
public class Plane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplane")
    private Integer idplane;
    @Column(name = "placecol")
    private Integer placecol;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private Integer number;
    @OneToMany(mappedBy = "planeId")
    private Collection<FlightHasPlane> flightHasPlaneCollection;

    public Plane() {
    }
    
    

    public Plane( String name,Integer number, Integer placecol) {
		this.placecol = placecol;
		this.name = name;
		this.number = number;
	}



	public Plane(Integer idplane) {
        this.idplane = idplane;
    }

    public Integer getIdplane() {
        return idplane;
    }

    public void setIdplane(Integer idplane) {
        this.idplane = idplane;
    }

    public Integer getPlacecol() {
        return placecol;
    }

    public void setPlacecol(Integer placecol) {
        this.placecol = placecol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @XmlTransient
    public Collection<FlightHasPlane> getFlightHasPlaneCollection() {
        return flightHasPlaneCollection;
    }

    public void setFlightHasPlaneCollection(Collection<FlightHasPlane> flightHasPlaneCollection) {
        this.flightHasPlaneCollection = flightHasPlaneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplane != null ? idplane.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane other = (Plane) object;
        if ((this.idplane == null && other.idplane != null) || (this.idplane != null && !this.idplane.equals(other.idplane))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.Plane[ idplane=" + idplane + " ]";
    }
    
}
