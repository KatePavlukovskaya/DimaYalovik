/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.entity;

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


@Table(name = "flight")

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idflight")
    private Integer idflight;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "time_arrivals")
    @Temporal(TemporalType.TIME)
    private Date timeArrivals;
    @Basic(optional = false)
    @Column(name = "time_sortie")
    @Temporal(TemporalType.TIME)
    private Date timeSortie;
    @Basic(optional = false)
    @Column(name = "date_begin")
    @Temporal(TemporalType.DATE)
    private Date dateBegin;
    @Basic(optional = false)
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @JoinColumn(name = "days", referencedColumnName = "iddays")
    @ManyToOne(optional = false)
    private Days days;
    @JoinColumn(name = "city_otpr", referencedColumnName = "idcity")
    @ManyToOne(optional = false)
    private City cityOtpr;
    @JoinColumn(name = "city_prib", referencedColumnName = "idcity")
    @ManyToOne(optional = false)
    private City cityPrib;

    public Flight() {
    }

    public Flight(Integer idflight) {
        this.idflight = idflight;
    }

    public Flight(Integer idflight, String name, Date timeArrivals, Date timeSortie, Date dateBegin, Date dateEnd) {
        this.idflight = idflight;
        this.name = name;
        this.timeArrivals = timeArrivals;
        this.timeSortie = timeSortie;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public Integer getIdflight() {
        return idflight;
    }

    public void setIdflight(Integer idflight) {
        this.idflight = idflight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeArrivals() {
        return timeArrivals;
    }

    public void setTimeArrivals(Date timeArrivals) {
        this.timeArrivals = timeArrivals;
    }

    public Date getTimeSortie() {
        return timeSortie;
    }

    public void setTimeSortie(Date timeSortie) {
        this.timeSortie = timeSortie;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public City getCityOtpr() {
        return cityOtpr;
    }

    public void setCityOtpr(City cityOtpr) {
        this.cityOtpr = cityOtpr;
    }

    public City getCityPrib() {
        return cityPrib;
    }

    public void setCityPrib(City cityPrib) {
        this.cityPrib = cityPrib;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflight != null ? idflight.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.idflight == null && other.idflight != null) || (this.idflight != null && !this.idflight.equals(other.idflight))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.entity.Flight[ idflight=" + idflight + " ]";
    }
    
}
