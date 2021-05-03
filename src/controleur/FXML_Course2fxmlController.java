/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * FXML Controller class
 *
 * @author professeur
 */
public class FXML_Course2fxmlController implements Initializable
{
    @FXML
    ComboBox ldrCourse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Client client = ClientBuilder.newClient();
        String url2 = "http://localhost:8080/WebServiceFBCN/webresources/course";
        WebTarget myResource = client.target(url2);
        String reponse = myResource.request(MediaType.APPLICATION_JSON).get(String.class);
        ObservableList<String> lesCourses = FXCollections.observableArrayList();
        
        try
        {
            JSONArray jtab = new JSONArray(reponse);
            for (int i = 0; i < jtab.length(); i++)
            {
                JSONObject objCourse = (JSONObject) jtab.get(i);
                String nom = objCourse.getString("nom");
                System.out.println("Nom:" + nom);
                lesCourses.add(nom);
            }
            ldrCourse.setItems(lesCourses);
        }
        catch (JSONException ex)
        {
            System.out.println("ERREUR PARSING JSON : " + ex.getMessage());
        }
        
    }    
    
    
}
