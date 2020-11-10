/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usermodel;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ebalc
 */
public class FXMLDocumentController implements Initializable
{
    private EntityManager entityManager;
    
    @FXML
    private Label label;

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void createUser(ActionEvent event)
    {
        //init Usermodel object
        Usermodel user = new Usermodel();
        Scanner scnr = new Scanner(System.in);
        
        //read userId from command line and set userId
        System.out.println("Input userId:");
        user.setUserid(new Integer(scnr.nextInt()));
        
        //read username from command line and set username
        System.out.println("Input username:");
        user.setUsername(scnr.next());
        
        //read password from command line and set password
        System.out.println("Input password:");
        user.setPassword(scnr.next());
        
        //read firstName from command line and set firstName
        System.out.println("Input firstName:");
        user.setFirstname(scnr.next());
        
        //read lastName from command line and set lastName
        System.out.println("Input lastName:");
        user.setLastname(scnr.next());
        
        //read email from command line and set email
        System.out.println("Input email:");
        user.setEmail(scnr.next());
        
        //read dateOfBirth components from command line
        //init date object and set dateOfBirth
        Date dob = new Date();
        System.out.println("Input birth month(0 to 11):");
        int month = scnr.nextInt();
        dob.setMonth(month);
        System.out.println("Input birth day(0 to 31):");
        int day = scnr.nextInt();
        dob.setDate(day);
        System.out.println("Input birth year:");
        int year = scnr.nextInt();
        dob.setYear(year);
        user.setDateofbirth(dob);
        
        //pass Usermodel object to create function
        create(user);
    }
    
    @FXML
    private void readAll(ActionEvent event)
    {
        //create query object using createNamedQuery from one of the named queries in Usermodel
        Query query = getEntityManager().createNamedQuery("Usermodel.findAll");
        
        //save the query's result list to a Usermodel list
        List<Usermodel> users = query.getResultList();
        
        //iterate through the list and print the Usermodel objects' toString() output
        for(Usermodel user : users)
        {
            System.out.println(user.toString());
        }
    }
    
    @FXML
    private void readUserByFullName(ActionEvent event)
    {
        //init Usermodel object
        Usermodel user = new Usermodel();
        Scanner scnr = new Scanner(System.in);
        
        //read firstname from command line and set user firstname
        System.out.println("Input firstName:");
        user.setFirstname(scnr.next());
        
        //read lastname from command line and set user lastname
        System.out.println("Input lastName:");
        user.setLastname(scnr.next());
        
        //pass user into readByFullName method
        //initialize user list to readByFullName method return value
        List<Usermodel> users = readByFullName(user);
        
        //iterate through the list and print the Usermodel objects' toString() output
        for(Usermodel u : users)
        {
            System.out.println(u.toString());
        }
    }
    
    @FXML
    private void readUserByUsernameAndEmail(ActionEvent event)
    {
        //init Usermodel object
        Usermodel user = new Usermodel();
        Scanner scnr = new Scanner(System.in);
        
        //read username from command line and set user firstname
        System.out.println("Input username:");
        user.setUsername(scnr.next());
        
        //read email from command line and set user email
        System.out.println("Input email:");
        user.setEmail(scnr.next());
        
        //pass user into readByUsernameAndEmail method
        //initialize user list to readByUsernameAndEmail method return value
        List<Usermodel> users = readByUsernameAndEmail(user);
        
        //iterate through the list and print the Usermodel objects' toString() output
        for(Usermodel u : users)
        {
            System.out.println(u.toString());
        }
    }
    
    @FXML
    private void updateUser(ActionEvent event)
    {
        //init Usermodel object
        Usermodel user = new Usermodel();
        Scanner scnr = new Scanner(System.in);
        
        //read userId from command line and set userId
        System.out.println("Input userId:");
        user.setUserid(new Integer(scnr.nextInt()));
        
        //read username from command line and set username
        System.out.println("Input username:");
        user.setUsername(scnr.next());
        
        //read password from command line and set password
        System.out.println("Input password:");
        user.setPassword(scnr.next());
        
        //read firstName from command line and set firstName
        System.out.println("Input firstName:");
        user.setFirstname(scnr.next());
        
        //read lastName from command line and set lastName
        System.out.println("Input lastName:");
        user.setLastname(scnr.next());
        
        //read email from command line and set email
        System.out.println("Input email:");
        user.setEmail(scnr.next());
        
        //read dateOfBirth components from command line
        //init date object and set dateOfBirth
        Date dob = new Date();
        System.out.println("Input birth month(0 to 11):");
        int month = scnr.nextInt();
        dob.setMonth(month);
        System.out.println("Input birth day(0 to 31):");
        int day = scnr.nextInt();
        dob.setDate(day);
        System.out.println("Input birth year:");
        int year = scnr.nextInt();
        dob.setYear(year);
        user.setDateofbirth(dob);
        
        //pass Usermodel object to update function
        update(user);
    }
    
    @FXML
    private void deleteUser(ActionEvent event)
    {
        //read userId integer from command line
        Scanner scnr = new Scanner(System.in);
        System.out.println("Input userId:");
        Integer userId = new Integer(scnr.nextInt());
        
        //pass userId integer to deleteById function
        deleteById(userId);
    }
    
    private void create(Usermodel user)
    {
        try
        {
            //begin transaction
            getEntityManager().getTransaction().begin();
            
            //check if user id is not null
            if(user.getUserid() != null)
            {
                getEntityManager().persist(user);
                getEntityManager().getTransaction().commit();
                System.out.println("User sent to database");
            }
            else
            {
                getEntityManager().getTransaction().commit();
                System.out.println("UserId was null");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    private List<Usermodel> readByFullName(Usermodel user)
    {
        //create query object using createNamedQuery from the findByFullName named query in Usermodel
        Query query = getEntityManager().createNamedQuery("Usermodel.findByFullname");
        query.setParameter("firstname", user.getFirstname());
        query.setParameter("lastname", user.getLastname());
        
        //save the query's result list to a Usermodel list
        List<Usermodel> users = query.getResultList();
        return users;
    }
    
    private List<Usermodel> readByUsernameAndEmail(Usermodel user)
    {
        //create query object using createNamedQuery from the findByUsernameAndEmail named query in Usermodel
        Query query = getEntityManager().createNamedQuery("Usermodel.findByUsernameAndEmail");
        query.setParameter("username", user.getUsername());
        query.setParameter("email", user.getEmail());
        
        //save the query's result list to a Usermodel list
        List<Usermodel> users = query.getResultList();
        return users;
    }
    
    private void update(Usermodel user)
    {
        try
        {
            //search for existing user in db
            Usermodel existingUser = getEntityManager().find(Usermodel.class, user.getUserid());
            
            //check if user id is not null
            if(user.getUserid() != null)
            {
                //begin transaction
                getEntityManager().getTransaction().begin();
                
                //set existing user attriburtes to user argument attributes
                existingUser.setUsername(user.getUsername());
                existingUser.setPassword(user.getPassword());
                existingUser.setFirstname(user.getFirstname());
                existingUser.setLastname(user.getLastname());
                existingUser.setEmail(user.getEmail());
                existingUser.setDateofbirth(user.getDateofbirth());
                
                //end transaction
                getEntityManager().getTransaction().commit();
                
                //print confirmation to command line
                System.out.println("User updated in database");
            }
            else
            {
                //print notification to command line
                System.out.println("UserId was null");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    private void deleteById(Integer userId)
    {
        try
        {
            //search for existing user in db
            Usermodel existingUser = getEntityManager().find(Usermodel.class, userId);
            
            //check if existing user is not null
            if(existingUser != null)
            {
                //begin transaction
                getEntityManager().getTransaction().begin();
                
                //remove existing user
                getEntityManager().remove(existingUser);
                
                //end transaction
                getEntityManager().getTransaction().commit();
                
                //print confirmation to command line
                System.out.println("User deleted");
            }
            else
            {
                //print notification to command line
                System.out.println("User was null");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setEntityManager((EntityManager) Persistence.createEntityManagerFactory("EthanBalcikFXMLPU").createEntityManager());
    }    
    
}
