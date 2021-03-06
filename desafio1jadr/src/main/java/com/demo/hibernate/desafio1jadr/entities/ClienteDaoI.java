package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

public interface ClienteDaoI {

	public void insertar(Cliente cliente);
	
	public Cliente findById(Long idCliente);
	
	public List<Cliente> findAll();
	
	public Cliente findByName(String nombre);
	
	public Cliente findBySurnames(String surname1, String surname2);
	
	public void update(Cliente cliente, Long id);
	
	public void delete(Long id);
}
