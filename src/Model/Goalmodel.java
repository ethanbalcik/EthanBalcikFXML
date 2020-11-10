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
@Table(name = "GOALMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Goalmodel.findAll", query = "SELECT g FROM Goalmodel g")
    , @NamedQuery(name = "Goalmodel.findByGoalid", query = "SELECT g FROM Goalmodel g WHERE g.goalid = :goalid")
    , @NamedQuery(name = "Goalmodel.findByGoalname", query = "SELECT g FROM Goalmodel g WHERE g.goalname = :goalname")
    , @NamedQuery(name = "Goalmodel.findByGoaldescription", query = "SELECT g FROM Goalmodel g WHERE g.goaldescription = :goaldescription")
    , @NamedQuery(name = "Goalmodel.findByDeadline", query = "SELECT g FROM Goalmodel g WHERE g.deadline = :deadline")
    , @NamedQuery(name = "Goalmodel.findByColor", query = "SELECT g FROM Goalmodel g WHERE g.color = :color")
})
public class Goalmodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GOALID")
    private Integer goalid;
    @Basic(optional = false)
    @Column(name = "GOALNAME")
    private String goalname;
    @Column(name = "GOALDESCRIPTION")
    private String goaldescription;
    @Column(name = "DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Column(name = "COLOR")
    private Boolean color;

    public Goalmodel()
    {
    }

    public Goalmodel(Integer goalid)
    {
        this.goalid = goalid;
    }

    public Goalmodel(Integer goalid, String goalname)
    {
        this.goalid = goalid;
        this.goalname = goalname;
    }

    public Integer getGoalid()
    {
        return goalid;
    }

    public void setGoalid(Integer goalid)
    {
        this.goalid = goalid;
    }

    public String getGoalname()
    {
        return goalname;
    }

    public void setGoalname(String goalname)
    {
        this.goalname = goalname;
    }

    public String getGoaldescription()
    {
        return goaldescription;
    }

    public void setGoaldescription(String goaldescription)
    {
        this.goaldescription = goaldescription;
    }

    public Date getDeadline()
    {
        return deadline;
    }

    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }

    public Boolean getColor()
    {
        return color;
    }

    public void setColor(Boolean color)
    {
        this.color = color;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (goalid != null ? goalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goalmodel))
        {
            return false;
        }
        Goalmodel other = (Goalmodel) object;
        if ((this.goalid == null && other.goalid != null) || (this.goalid != null && !this.goalid.equals(other.goalid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Goalmodel[ goalid=" + goalid + " ]";
    }
    
}
