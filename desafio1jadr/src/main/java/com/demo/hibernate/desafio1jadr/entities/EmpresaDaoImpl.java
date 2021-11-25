package com.demo.hibernate.desafio1jadr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDaoImpl implements EmpresaDaoI {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertar(Empresa empresa) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(empresa);
		
		session.close();

	}

	@Override
	public List<Empresa> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Empresa> lista = session.createQuery("FROM Empresa").getResultList();
		
		session.close();
		
		return lista;
	}

	@Override
	public Empresa findById(Long idEmpresa) {
		Session session = entityManager.unwrap(Session.class);
		
		Empresa empresa = (Empresa) session.createQuery("FROM Empresa WHERE id=" + idEmpresa).uniqueResult();
		
		session.close();
		
		return empresa;
	}

}
