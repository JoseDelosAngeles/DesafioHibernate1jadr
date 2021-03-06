package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

public interface ContratoDaoI {
	
	public void insert(Contrato contrato);
	
	public List<Contrato> findAll();
	
	public Contrato findById(Long idContrato);
	
	public List<Contrato> findByClientId(Long idCliente);
	
	public void update(Contrato contrato, Long id);
	
	public void delete(Long id);

}
