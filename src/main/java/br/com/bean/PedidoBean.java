package br.com.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.bean.ManagedBean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.dao.PedidoDAO;
import br.com.model.Pedido;

@ManagedBean
public class PedidoBean {

	String teste = "ué";
	String testeAjax = "Nuffins";

	int pedidoIdSelect;
	int pedidoId;
	int clienteId;
	int produtoId;
	int numeroControle;
	int quantidade;
	double valorTotal;
	String nome;

	public int getPedidoIdSelect() {
		return pedidoIdSelect;
	}

	public void setPedidoIdSelect(int pedidoIdSelect) {
		this.pedidoIdSelect = pedidoIdSelect;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
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

	public String getTeste() {
		return teste;
	}

	public String getTesteAjax() {
		return testeAjax;
	}

	public int getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void callRest() {
		// testeAjax = "Koroi, aí çyn, chamou o ajax!";

		String sURL = "http://localhost:8080/PersonalTest1/resources/loja/pedido"; // just a string

		// Connect to the URL using java's native library
		URL url;
		try {
			url = new URL(sURL);

			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); // from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); // Convert the input
																									// stream to a json
																									// element
			if (root instanceof JsonObject) {
				JsonObject rootObj = root.getAsJsonObject(); // May be an array, may be an object.
				testeAjax = rootObj.toString();
			} else if (root instanceof JsonArray) {
				JsonArray rootArray = root.getAsJsonArray();
				testeAjax = rootArray.get(0).toString(); // Add um for depois pra fazer o que precisa
			} else {
				testeAjax = "Erro pegando o ajax";
			}

			// testeAjax = rootobj.get("zip_code").getAsString(); //just grab the zipcode
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getPedido() {

		Pedido pedido = new PedidoDAO().getPedido(pedidoIdSelect);
		this.pedidoId = pedido.getId();
		this.clienteId = pedido.getIdCliente();
		this.produtoId = pedido.getIdProduto();
		this.numeroControle = pedido.getNumeroControle();
		this.quantidade = pedido.getQuantidade();
		this.valorTotal = pedido.getValorTotal();
		this.nome = pedido.getNome();

		// return "";
	}

	public void createPedido() {
		if (pedidoId != 0) {
			new PedidoDAO().updatePedido(pedidoId, clienteId, produtoId, numeroControle, quantidade, valorTotal, nome);
		} else {
			new PedidoDAO().createPedido(clienteId, produtoId, numeroControle, quantidade, valorTotal, nome);
		}
	}

	public void deletePedido() {
		new PedidoDAO().deletePedido(pedidoId);
	}
}
