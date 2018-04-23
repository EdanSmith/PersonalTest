package br.com.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.model.Pedido;

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("/loja")
public class PedidoResource {

	@Path("/pedido")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca() {
		ArrayList<Pedido> pedido = new ArrayList<Pedido>();
		
		pedido.add(new Pedido(1, 1, 1, 1, 7, 374.00, "Mbae-Tata"));
		//pedido.add(new Pedido(1, 1, 1, 1, 7, 374.00, "Mbae-Tata"));
		//pedido.add(new Pedido(1, 1, 1, 1, 7, 374.00, "Mbae-Tata"));
		//pedido.add(new Pedido(1, 1, 1, 1, 7, 374.00, "Mbae-Tata"));
		
		//Retorna a listinha do Json
		return new Gson().toJson(new Pedido(1, 1, 1, 1, 7, 374.00, "Mbae-Tata"));
		//JsonParser parser = new JsonParser();
		//return parser.parse(new Gson().toJson(pedido)).getAsJsonObject();
	}
}
