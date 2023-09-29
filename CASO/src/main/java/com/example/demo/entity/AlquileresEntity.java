package com.example.demo.entity;

import java.io.Serializable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALQUILERES")
public class AlquileresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_ALQUILER")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlquiler")
    @SequenceGenerator(sequenceName = "SEQ_ALQUILER", allocationSize = 1, name = "seqAlquiler")
	private Long id;
  
  	@Column(name = "FECHA_SALIDA")
  	private String fecha_salida;
  	
  	@Column(name = "FECHA_ENTRADA")
  	private String fecha_entrada;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_LECTOR", nullable=false)
  	private LectoresEntity lectorEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_LIBRO", nullable=false)
  	private LibrosEntity libroEntity;
}
