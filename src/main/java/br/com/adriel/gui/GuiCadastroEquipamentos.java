package br.com.adriel.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.adriel.dao.ClientePFDao;
import br.com.adriel.dao.ClientePJDao;
import br.com.adriel.dao.ContratoDao;
import br.com.adriel.model.Cliente;
import br.com.adriel.model.ClientePF;
import br.com.adriel.model.ClientePJ;
import br.com.adriel.model.Contrato;
import br.com.adriel.model.Equipamento;
import br.com.adriel.model.EquipamentoLista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GuiCadastroEquipamentos implements Initializable {

    @FXML
    private TableView tableCliente;

    @FXML
    private TableColumn tableClienteNome;

    @FXML
    private TableColumn tableClienteTelefone;

    @FXML
    private TableColumn tableClienteEndereco;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtDuracao;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtSn;

    @FXML
    private ListView lstEquipamentos;

    @FXML
    private void btnCadastrarClienteAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiOpcaoContrato.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Contratos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) txtData.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnCadastrarEquipamentoAction(ActionEvent event) {

        Equipamento equipamento = new Equipamento(txtMarca.getText(), txtModelo.getText(), txtSn.getText());

        new EquipamentoLista().adicionarEquipamento(equipamento);
        this.preencherLista();

        txtMarca.setText("");
        txtModelo.setText("");
        txtSn.setText("");
    }

    @FXML
    private void btnRemoverAction(ActionEvent event) {
        try {
            Equipamento equipamentoSelecionado = (Equipamento) lstEquipamentos.getSelectionModel().getSelectedItem();
            new EquipamentoLista().removerEquipamento(equipamentoSelecionado);

            this.preencherLista();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {

        List<Equipamento> equipamento = new EquipamentoLista().getEquipamento();

        try {
            Cliente cliente = (Cliente) tableCliente.getSelectionModel().getSelectedItem();
            if (cliente == null)
                throw new Exception("Cliente inválido");

            boolean isClientePF = new ClientePFDao().isClientPF(cliente);
            if (isClientePF) {
                ClientePF clientePF = new ClientePFDao().buscarCliente(cliente);
                Contrato contrato = new Contrato(equipamento, clientePF, txtData.getText(), txtDuracao.getText());

                new ContratoDao().gravar(contrato);
                new EquipamentoLista().reiniciarLista();
            } else {
                ClientePJ clientePj = new ClientePJDao().buscarCliente(cliente);
                Contrato contrato = new Contrato(equipamento, clientePj, txtData.getText(), txtDuracao.getText());

                new ContratoDao().gravar(contrato);
                new EquipamentoLista().reiniciarLista();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        Stage stage = (Stage) txtData.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnEditarContratoAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiEditarContrato.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            Stage stage = new Stage();
            stage.setTitle("Edição de Contratos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) txtMarca.getScene().getWindow();
        stage.close();
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
    // @FXML
    /*
     * private void clickedMouse(MouseEvent event){ Contrato contratoSelecionado =
     * (Contrato) tableCliente.getSelectionModel().getSelectedItem();
     * List<Equipamento> equipamentosContrato =
     * contratoSelecionado.getEquipamento();
     * lstEquipamentos.getItems().addAll(equipamentosContrato); }
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.carregarClientes();

    }

    private void carregarClientes() {
        tableCliente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableClienteNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Nome"));
        tableClienteTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Telefone"));
        tableClienteEndereco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Endereco"));
        tableCliente.getItems().setAll(testarCliente());
    }

    private List testarCliente() {

        List<Cliente> clientepj = new ClientePJDao().getListaGenerica();
        List<Cliente> clientepf = new ClientePFDao().getListaGenerica();
        clientepj.addAll(clientepf);

        return clientepj;
    }

    private void preencherLista() {
        List<Equipamento> a = new EquipamentoLista().getEquipamento();
        lstEquipamentos.getItems().clear();
        lstEquipamentos.getItems().addAll(new EquipamentoLista().getEquipamento());
    }

}
