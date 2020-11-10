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
@Table(name = "EVENTMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Eventmodel.findAll", query = "SELECT e FROM Eventmodel e")
    , @NamedQuery(name = "Eventmodel.findByEventid", query = "SELECT e FROM Eventmodel e WHERE e.eventid = :eventid")
    , @NamedQuery(name = "Eventmodel.findByEventname", query = "SELECT e FROM Eventmodel e WHERE e.eventname = :eventname")
    , @NamedQuery(name = "Eventmodel.findByEventdescription", query = "SELECT e FROM Eventmodel e WHERE e.eventdescription = :eventdescription")
    , @NamedQuery(name = "Eventmodel.findByStarttime", query = "SELECT e FROM Eventmodel e WHERE e.starttime = :starttime")
    , @NamedQuery(name = "Eventmodel.findByDuration", query = "SELECT e FROM Eventmodel e WHERE e.duration = :duration")
    , @NamedQuery(name = "Eventmodel.findByColor", query = "SELECT e FROM Eventmodel e WHERE e.color = :color")
})
public class Eventmodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EVENTID")
    private Integer eventid;
    @Basic(optional = false)
    @Column(name = "EVENTNAME")
    private String eventname;
    @Column(name = "EVENTDESCRIPTION")
    private String eventdescription;
    @Basic(optional = false)
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.DATE)
    private Date starttime;
    @Basic(optional = false)
    @Column(name = "DURATION")
    private int duration;
    @Column(name = "COLOR")
    private Integer color;

    public Eventmodel()
    {
    }

    public Eventmodel(Integer eventid)
    {
        this.eventid = eventid;
    }

    public Eventmodel(Integer eventid, String eventname, Date starttime, int duration)
    {
        this.eventid = eventid;
        this.eventname = eventname;
        this.starttime = starttime;
        this.duration = duration;
    }

    public Integer getEventid()
    {
        return eventid;
    }

    public void setEventid(Integer eventid)
    {
        this.eventid = eventid;
    }

    public String getEventname()
    {
        return eventname;
    }

    public void setEventname(String eventname)
    {
        this.eventname = eventname;
    }

    public String getEventdescription()
    {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription)
    {
        this.eventdescription = eventdescription;
    }

    public Date getStarttime()
    {
        return starttime;
    }

    public void setStarttime(Date starttime)
    {
        this.starttime = starttime;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public Integer getColor()
    {
        return color;
    }

    public void setColor(Integer color)
    {
        this.color = color;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventmodel))
        {
            return false;
        }
        Eventmodel other = (Eventmodel) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Eventmodel[ eventid=" + eventid + " ]";
    }
    
}
