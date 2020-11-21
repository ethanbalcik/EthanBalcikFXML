/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usermodel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ebalc
 */
public class DetailedModelController implements Initializable
{
    @FXML
    private Label usernameLabel;
    @FXML
    private Label userIdLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ImageView userPhotoDisplay;
    @FXML
    private Button backButton;

    public Label getUsernameLabel()
    {
        return usernameLabel;
    }

    public void setUsernameLabel(Label usernameLabel)
    {
        this.usernameLabel = usernameLabel;
    }

    public Label getUserIdLabel()
    {
        return userIdLabel;
    }

    public void setUserIdLabel(Label userIdLabel)
    {
        this.userIdLabel = userIdLabel;
    }

    public Label getFirstnameLabel()
    {
        return firstnameLabel;
    }

    public void setFirstnameLabel(Label firstnameLabel)
    {
        this.firstnameLabel = firstnameLabel;
    }

    public Label getLastnameLabel()
    {
        return lastnameLabel;
    }

    public void setLastnameLabel(Label lastnameLabel)
    {
        this.lastnameLabel = lastnameLabel;
    }

    public Label getDateOfBirthLabel()
    {
        return dateOfBirthLabel;
    }

    public void setDateOfBirthLabel(Label dateOfBirthLabel)
    {
        this.dateOfBirthLabel = dateOfBirthLabel;
    }

    public Label getEmailLabel()
    {
        return emailLabel;
    }

    public void setEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    public ImageView getUserPhotoDisplay()
    {
        return userPhotoDisplay;
    }

    public void setUserPhotoDisplay(ImageView userPhotoDisplay)
    {
        this.userPhotoDisplay = userPhotoDisplay;
    }

    public Button getBackButton()
    {
        return backButton;
    }

    public void setBackButton(Button backButton)
    {
        this.backButton = backButton;
    }
    
    @FXML
    public void toSearch(ActionEvent event)
    {
        try
        {
            //Load FXML detail view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLDocument.fxml"));
            Parent searchView = loader.load();

            //Instantiate scene, give it the parent we instantiated, also get current scene from event source
            Scene searchScene = new Scene(searchView);
            Scene currentScene = ((Node)event.getSource()).getScene();

            //Get the controller, init selected user data
            FXMLDocumentController controller = loader.getController();

            //Instantiate new stage, give it the scene we instantiated, set visible
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(searchScene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void initUserData(Usermodel user)
    {
        getUserPhotoDisplay().setImage(new Image("/Resources/Images/20_IST311_Profile_Icon_emb71.png"));
        getUsernameLabel().setText(user.getUsername());
        getUserIdLabel().setText(String.format("%d", user.getUserid()));
        getFirstnameLabel().setText(user.getFirstname());
        getLastnameLabel().setText(user.getLastname());
        getEmailLabel().setText(user.getEmail());
        getDateOfBirthLabel().setText(String.format("%d/%d/%d", user.getDateofbirth().getMonth(), user.getDateofbirth().getDay(), user.getDateofbirth().getYear()));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
