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
 * @author Дмитрий
 */
@Entity
@Table(name = "crew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crew.findAll", query = "SELECT c FROM Crew c"),
    @NamedQuery(name = "Crew.findByIdcrew", query = "SELECT c FROM Crew c WHERE c.idcrew = :idcrew"),
    @NamedQuery(name = "Crew.findByNumber", query = "SELECT c FROM Crew c WHERE c.number = :number")})
public class Crew implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcrew")
    private Integer idcrew;
    @Column(name = "number")
    private Integer number;
    @OneToMany(mappedBy = "crewId")
    private Collection<FlightHasCrew> flightHasCrewCollection;
    @JoinColumn(name = "pilot_2", referencedColumnName = "idpilot")
    @ManyToOne
    private Pilot pilot2;
    @JoinColumn(name = "pilot_1", referencedColumnName = "idpilot")
    @ManyToOne
    private Pilot pilot1;

    public Crew() {
    }

    public Crew(Integer idcrew) {
        this.idcrew = idcrew;
    }

    public Integer getIdcrew() {
        return idcrew;
    }

    public void setIdcrew(Integer idcrew) {
        this.idcrew = idcrew;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @XmlTransient
    public Collection<FlightHasCrew> getFlightHasCrewCollection() {
        return flightHasCrewCollection;
    }

    public void setFlightHasCrewCollection(Collection<FlightHasCrew> flightHasCrewCollection) {
        this.flightHasCrewCollection = flightHasCrewCollection;
    }

    public Pilot getPilot2() {
        return pilot2;
    }

    public void setPilot2(Pilot pilot2) {
        this.pilot2 = pilot2;
    }

    public Pilot getPilot1() {
        return pilot1;
    }

    public void setPilot1(Pilot pilot1) {
        this.pilot1 = pilot1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcrew != null ? idcrew.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crew)) {
            return false;
        }
        Crew other = (Crew) object;
        if ((this.idcrew == null && other.idcrew != null) || (this.idcrew != null && !this.idcrew.equals(other.idcrew))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.Crew[ idcrew=" + idcrew + " ]";
    }
    
}
