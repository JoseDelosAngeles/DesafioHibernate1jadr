package com.demo.hibernate.desafio1jadr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hibernate.desafio1jadr.entities.Cliente;
import com.demo.hibernate.desafio1jadr.entities.ClienteDaoI;
import com.demo.hibernate.desafio1jadr.entities.Contrato;
import com.demo.hibernate.desafio1jadr.entities.ContratoDaoI;

@Service
public class HibernateServicioImpl implements HibernateServicioI {

	//-----------------CLIENTES---------------
	@Autowired
	private ClienteDaoI clienteDao;
	
	@Override
	public Cliente buscarCliente(Long idCliente) {
		return clienteDao.findById(idCliente);
	}

	@Override
	public void insertar(Cliente cliente) {
		clienteDao.insertar(cliente);
		
	}

	@Override
	public Cliente buscarPorNombre(String nombre) {
		return clienteDao.findByName(nombre);
	}

	@Override
	public Cliente buscarPorApellidos(String apellido1, String apellido2) {
		return clienteDao.findBySurnames(apellido1, apellido2);
	}

	@Override
	public List<Cliente> buscarTodo() {
		return clienteDao.findAll();
	}

	@Override
	public void actualizar(Cliente cliente, Long Id) {
		clienteDao.update(cliente, Id);
		
	}

	@Override
	public void eliminar(Long id) {
		clienteDao.delete(id);
		
	}

	//-----------------CLIENTES--------------------
	//---------------------------------------------
	//-----------------CONTRATOS-------------------
	
	@Autowired
	private ContratoDaoI contratoDao;

	@Override
	public void insertarContrato(Contrato contrato) {
		contratoDao.insert(contrato);
		
	}

	@Override
	public List<Contrato> buscarContratos() {
		return contratoDao.findAll();
	}

	@Override
	public Contrato buscarContratoPorId(Long id) {
		return contratoDao.findById(id);
	}

	@Override
	public List<Contrato> buscarContratoPorCliente(Long idCliente) {
		return contratoDao.findByClientId(idCliente);
	}

	@Override
	public void actualizarContrato(Contrato contrato, Long id) {
		contratoDao.update(contrato, id);
		
	}

	@Override
	public void eliminarContrato(Long id) {
		contratoDao.delete(id);
		
	}
	
	
	
}
