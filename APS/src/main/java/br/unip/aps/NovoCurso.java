package br.unip.aps;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NovoCurso extends Redirect implements Initializable {

    @FXML
    private Label resultado;
    @FXML
    private TextField nomeCurso;
    @FXML
    private ChoiceBox<String> tiposCurso;
    @FXML
    private DatePicker dataCurso;
    private String[] tipos = {"Bacharelado", "Licenciatura", "Tecnólogo"};


    @Override
    public void initialize(URL arg1, ResourceBundle arg2){
        tiposCurso.getItems().addAll(tipos);
    }


    @FXML
    private void registrarCurso() {


        String nome = nomeCurso.getText();
        String tipo = tiposCurso.getValue();
        LocalDate data = dataCurso.getValue();

        if(nome.isEmpty() || tipo == null || data == null){
            resultado.setTextFill(Color.RED);
            resultado.setText("Preencha todos os campos");
            return;
        }

        int id = this.getId();

        String curso = nome + "," + tipo + "," + data;

        if(!this.cursoExistente(curso)){

            try {
                FileWriter writer = new FileWriter("listaCursos.csv", true);

                writer.write( id + "," + curso + "\n");
                writer.close();
            }
            catch (IOException e){
            }

            resultado.setTextFill(Color.BLACK);
            resultado.setText("O curso foi registrado com sucesso!");
        }else{
            resultado.setTextFill(Color.RED);
            resultado.setText("Curso já existente");
        }

    }

    private boolean cursoExistente(String curso){

        try{
            File file = new File ("listaCursos.csv");

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String registro = scanner.nextLine();

                if(registro.toLowerCase().contains(curso.toLowerCase()))
                    return true;
            }

        }catch (IOException e){

        }

        return false;
    }

    private int getId (){
        int id = 0;

        try{
            File file = new File ("listaCursos.csv");

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String registro = scanner.nextLine();

                String[] valores = registro.split(",");

                if(Integer.parseInt(valores[0]) >= id)
                    id++;
            }

        }catch (IOException e){

        }

        return id;
    }
}
