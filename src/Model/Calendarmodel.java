/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ebalc
 */
@Entity
@Table(name = "CALENDARMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Calendarmodel.findAll", query = "SELECT c FROM Calendarmodel c")
    , @NamedQuery(name = "Calendarmodel.findByCalendarid", query = "SELECT c FROM Calendarmodel c WHERE c.calendarid = :calendarid")
    , @NamedQuery(name = "Calendarmodel.findByCurrentdate", query = "SELECT c FROM Calendarmodel c WHERE c.currentdate = :currentdate")
    , @NamedQuery(name = "Calendarmodel.findByTimescope", query = "SELECT c FROM Calendarmodel c WHERE c.timescope = :timescope")
    , @NamedQuery(name = "Calendarmodel.findByTimeindex", query = "SELECT c FROM Calendarmodel c WHERE c.timeindex = :timeindex")
})
public class Calendarmodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CALENDARID")
    private Integer calendarid;
    @Column(name = "CURRENTDATE")
    @Temporal(TemporalType.DATE)
    private Date currentdate;
    @Column(name = "TIMESCOPE")
    private Integer timescope;
    @Column(name = "TIMEINDEX")
    private Integer timeindex;

    public Calendarmodel()
    {
    }

    public Calendarmodel(Integer calendarid)
    {
        this.calendarid = calendarid;
    }

    public Integer getCalendarid()
    {
        return calendarid;
    }

    public void setCalendarid(Integer calendarid)
    {
        this.calendarid = calendarid;
    }

    public Date getCurrentdate()
    {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate)
    {
        this.currentdate = currentdate;
    }

    public Integer getTimescope()
    {
        return timescope;
    }

    public void setTimescope(Integer timescope)
    {
        this.timescope = timescope;
    }

    public Integer getTimeindex()
    {
        return timeindex;
    }

    public void setTimeindex(Integer timeindex)
    {
        this.timeindex = timeindex;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (calendarid != null ? calendarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendarmodel))
        {
            return false;
        }
        Calendarmodel other = (Calendarmodel) object;
        if ((this.calendarid == null && other.calendarid != null) || (this.calendarid != null && !this.calendarid.equals(other.calendarid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Calendarmodel[ calendarid=" + calendarid + " ]";
    }
    
}
