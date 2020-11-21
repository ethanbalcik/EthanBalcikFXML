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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    private TextField usernameField;
    @FXML
    private TableView<Usermodel> userTable;
    @FXML
    private TableColumn<Usermodel, Integer> idColumn;
    @FXML
    private TableColumn<Usermodel, String> usernameColumn;
    @FXML
    private TableColumn<Usermodel, String> firstnameColumn;
    @FXML
    private TableColumn<Usermodel, String> lastnameColumn;
    @FXML
    private TableColumn<Usermodel, String> emailColumn;
    @FXML
    private TableColumn<Usermodel, Date> dateOfBirthColumn;

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public TextField getUsernameField()
    {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField)
    {
        this.usernameField = usernameField;
    }

    public TableView<Usermodel> getUserTable()
    {
        return userTable;
    }

    public void setUserTable(TableView<Usermodel> userTable)
    {
        this.userTable = userTable;
    }

    public TableColumn<Usermodel, Integer> getIdColumn()
    {
        return idColumn;
    }

    public void setIdColumn(TableColumn<Usermodel, Integer> idColumn)
    {
        this.idColumn = idColumn;
    }

    public TableColumn<Usermodel, String> getUsernameColumn()
    {
        return usernameColumn;
    }

    public void setUsernameColumn(TableColumn<Usermodel, String> usernameColumn)
    {
        this.usernameColumn = usernameColumn;
    }

    public TableColumn<Usermodel, String> getFirstnameColumn()
    {
        return firstnameColumn;
    }

    public void setFirstnameColumn(TableColumn<Usermodel, String> firstnameColumn)
    {
        this.firstnameColumn = firstnameColumn;
    }

    public TableColumn<Usermodel, String> getLastnameColumn()
    {
        return lastnameColumn;
    }

    public void setLastnameColumn(TableColumn<Usermodel, String> lastnameColumn)
    {
        this.lastnameColumn = lastnameColumn;
    }

    public TableColumn<Usermodel, String> getEmailColumn()
    {
        return emailColumn;
    }

    public void setEmailColumn(TableColumn<Usermodel, String> emailColumn)
    {
        this.emailColumn = emailColumn;
    }

    public TableColumn<Usermodel, Date> getDateOfBirthColumn()
    {
        return dateOfBirthColumn;
    }

    public void setDateOfBirthColumn(TableColumn<Usermodel, Date> dateOfBirthColumn)
    {
        this.dateOfBirthColumn = dateOfBirthColumn;
    }
    
    @FXML
    public void searchUsers()
    {
        //Read text in search input field
        String searchInput = getUsernameField().getText();
        
        //Create query based on input
        Query query = getEntityManager().createNamedQuery("Usermodel.findByUsername");
        query.setParameter("username", searchInput);
        
        //Save the query's result list to a Usermodel list
        List<Usermodel> users = query.getResultList();
        
        //Initialize ObservableList and add users to it
        ObservableList<Usermodel> userData = FXCollections.observableArrayList();
        for(Usermodel u : users)
        {
            userData.add(u);
        }
        
        //Set ObservableList as the TableView items list
        getUserTable().setItems(userData);
        getUserTable().refresh();
    }
    
    @FXML
    public void advancedSearchUsers()
    {
        //Read text in search input field
        String searchInput = getUsernameField().getText();
        
        //Add wildcard
        searchInput += "%";
        
        //Create query based on input
        Query query = getEntityManager().createNamedQuery("Usermodel.findByUsernameAdvanced");
        query.setParameter("username", searchInput);
        
        //Save the query's result list to a Usermodel list
        List<Usermodel> users = query.getResultList();
        
        //Initialize ObservableList and add users to it
        ObservableList<Usermodel> userData = FXCollections.observableArrayList();
        for(Usermodel u : users)
        {
            userData.add(u);
        }
        
        //Set ObservableList as the TableView items list
        getUserTable().setItems(userData);
        getUserTable().refresh();
    }
    
    @FXML
    public void showDetails()
    {
        try
        {
            //Get selected user
            Usermodel selectedUser = getUserTable().getSelectionModel().getSelectedItem();
            
            //Load FXML detail view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DetailedModelView.fxml"));
            Parent detailView = loader.load();
            
            //Instantiate scene, give it the parent we instantiated
            Scene scene = new Scene(detailView);
            
            //Get the controller, init selected user data
            DetailedModelController controller = loader.getController();
            controller.initUserData(selectedUser);
            
            //Deactivate back button
            controller.getBackButton().setVisible(false);
            
            //Instantiate new stage, give it the scene we instantiated, set visible
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void showDetailsInPlace(ActionEvent event)
    {
        try
        {
            //Get selected user
            Usermodel selectedUser = getUserTable().getSelectionModel().getSelectedItem();
            
            //Load FXML detail view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DetailedModelView.fxml"));
            Parent detailView = loader.load();
            
            //Instantiate scene, give it the parent we instantiated, also get current scene from event source
            Scene detailScene = new Scene(detailView);
            Scene currentScene = ((Node)event.getSource()).getScene();
            
            //Get the controller, init selected user data
            DetailedModelController controller = loader.getController();
            controller.initUserData(selectedUser);
            
            //Instantiate new stage, give it the scene we instantiated, set visible
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(detailScene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Initialize EntityManager
        setEntityManager((EntityManager) Persistence.createEntityManagerFactory("EthanBalcikFXMLPU").createEntityManager());
        
        //Initialize TableColumns
        getIdColumn().setCellValueFactory(new PropertyValueFactory<>("userid"));
        getUsernameColumn().setCellValueFactory(new PropertyValueFactory<>("username"));
        getFirstnameColumn().setCellValueFactory(new PropertyValueFactory<>("firstname"));
        getLastnameColumn().setCellValueFactory(new PropertyValueFactory<>("lastname"));
        getEmailColumn().setCellValueFactory(new PropertyValueFactory<>("email"));
        getDateOfBirthColumn().setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
    }    
    
}
