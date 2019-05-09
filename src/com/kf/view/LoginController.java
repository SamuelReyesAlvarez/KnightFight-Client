/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kf.view;

import com.kf.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class LoginController implements Initializable {

    @FXML
    private TextField etCorreo;
    @FXML
    private PasswordField etClave;
    @FXML
    private Label error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setStage(MainApp stage) {

    }

    @FXML
    private void conectar() {

    }

    @FXML
    private void recuperarClave() {

    }
}
