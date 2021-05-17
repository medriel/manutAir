package br.com.adriel.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.adriel.dao.CadastroOSDao;
import br.com.adriel.dao.ContratoDao;
import br.com.adriel.model.CadastroOS;
import br.com.adriel.model.Contrato;
import br.com.adriel.model.Equipamento;
import br.com.adriel.model.EquipamentoLista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiCadastroOS implements Initializable {
    @FXML
    private ComboBox cbContrato;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private ComboBox cbEquipamento;

    @FXML
    private void btnCarregarAction(ActionEvent event) {
        Contrato contrato = (Contrato) cbContrato.getSelectionModel().getSelectedItem();
        cbEquipamento.getItems().clear();
        cbEquipamento.getItems().addAll(contrato.getEquipamento());
    }

    @FXML
    private void btnCadastrarAction(ActionEvent event) {
        Contrato contrato = (Contrato) cbContrato.getSelectionModel().getSelectedItem();
        String endereco = txtEndereco.getText();
        String descricao = txtDescricao.getText();

        Equipamento equipamento = (Equipamento) cbEquipamento.getSelectionModel().getSelectedItem();
        CadastroOS cadastroOS = new CadastroOS(contrato, endereco, equipamento, descricao);
        cadastroOS.atualizarStatus("OS Aberta");

        new CadastroOSDao().gravar(cadastroOS);
    }

    @FXML
    private void btnRetornarAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiAtendente.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Supervisor");
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
        List<Contrato> a = new ContratoDao().getLista();
        cbContrato.getItems().clear();
        cbContrato.getItems().addAll(a);

    }

}
