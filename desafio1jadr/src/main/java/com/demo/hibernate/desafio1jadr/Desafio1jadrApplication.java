package com.demo.hibernate.desafio1jadr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.hibernate.desafio1jadr.entities.Cliente;
import com.demo.hibernate.desafio1jadr.entities.Empresa;
import com.demo.hibernate.desafio1jadr.entities.EmpresaDaoI;
import com.demo.hibernate.desafio1jadr.services.HibernateServicioI;

@SpringBootApplication
public class Desafio1jadrApplication implements CommandLineRunner {
	
	@Autowired
	private EmpresaDaoI empresaDao;
	
	@Autowired HibernateServicioI service;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1jadrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("INICIO DE LA APLICACIÓN CLIENTE (DESAFIO 1)--------------------");
		System.out.println("<------AÑADIR CLIENTES------->");
		Cliente cliente = new Cliente();
		cliente.setNombre("Samuel");
		cliente.setPrimerApellido("Sosa");
		cliente.setSegundoApellido("Suárez");
		cliente.setDocIdentidad("12345678S");
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Manuel");
		cliente2.setPrimerApellido("Márquez");
		cliente2.setSegundoApellido("Mendoza");
		cliente2.setDocIdentidad("23456789M");
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Claudia");
		cliente3.setPrimerApellido("Cordero");
		cliente3.setSegundoApellido("Cárdenas");
		cliente3.setDocIdentidad("34567890C");
		
		service.insertar(cliente);
		service.insertar(cliente2);
		service.insertar(cliente3);
		
		System.out.println("<------BUSCAR CLIENTE POR ID------->");
		cliente = service.buscarCliente(2L);
		System.out.println(cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
		
		System.out.println("<------BUSCAR CLIENTE POR NOMBRE------->");
		cliente = service.buscarPorNombre("Claudia");
		System.out.println(cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
		
		System.out.println("<------BUSCAR CLIENTE POR APELLIDOS------->");
		cliente = service.buscarPorApellidos("Sosa", "Suárez");
		System.out.println(cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
		
		System.out.println("<------BUSCAR TODOS LOS CLIENTES------->");
		List<Cliente> listaClientes = service.buscarTodo();
		for(Cliente c: listaClientes) {
			System.out.println("Cliente: " + c.getNombre() + " " + c.getPrimerApellido() + " " + c.getSegundoApellido());
			System.out.println();
		}
		
		System.out.println("<------ACTUALIZAR CLIENTE------->");
		Cliente clienteActualizar = new Cliente();
		clienteActualizar.setNombre("Paco");
		clienteActualizar.setPrimerApellido("Pérez");
		clienteActualizar.setSegundoApellido("Pinto");
		clienteActualizar.setDocIdentidad("98765432P");
		service.actualizar(clienteActualizar, 2L);
		System.out.println();
		System.out.println("<------BORRAR CLIENTE------->");
		service.eliminar(1L);
		
		System.out.println("FIN DE LA APLICACIÓN CLIENTE (DESAFIO 1)--------------------");
		
	/*	
		System.out.println("INICIO DE LA APLICACIÓN EMPRESA--------------------");
		System.out.println();
		Empresa empresa = new Empresa();
		empresa.setNombre("NTT Sevilla");
		empresa.setDireccion("Av. de la Innovación, 2, 41020 Sevilla");
		empresaDao.insertar(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Altran");
		empresa2.setDireccion("C. Hispano Aviación, 11, 41309 La Rinconada, Sevilla");
		empresaDao.insertar(empresa2);
		
		Empresa empresa3 = new Empresa();
		empresa3.setNombre("Ayesa");
		empresa3.setDireccion("C. Marie Curie, 2, 41092 Sevilla");
		empresaDao.insertar(empresa3);
		
		List<Empresa> listaEmpresas = empresaDao.findAll();
		
		
		for(Empresa e : listaEmpresas) {
			System.out.println("Empresa: " + e.getNombre() + ", Dirección: " + e.getDireccion());
			System.out.println();
		}
		
		Empresa empresaPorId = empresaDao.findById(1L);
		System.out.println("Empresa encontrada con id=" + empresaPorId.getId() + ": " + empresaPorId.getNombre());
		System.out.println("FIN DE LA APLICACIÓN EMPRESA--------------------");
		
	*/	
		
	}

}
