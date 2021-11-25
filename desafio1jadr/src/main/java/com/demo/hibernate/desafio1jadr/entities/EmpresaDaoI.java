package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

public interface EmpresaDaoI {

	public void insertar(Empresa empresa);
	
	public List<Empresa> findAll();
	
	public Empresa findById(Long idEmpresa);
}
