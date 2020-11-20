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

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    
    @FXML
    public void searchUsers()
    {
        System.out.println("Clicked!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setEntityManager((EntityManager) Persistence.createEntityManagerFactory("EthanBalcikFXMLPU").createEntityManager());
    }    
    
}
