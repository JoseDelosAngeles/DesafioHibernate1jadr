package com.demo.hibernate.desafio1jadr.services;

import java.util.List;

import com.demo.hibernate.desafio1jadr.entities.Cliente;
import com.demo.hibernate.desafio1jadr.entities.Contrato;

public interface HibernateServicioI {
	
	public Cliente buscarCliente(Long idCliente);
	
	public void insertar(Cliente cliente);
	
	public Cliente buscarPorNombre(String nombre);
	
	public Cliente buscarPorApellidos(String apellido1, String apellido2);
	
	public List<Cliente> buscarTodo();
	
	public void actualizar(Cliente cliente, Long Id);
	
	public void eliminar(Long id);
	
	
	//--------------CLIENTES--------------------
	//--------------CONTRATOS-------------------
	
	
	public void insertarContrato(Contrato contrato);
	
	public List<Contrato> buscarContratos();
	
	public Contrato buscarContratoPorId(Long id);
	
	public List<Contrato> buscarContratoPorCliente(Long idCliente);
	
	public void actualizarContrato(Contrato contrato, Long id);
	
	public void eliminarContrato(Long id);

}
