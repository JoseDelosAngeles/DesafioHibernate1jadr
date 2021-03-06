package com.demo.hibernate.desafio1jadr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENT")
public class Cliente {
	
	private Long id;
	
	private String nombre;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String docIdentidad;
	
	private List<Contrato> contractsList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
	public List<Contrato> getContractsList() {
		return contractsList;
	}

	public void setContractsList(List<Contrato> contractsList) {
		this.contractsList = contractsList;
	}

	@Column(name="PRIMER_APELLIDO")
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	@Column(name="SEGUNDO_APELLIDO")
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Column(name="DOC_IDENTIDAD", nullable = false, length = 9, unique = true)
	public String getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}
	
	
	
}
