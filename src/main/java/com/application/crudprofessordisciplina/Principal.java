package com.application.crudprofessordisciplina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Principal extends Application {
    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TabPane tabPane= (TabPane)FXMLLoader.load(this.getClass().getResource("Principal.fxml"));
        Scene scene=new Scene(tabPane);
        stage.setScene(scene);
        stage.setTitle("CRUD Professor Disciplina");
        stage.show();
    }
}
