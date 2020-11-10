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
@Table(name = "OBJECTIVEMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Objectivemodel.findAll", query = "SELECT o FROM Objectivemodel o")
    , @NamedQuery(name = "Objectivemodel.findByObjectiveid", query = "SELECT o FROM Objectivemodel o WHERE o.objectiveid = :objectiveid")
    , @NamedQuery(name = "Objectivemodel.findByObjectivename", query = "SELECT o FROM Objectivemodel o WHERE o.objectivename = :objectivename")
    , @NamedQuery(name = "Objectivemodel.findByObjectivedescription", query = "SELECT o FROM Objectivemodel o WHERE o.objectivedescription = :objectivedescription")
    , @NamedQuery(name = "Objectivemodel.findByDeadline", query = "SELECT o FROM Objectivemodel o WHERE o.deadline = :deadline")
    , @NamedQuery(name = "Objectivemodel.findByColor", query = "SELECT o FROM Objectivemodel o WHERE o.color = :color")
})
public class Objectivemodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OBJECTIVEID")
    private Integer objectiveid;
    @Basic(optional = false)
    @Column(name = "OBJECTIVENAME")
    private String objectivename;
    @Column(name = "OBJECTIVEDESCRIPTION")
    private String objectivedescription;
    @Column(name = "DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Basic(optional = false)
    @Column(name = "COLOR")
    private int color;

    public Objectivemodel()
    {
    }

    public Objectivemodel(Integer objectiveid)
    {
        this.objectiveid = objectiveid;
    }

    public Objectivemodel(Integer objectiveid, String objectivename, int color)
    {
        this.objectiveid = objectiveid;
        this.objectivename = objectivename;
        this.color = color;
    }

    public Integer getObjectiveid()
    {
        return objectiveid;
    }

    public void setObjectiveid(Integer objectiveid)
    {
        this.objectiveid = objectiveid;
    }

    public String getObjectivename()
    {
        return objectivename;
    }

    public void setObjectivename(String objectivename)
    {
        this.objectivename = objectivename;
    }

    public String getObjectivedescription()
    {
        return objectivedescription;
    }

    public void setObjectivedescription(String objectivedescription)
    {
        this.objectivedescription = objectivedescription;
    }

    public Date getDeadline()
    {
        return deadline;
    }

    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (objectiveid != null ? objectiveid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objectivemodel))
        {
            return false;
        }
        Objectivemodel other = (Objectivemodel) object;
        if ((this.objectiveid == null && other.objectiveid != null) || (this.objectiveid != null && !this.objectiveid.equals(other.objectiveid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Objectivemodel[ objectiveid=" + objectiveid + " ]";
    }
    
}
