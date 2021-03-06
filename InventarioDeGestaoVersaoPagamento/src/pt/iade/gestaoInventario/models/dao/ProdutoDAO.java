package pt.iade.gestaoInventario.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.gestaoInventario.models.Categoria;
import pt.iade.gestaoInventario.models.Produto;

/**
 * 
 * Esta classe permiter ter intera��o com a base de dados.
 *
 */
public class ProdutoDAO {

	public boolean inserir(Produto produto) {
		String sql = "INSERT INTO produtos(nome, preco, quantidade, idCategoria) VALUES(?,?,?,?)";
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setInt(4, produto.getCategoria().getIdCategoria());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean alterar(Produto produto) {
		String sql = "UPDATE produtos SET nome=?, preco=?, quantidade=?, idCategoria=? WHERE idProduto=?";
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setInt(4, produto.getCategoria().getIdCategoria());
			stmt.setInt(5, produto.getIdProduto());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Produto produto) {
		String sql = "DELETE FROM produtos WHERE idColaborador=?";
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, produto.getIdProduto());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public List<Produto> listar() {
		String sql = "SELECT * FROM produtos";
		List<Produto> retorno = new ArrayList<>();
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Produto produto = new Produto();
				Categoria categoria = new Categoria();
				produto.setIdProduto(resultado.getInt("idProduto"));
				produto.setNome(resultado.getString("nome"));
				produto.setPreco(resultado.getDouble("preco"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				categoria.setIdCategoria(resultado.getInt("idCategoria"));

				/** Obtendo os dados completos da Categoria associada ao Produto. */
				CategoriaDAO categoriaDAO = new CategoriaDAO();
				categoria = categoriaDAO.buscar(categoria);

				produto.setCategoria(categoria);
				retorno.add(produto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return retorno;
	}

	public static ObservableList<Produto> listarPorCategoria(Categoria categoria) {
		String sql = "SELECT * FROM produtos WHERE idCategoria=?";
		ObservableList<Produto> retorno = FXCollections.observableArrayList();
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, categoria.getIdCategoria());
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(resultado.getInt("idProduto"));
				produto.setNome(resultado.getString("nome"));
				produto.setPreco(resultado.getDouble("preco"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				categoria.setIdCategoria(resultado.getInt("idCategoria"));
				produto.setCategoria(categoria);
				retorno.add(produto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return retorno;
	}

	public Produto buscar(Produto produto) {
		String sql = "SELECT * FROM produtos WHERE idProduto=?";
		Produto retorno = new Produto();
		Categoria categoria = new Categoria();
		Connection connection = DBConnection.conectar();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, produto.getIdProduto());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				retorno.setIdProduto(resultado.getInt("idProduto"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setPreco(resultado.getDouble("preco"));
				retorno.setQuantidade(resultado.getInt("quantidade"));
				categoria.setIdCategoria(resultado.getInt("idCategoria"));
				retorno.setCategoria(categoria);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return retorno;
	}

}
