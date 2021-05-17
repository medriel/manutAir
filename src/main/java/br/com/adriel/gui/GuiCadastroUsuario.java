package br.com.adriel.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.adriel.dao.UsuarioDao;
import br.com.adriel.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiCadastroUsuario implements Initializable {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtCargo;

    @FXML
    private ListView<Usuario> lstUsuarios;

    private void preencherLista() {
        List<Usuario> usuarios = new UsuarioDao().getLista();

        ObservableList<Usuario> data = FXCollections.observableArrayList(usuarios);

        lstUsuarios.setItems(data);
    }

    @FXML
    private void btnCadastrarAction(ActionEvent event) {
        Usuario user = new Usuario(txtLogin.getText(), txtSenha.getText(), txtCargo.getText());

        try {
            new UsuarioDao().gravar(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        preencherLista();

    }

    @FXML
    private void btnRetornarAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiSupervisor.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Supervisor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) txtLogin.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherLista();

    }

}
