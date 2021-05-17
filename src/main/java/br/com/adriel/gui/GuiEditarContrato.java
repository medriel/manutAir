package br.com.adriel.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.adriel.dao.ContratoDao;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiEditarContrato implements Initializable {

    @FXML
    private ComboBox cbContrato;

    @FXML
    private ComboBox cbEquipamento;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtSn;

    @FXML
    private void btnCarregarAction(ActionEvent event) {
        Contrato contrato = (Contrato) cbContrato.getSelectionModel().getSelectedItem();
        cbEquipamento.getItems().clear();
        cbEquipamento.getItems().addAll(contrato.getEquipamento());
    }

    @FXML
    private void btnEditarAction(ActionEvent event) {
        Equipamento equipamento = (Equipamento) cbEquipamento.getSelectionModel().getSelectedItem();
        txtMarca.setText(equipamento.getMarca());
        txtModelo.setText(equipamento.getModelo());
        txtSn.setText(equipamento.getSn());
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) throws Exception {
        Equipamento equipamento = (Equipamento) cbEquipamento.getSelectionModel().getSelectedItem();
        if (equipamento == null)
            throw new Exception("Equipamento nao informado");

        new EquipamentoLista().removerEquipamento(equipamento);

        Equipamento equipamentoAtual = new Equipamento(txtMarca.getText(), txtModelo.getText(), txtSn.getText());
        new EquipamentoLista().adicionarEquipamento(equipamentoAtual);

        Contrato contrato = (Contrato) cbContrato.getSelectionModel().getSelectedItem();
        if (contrato == null)
            throw new Exception("Contrato nao informado");

        new ContratoDao().atualizar(contrato, new EquipamentoLista().getEquipamento());

        txtMarca.setText("");
        txtModelo.setText("");
        txtSn.setText("");

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

        Stage stage = (Stage) txtMarca.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Contrato> a = new ContratoDao().getLista();
        cbContrato.getItems().clear();
        cbContrato.getItems().addAll(a);

    }

}
