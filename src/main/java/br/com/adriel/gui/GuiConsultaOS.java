package br.com.adriel.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.adriel.dao.CadastroOSDao;
import br.com.adriel.dao.UsuarioDao;
import br.com.adriel.model.CadastroOS;
import br.com.adriel.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiConsultaOS implements Initializable {

    @FXML
    private ComboBox cbOrdemServico;

    @FXML
    private ComboBox cbTecnico;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtHora;

    @FXML
    private void btnCarregarAction(ActionEvent event) {
        List<Usuario> tecnicos = new UsuarioDao().buscarTecnico();
        cbTecnico.getItems().clear();
        cbTecnico.getItems().addAll(tecnicos);
    }

    @FXML
    private void btnAlocarAction(ActionEvent event) {
        CadastroOS osAtual = (CadastroOS) cbOrdemServico.getSelectionModel().getSelectedItem();
        Usuario tecnicoAtual = (Usuario) cbTecnico.getSelectionModel().getSelectedItem();
        osAtual.alocarTecnico(tecnicoAtual);
        osAtual.atribuirDataHora(txtData.getText(), txtHora.getText());
        osAtual.atualizarStatus("Em andamento");

        new CadastroOSDao().atualizar(osAtual, tecnicoAtual, txtData.getText(), txtHora.getText(), "Em andamento");
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

        Stage stage = (Stage) txtData.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<CadastroOS> a = new CadastroOSDao().buscarOSStatus("OS Aberta");
        cbOrdemServico.getItems().clear();
        cbOrdemServico.getItems().addAll(a);

    }

}
