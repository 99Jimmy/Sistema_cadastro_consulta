package br.unip.aps;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Redirect {


    @FXML
    protected void redirect(String pagina, ActionEvent event) {
        this.redirect(pagina, event, 600, 400);
    }

    @FXML
    protected void redirect(String pagina, ActionEvent event, int width, int height){
        try {
            FXMLLoader loader = new FXMLLoader(Application.class.getResource(pagina));
            Scene scene = new Scene(loader.load(), width, height);

            Button btn = (Button) event.getSource();

            Stage stage = (Stage) btn.getScene().getWindow();

            stage.setScene(scene);

        }catch (IOException e) {

        }

    }

    public void redirectIndex(ActionEvent event){
        this.redirect ("index.fxml", event, 400, 400);
    }

    public void redirectAlunos(ActionEvent event) {
        this.redirect("paginas/alunos.fxml", event);
    }


    public void redirectCursos(ActionEvent event){
        this.redirect("paginas/cursos.fxml", event);
    }

    public void redirectNovoAluno(ActionEvent event){
        this.redirect("paginas/novoAluno.fxml", event, 400, 400);
    }

    public void redirectNovoCurso(ActionEvent event){
        this.redirect("paginas/novoCurso.fxml", event, 400, 400);
    }
}
