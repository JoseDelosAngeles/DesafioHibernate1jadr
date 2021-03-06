package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

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

	@Override
	public List<Cliente> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Cliente> lista = session.createQuery("FROM Cliente").getResultList();
		
		session.close();
		return lista;
	}

	@Override
	public Cliente findByName(String nombre) {
		Session session = entityManager.unwrap(Session.class);
		
		Cliente cliente = (Cliente)session.createQuery("FROM Cliente WHERE nombre='" + nombre +"'").uniqueResult();
		session.close();
		
		return cliente;
	}

	@Override
	public Cliente findBySurnames(String surname1, String surname2) {
		Session session = entityManager.unwrap(Session.class);
		Cliente cliente = (Cliente)session.createQuery("FROM Cliente WHERE primerApellido='"+surname1 + "' AND segundoApellido='"+surname2+"'").uniqueResult();
		session.close();
		return cliente;
	}

	@Override
	@Transactional
	public void update(Cliente cliente, Long id) {
		Session session = entityManager.unwrap(Session.class);
		Cliente clienteGuardado = session.get(Cliente.class, id);
		
		clienteGuardado.setNombre(cliente.getNombre());
		clienteGuardado.setPrimerApellido(cliente.getPrimerApellido());
		clienteGuardado.setSegundoApellido(cliente.getSegundoApellido());
		clienteGuardado.setDocIdentidad(cliente.getDocIdentidad());
		
		session.update(clienteGuardado);
	
		session.close();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Cliente clienteBorrar = session.get(Cliente.class, id);
		session.delete(clienteBorrar);
		session.close();
		
	}

}
