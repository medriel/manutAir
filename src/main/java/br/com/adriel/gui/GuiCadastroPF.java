package br.com.adriel.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.adriel.dao.ClientePFDao;
import br.com.adriel.model.ClientePF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiCadastroPF implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtCpf;

    @FXML
    private void btnCadastrarAction(ActionEvent event) {
        try {
            ClientePF clientepf = new ClientePF(txtNome.getText(), txtTelefone.getText(), txtEndereco.getText(),
                    txtCpf.getText());

            new ClientePFDao().gravar(clientepf);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiCadastroEquipamentos.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Cadastrar Equipamentos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) txtEndereco.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnRetornarAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiAtendente.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Contratos");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) txtEndereco.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
