/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kf.view;

import com.kf.MainApp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class LoginController implements Initializable {

    private static final String HOST = "localhost";
    private static final int PORT = 54321;

    @FXML
    private TextField mailTxF;
    @FXML
    private PasswordField pswdPwF;
    @FXML
    private Label errorLbl;

    private MainApp mainApp;

    public LoginController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLbl.setVisible(false);
        mailTxF.focusedProperty()
                .addListener(((observable, oldValue, newValue) -> {
                    if (newValue) {
                        errorLbl.setVisible(false);
                    }
                }));
        pswdPwF.focusedProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        errorLbl.setVisible(false);
                    }
                });
    }

    public void setStage(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void connect() {
        try {
            Socket client = new Socket(HOST, PORT);

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("login~" + mailTxF.getText().trim() + "~" + pswdPwF.getText().trim());

            DataInputStream in = new DataInputStream(client.getInputStream());
            String validation = in.readUTF();

            if (validation.equals("1")) {
                JOptionPane.showMessageDialog(null, "Conectado satisfactoriamente");
                //mainApp.showMainView();
            } else {
                errorLbl.setVisible(true);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Imposible conectar con el servidor \n\n"
                    + ex.getMessage(), "<< Error de conexion >>", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void recoverPassword() {

    }
}
