package br.unip.aps;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("index.fxml"));
            Scene scene = new Scene(loader.load(), 400, 400);
            stage.setTitle("Título");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){

        }
    }

    public static void main(String[] args) {
        launch();
    }
}