package pt.iade.gestaoInventario.models;
/**
 * 
 * Classe de dados ou de dominio.
 * 
 * @author 50029213
 *
 */
public class Produto {
	private int idProduto;
	private String nome;
	private double preco;
	private int quantidade;
	private Categoria categoria;

	public Produto() {

	}

	public Produto(int idProduto, String nome, double preco, int quantidade) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nome;
	}
}
