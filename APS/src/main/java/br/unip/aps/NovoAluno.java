package br.unip.aps;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NovoAluno extends Redirect{


    @FXML
    private Label resultado;
    @FXML
    private TextField nomeAluno;
    @FXML
    private TextField idAluno;


    @FXML
    public void registrarAluno() {


        String nome = nomeAluno.getText();
        String id   = idAluno.getText();

        String aluno = id + "," + nome;

        if(nome.isEmpty() || id.isEmpty()){
            resultado.setTextFill(Color.RED);
            resultado.setText("Preencha todos os campos");
            return;
        }


        if(!this.alunoExistente(id)){

            try {
                FileWriter writer = new FileWriter("listaAlunos.csv", true);

                writer.write( aluno + "\n");
                writer.close();
            }
            catch (IOException e){
            }

            resultado.setTextFill(Color.BLACK);
            resultado.setText("O aluno foi registrado com sucesso!");
        }else{
            resultado.setTextFill(Color.RED);
            resultado.setText("Aluno já existente");
        }
    }

    private boolean alunoExistente(String id){

        try{
            File file = new File ("listaAlunos.csv");

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String registro = scanner.nextLine();

                String[] valores = registro.split(",");

                if(valores[0].toLowerCase().contains(id.toLowerCase()))
                    return true;
            }

        }catch (IOException e){

        }

        return false;
    }
}
