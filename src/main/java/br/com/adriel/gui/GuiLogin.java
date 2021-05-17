package br.com.adriel.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.adriel.dao.UsuarioDao;
import br.com.adriel.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiLogin implements Initializable {

    @FXML
    private TextField txtLog;

    @FXML
    private PasswordField passSen;

    @FXML
    private void btnEntrarAction(ActionEvent event) {
        String login = txtLog.getText();
        String passwors = passSen.getText();
        Usuario usuario = new UsuarioDao().autenticar(txtLog.getText(), passSen.getText());
        Usuario.setLoginAtual(login);
        try {
            if (usuario.getCargo().equals("Supervisor")) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiSupervisor.fxml"));

                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/styles/Styles.css");

                    Stage stage = new Stage();
                    stage.setTitle("Supervisor");
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (usuario.getCargo().equals("Tecnico")) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiTecnico.fxml"));

                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/styles/Styles.css");

                    Stage stage = new Stage();
                    stage.setTitle("Tecnico");
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (usuario.getCargo().equals("Atendente")) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiAtendente.fxml"));

                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/styles/Styles.css");

                    Stage stage = new Stage();
                    stage.setTitle("Atendente");
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) txtLog.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Usuario user = new Usuario(txtLog.getText());
        user.setLoginAtual(user.getLogin());
    }

}
