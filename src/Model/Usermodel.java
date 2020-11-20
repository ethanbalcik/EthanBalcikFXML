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
@Table(name = "USERMODEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Usermodel.findAll", query = "SELECT u FROM Usermodel u")
    , @NamedQuery(name = "Usermodel.findByUserid", query = "SELECT u FROM Usermodel u WHERE u.userid = :userid")
    , @NamedQuery(name = "Usermodel.findByUsername", query = "SELECT u FROM Usermodel u WHERE u.username = :username")
    , @NamedQuery(name = "Usermodel.findByPassword", query = "SELECT u FROM Usermodel u WHERE u.password = :password")
    , @NamedQuery(name = "Usermodel.findByFirstname", query = "SELECT u FROM Usermodel u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Usermodel.findByLastname", query = "SELECT u FROM Usermodel u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Usermodel.findByEmail", query = "SELECT u FROM Usermodel u WHERE u.email = :email")
    , @NamedQuery(name = "Usermodel.findByDateofbirth", query = "SELECT u FROM Usermodel u WHERE u.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Usermodel.findByFullname", query = "SELECT u FROM Usermodel u WHERE u.firstname = :firstname and u.lastname = :lastname")
    , @NamedQuery(name = "Usermodel.findByUsernameAndEmail", query = "SELECT u FROM Usermodel u WHERE u.username = :username and u.email = :email")
    , @NamedQuery(name = "Usermodel.findByUsernameAdvanced", query = "SELECT u FROM Usermodel u WHERE u.username LIKE :username")
})
public class Usermodel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;

    public Usermodel()
    {
    }

    public Usermodel(Integer userid)
    {
        this.userid = userid;
    }

    public Usermodel(Integer userid, String username, String password)
    {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getDateofbirth()
    {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth)
    {
        this.dateofbirth = dateofbirth;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermodel))
        {
            return false;
        }
        Usermodel other = (Usermodel) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Model.Usermodel[ userid=" + userid + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", dateofbirth=" + dateofbirth.toString() + " ]";
    }
    
}
