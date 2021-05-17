package br.com.adriel.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GuiSupervisor implements Initializable {

    @FXML
    private Label lblTitulo;

    @FXML
    private void btnConsultarOSAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiConsultaOS.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Consulta de Ordens de Servico");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) lblTitulo.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnCadastrarUsuariosAction(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiCadastroUsuario.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Usuarios");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) lblTitulo.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btnConsultarOS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
