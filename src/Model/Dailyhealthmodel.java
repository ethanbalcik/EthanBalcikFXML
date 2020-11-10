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
@Table(name = "DAILYHEALTHMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Dailyhealthmodel.findAll", query = "SELECT d FROM Dailyhealthmodel d")
    , @NamedQuery(name = "Dailyhealthmodel.findByDailyhealthid", query = "SELECT d FROM Dailyhealthmodel d WHERE d.dailyhealthid = :dailyhealthid")
    , @NamedQuery(name = "Dailyhealthmodel.findByCarbohydrates", query = "SELECT d FROM Dailyhealthmodel d WHERE d.carbohydrates = :carbohydrates")
    , @NamedQuery(name = "Dailyhealthmodel.findByFats", query = "SELECT d FROM Dailyhealthmodel d WHERE d.fats = :fats")
    , @NamedQuery(name = "Dailyhealthmodel.findByProteins", query = "SELECT d FROM Dailyhealthmodel d WHERE d.proteins = :proteins")
    , @NamedQuery(name = "Dailyhealthmodel.findByMood", query = "SELECT d FROM Dailyhealthmodel d WHERE d.mood = :mood")
    , @NamedQuery(name = "Dailyhealthmodel.findByJournalentry", query = "SELECT d FROM Dailyhealthmodel d WHERE d.journalentry = :journalentry")
    , @NamedQuery(name = "Dailyhealthmodel.findByDate", query = "SELECT d FROM Dailyhealthmodel d WHERE d.date = :date")
})
public class Dailyhealthmodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DAILYHEALTHID")
    private Integer dailyhealthid;
    @Column(name = "CARBOHYDRATES")
    private Integer carbohydrates;
    @Column(name = "FATS")
    private Integer fats;
    @Column(name = "PROTEINS")
    private Integer proteins;
    @Column(name = "MOOD")
    private Integer mood;
    @Column(name = "JOURNALENTRY")
    private String journalentry;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Dailyhealthmodel()
    {
    }

    public Dailyhealthmodel(Integer dailyhealthid)
    {
        this.dailyhealthid = dailyhealthid;
    }

    public Integer getDailyhealthid()
    {
        return dailyhealthid;
    }

    public void setDailyhealthid(Integer dailyhealthid)
    {
        this.dailyhealthid = dailyhealthid;
    }

    public Integer getCarbohydrates()
    {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates)
    {
        this.carbohydrates = carbohydrates;
    }

    public Integer getFats()
    {
        return fats;
    }

    public void setFats(Integer fats)
    {
        this.fats = fats;
    }

    public Integer getProteins()
    {
        return proteins;
    }

    public void setProteins(Integer proteins)
    {
        this.proteins = proteins;
    }

    public Integer getMood()
    {
        return mood;
    }

    public void setMood(Integer mood)
    {
        this.mood = mood;
    }

    public String getJournalentry()
    {
        return journalentry;
    }

    public void setJournalentry(String journalentry)
    {
        this.journalentry = journalentry;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (dailyhealthid != null ? dailyhealthid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dailyhealthmodel))
        {
            return false;
        }
        Dailyhealthmodel other = (Dailyhealthmodel) object;
        if ((this.dailyhealthid == null && other.dailyhealthid != null) || (this.dailyhealthid != null && !this.dailyhealthid.equals(other.dailyhealthid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Dailyhealthmodel[ dailyhealthid=" + dailyhealthid + " ]";
    }
    
}
