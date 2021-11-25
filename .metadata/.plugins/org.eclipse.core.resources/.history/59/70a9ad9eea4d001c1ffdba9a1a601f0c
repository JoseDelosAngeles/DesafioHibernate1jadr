package com.demo.hibernate.desafio1jadr.entities;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI {

	@Autowired
	private EntityManager entityManager;
	
	//Abrimos sesión, guardamos cliente y cerramos sesión
	@Override
	@Transactional
	public void insertar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(cliente);
		
		session.close();

	}

	@Override
	public Cliente findById(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		
		Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id=" + idCliente).uniqueResult();
		
		session.close();
		
		return cliente;
	}

}
