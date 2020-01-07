package pt.iade.gestaoInventario.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.gestaoInventario.models.Categoria;
import pt.iade.gestaoInventario.models.dao.CategoriaDAO;

public class RegistoCategoriaController implements Initializable {
	@FXML
	private TextField textFieldDescri��o;
	@FXML
	private TableView<Categoria> tableViewCategorias;

	@FXML
	private TableColumn<Categoria, Integer> tablecolumnId;

	@FXML
	private TableColumn<Categoria, String> tableColumnCategoria;

	private final CategoriaDAO categoriaDAO = new CategoriaDAO();

	private List<Categoria> listCategorias;

	private ObservableList<Categoria> observableListCategorias;
	
	

	@FXML
	void adicionarCategoria(ActionEvent event) {
		Categoria categoria = new Categoria();
		if (validarEntradaDeDados()) {
			categoria.setDescricao(textFieldDescri��o.getText());
			CategoriaDAO.inserir(categoria);
		}
		
		carregarTableViewCategorias();
	}

	void carregarTableViewCategorias() {

		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
		tableColumnCategoria.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		listCategorias = categoriaDAO.listar();

		observableListCategorias = FXCollections.observableArrayList(listCategorias);
		tableViewCategorias.setItems(observableListCategorias);

	}
	
	/** Validar entrada de dados para o registo. */
	private boolean validarEntradaDeDados() {
		String errorMessage = "";


		if (textFieldDescri��o.getText() == null || textFieldDescri��o.getText().length() == 0) {
			errorMessage += "Escreve a descri��o!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {

			/** Mostrar a mensagem de erro. */
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro no registo");
			alert.setHeaderText("Campo invalido");
			alert.setContentText(errorMessage);
			alert.show();
			return false;
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableViewCategorias();
	}
}
