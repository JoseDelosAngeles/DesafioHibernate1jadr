package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(Contrato contrato) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(contrato);
		
		session.close();
		
	}

	@Override
	public List<Contrato> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Contrato> listaContratos = session.createQuery("FROM Contrato").getResultList();
		
		session.close();
		
		return listaContratos;
	}

	@Override
	public Contrato findById(Long idContrato) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contrato = (Contrato)session.createQuery("FROM Contrato WHERE id="+idContrato).uniqueResult();
		session.close();
		return contrato;
	}

	@Override
	public List<Contrato> findByClientId(Long idCliente) {
		Session session = entityManager.unwrap(Session.class);
		List<Contrato> listaContratos = session.createQuery("FROM Contrato WHERE clienteId="+idCliente).getResultList();
		session.close();
		return listaContratos;
	}

	@Override
	@Transactional
	public void update(Contrato contrato, Long id) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contratoGuardado = session.get(Contrato.class, id);
		
		contratoGuardado.setClienteId(contrato.getClienteId());
		contratoGuardado.setFechaCaducidad(contrato.getFechaCaducidad());
		contratoGuardado.setFechaVigencia(contrato.getFechaVigencia());
		contratoGuardado.setPrecio(contrato.getPrecio());
		
		session.update(contratoGuardado);
	
		session.close();

	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Contrato contratoBorrar = session.get(Contrato.class, id);
		session.delete(contratoBorrar);
		session.close();

	}

}
