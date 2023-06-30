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

public class Alunos extends Redirect{


    @FXML
    private AnchorPane containerAlunos;

    @FXML
    private TextField filtroAlunos;

    public void consultarAlunos(){
        String listaAlunos = this.getDados(filtroAlunos.getText());

        Label alunos = new Label(listaAlunos);

        containerAlunos.getChildren().clear();

        containerAlunos.getChildren().add(alunos);
    }

    public void listarAlunos () {
        String listaAlunos = this.getDados();

        Label alunos = new Label(listaAlunos);

        containerAlunos.getChildren().clear();

        containerAlunos.getChildren().add(alunos);
    }

    private String getDados(){
        return this.getDados("");
    }

    private String getDados(String filtro){
        StringBuilder  listaAlunos = new StringBuilder();

        try{
            File file = new File ("listaAlunos.csv");

            Scanner scanner = new Scanner(file);

            List<String[]> dados =  new ArrayList<>();


            while(scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                String[] valores = linha.split(",");

                dados.add(valores);
            }


            for(String[] linha : dados) {

                String registro = linha[1] + " - " + linha[0] ;

                if (!filtro.isEmpty() && !registro.toLowerCase().contains(filtro.toLowerCase()))
                    continue;

                listaAlunos.append(registro);

                listaAlunos.append("\n");
            }

        }catch (IOException e){

        }

        return listaAlunos.toString();
    }
}