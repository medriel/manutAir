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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class GuiTecnico implements Initializable {

    @FXML
    private ComboBox cbOrdemServico;

    @FXML
    private void btnFinalizarAction(ActionEvent event) {
        try {
            CadastroOS osAtual = (CadastroOS) cbOrdemServico.getSelectionModel().getSelectedItem();
            osAtual.atualizarStatus("Finalizada");
            new CadastroOSDao().atualizar(osAtual, osAtual.getTecnico(), osAtual.getData(), osAtual.getHora(),
                    "Finalizada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<CadastroOS> a = new CadastroOSDao().buscarOS("Em andamento", Usuario.getLoginAtual());
        cbOrdemServico.getItems().clear();
        cbOrdemServico.getItems().addAll(a);
    }

}
