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
@Table(name = "flight_has_crew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightHasCrew.findAll", query = "SELECT f FROM FlightHasCrew f"),
    @NamedQuery(name = "FlightHasCrew.findById", query = "SELECT f FROM FlightHasCrew f WHERE f.id = :id")})
public class FlightHasCrew implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "flight_id", referencedColumnName = "idflight")
    @ManyToOne
    private Flight flightId;
    @JoinColumn(name = "crew_id", referencedColumnName = "idcrew")
    @ManyToOne
    private Crew crewId;

    public FlightHasCrew() {
    }

    public FlightHasCrew(Integer id) {
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

    public Crew getCrewId() {
        return crewId;
    }

    public void setCrewId(Crew crewId) {
        this.crewId = crewId;
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
        if (!(object instanceof FlightHasCrew)) {
            return false;
        }
        FlightHasCrew other = (FlightHasCrew) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.FlightHasCrew[ id=" + id + " ]";
    }
    
}
