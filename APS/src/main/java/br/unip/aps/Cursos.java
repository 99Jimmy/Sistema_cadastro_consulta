package br.unip.aps;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cursos extends Redirect {


    @FXML
    private AnchorPane containerCursos;

    @FXML
    private TextField filtroCursos;

    public void consultarCursos(){
        String listaCursos = this.getDados(filtroCursos.getText());

        Label cursos = new Label(listaCursos);

        containerCursos.getChildren().clear();

        containerCursos.getChildren().add(cursos);
    }

    public void listarCursos () {
        String listaCursos = this.getDados();

        Label cursos = new Label(listaCursos);

        containerCursos.getChildren().clear();

        containerCursos.getChildren().add(cursos);
    }

    private String getDados(){
        return this.getDados("");
    }

    private String getDados(String filtro){
        StringBuilder  listaCursos = new StringBuilder();

        try{
            File file = new File ("listaCursos.csv");

            Scanner scanner = new Scanner(file);

            List<String[]> dados =  new ArrayList<>();


            while(scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                String[] valores = linha.split(",");

                dados.add(valores);
            }


            for(String[] linha : dados) {

                String registro = linha[1] + " (" + linha[2] + ") - " + linha[3];

                if (!filtro.isEmpty() && !registro.toLowerCase().contains(filtro.toLowerCase()))
                    continue;

                listaCursos.append(registro);

                listaCursos.append("\n");
            }

        }catch (IOException e){

        }

        return listaCursos.toString();
    }
}
