/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Дмитрий
 */
@Entity
@Table(name = "pilot")
public class Pilot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idpilot")
    private Integer idpilot;
    
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "secondname")
    private String secondname;
    @OneToMany(mappedBy = "pilot2")
    private Collection<Crew> crewCollection;
    @OneToMany(mappedBy = "pilot1")
    private Collection<Crew> crewCollection1;

    public Pilot() {
    }

    public Pilot(Integer idpilot) {
        this.idpilot = idpilot;
    }

    public Integer getIdpilot() {
        return idpilot;
    }

    public void setIdpilot(Integer idpilot) {
        this.idpilot = idpilot;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @XmlTransient
    public Collection<Crew> getCrewCollection() {
        return crewCollection;
    }

    public void setCrewCollection(Collection<Crew> crewCollection) {
        this.crewCollection = crewCollection;
    }

    @XmlTransient
    public Collection<Crew> getCrewCollection1() {
        return crewCollection1;
    }

    public void setCrewCollection1(Collection<Crew> crewCollection1) {
        this.crewCollection1 = crewCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpilot != null ? idpilot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.idpilot == null && other.idpilot != null) || (this.idpilot != null && !this.idpilot.equals(other.idpilot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.Pilot[ idpilot=" + idpilot + " ]";
    }
    
}
