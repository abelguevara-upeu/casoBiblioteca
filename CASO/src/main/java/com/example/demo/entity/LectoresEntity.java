package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LECTORES")
public class LectoresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_LECTOR")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLector")
    @SequenceGenerator(sequenceName = "SEQ_LIBRO", allocationSize = 1, name = "seqLector")
	private Long id;
  
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "TELEFONO")
  	private String telefono;
  	
  	@Column(name = "DIRECCION")
  	private String direccion;
  	
  	@Column(name = "CODIGO_POSTAL")
  	private String codigo_postal;
  	
  	@Column(name = "OBSERVACIONES")
  	private String observaciones;
  	
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "lectorEntity")
  	@JsonIgnore
  	private Set<AlquileresEntity> alquileresEntity;
}
