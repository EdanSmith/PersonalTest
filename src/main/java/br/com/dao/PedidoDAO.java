package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.model.Pedido;

public class PedidoDAO {

	public Pedido getPedido(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonalTest1");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		String jpql = "select p from Pedido p where p.id = :pId";

		Query query = em.createQuery(jpql);
		query.setParameter("pId", id);

		Pedido pedido = (Pedido) query.getSingleResult();

		System.out.println(pedido.getQuantidade());

		em.getTransaction().commit();
		em.close();

		return pedido;
	}

	public void createPedido(int idCliente, int idProduto, int numeroControle, int quantidade, double valorTotal,
			String nome) {
		Pedido novoPedido = new Pedido(idCliente, idProduto, numeroControle, quantidade, valorTotal, nome);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonalTest1");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(novoPedido);
		em.getTransaction().commit();
		em.close();
	}

	public void updatePedido(int idPedido, int idCliente, int idProduto, int numeroControle, int quantidade,
			double valorTotal, String nome) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonalTest1");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		String jpql = "select p from Pedido p where id = :pId";
		Query query = em.createQuery(jpql);
		query.setParameter("pId", idPedido);

		Pedido pedido = (Pedido) query.getSingleResult();
		pedido.setIdCliente(idCliente);
		pedido.setIdProduto(idProduto);
		pedido.setNumeroControle(numeroControle);
		pedido.setQuantidade(quantidade);
		pedido.setValorTotal(valorTotal);
		pedido.setNome(nome);

		em.persist(pedido);
		em.getTransaction().commit();
		em.close();
	}

	public void deletePedido(int id) {
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("PersonalTest1");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		String jpql = "select p from Pedido p where id = :pId";
		Query query = em.createQuery(jpql);
		query.setParameter("pId", id);

		Pedido pedido = (Pedido) query.getSingleResult();

		em.remove(pedido);

		em.getTransaction().commit();
		em.close();
	}
}
