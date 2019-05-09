/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kf;

import com.kf.view.LoginController;
import com.kf.view.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Samuel
 */
public class MainApp extends Application {

    private Stage stage;
    private Stage mainDialog;

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Inicio de sesion");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));

            AnchorPane anchor = (AnchorPane) loader.load();
            Scene scene = new Scene(anchor);
            stage.setScene(scene);
            stage.setResizable(false);

            LoginController login = loader.getController();
            login.setStage(this);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));

            mainDialog = new Stage();
            mainDialog.setTitle("Knight Fight");
            mainDialog.initOwner(stage);
            mainDialog.initModality(Modality.WINDOW_MODAL);

            BorderPane border = (BorderPane) loader.load();
            Scene scene = new Scene(border);
            mainDialog.setScene(scene);
            mainDialog.setResizable(false);

            MainController main = loader.getController();
            main.setMainApp(this);
            main.setDialog(mainDialog);

            stage.hide();
            mainDialog.showAndWait();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
