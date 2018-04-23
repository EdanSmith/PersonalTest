package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_cliente")
	private int idCliente;
	@Column(name = "id_produto")
	private int idProduto;
	@Column(name = "numero_controle")
	private int numeroControle;
	private int quantidade;
	@Column(name = "valor_total")
	private double valorTotal;
	private String nome;

	public Pedido() {
	}

	public Pedido(int idCliente, int idProduto, int numeroControle, int quantidade, double valorTotal, String nome) {
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.numeroControle = numeroControle;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.nome = nome;
	}

	public Pedido(int id, int idCliente, int idProduto, int numeroControle, int quantidade, double valorTotal,
			String nome) {
		this.id = id;
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.numeroControle = numeroControle;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(int numeroControle) {
		this.numeroControle = numeroControle;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
}
