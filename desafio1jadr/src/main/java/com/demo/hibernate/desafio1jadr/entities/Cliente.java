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
	
	
	
}