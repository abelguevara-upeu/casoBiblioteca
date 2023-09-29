package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_ALQUILERES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.service.AlquileresService;



@RestController
@RequestMapping(API_ALQUILERES)
public class AlquileresController {

	@Autowired
	private AlquileresService alquileresService;
	
	@GetMapping("/all")
	public List<AlquileresEntity> listar() {
		return alquileresService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AlquileresEntity> listar2(@PathVariable("id") long id) {
		AlquileresEntity lbr = alquileresService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Alquileres")
	  public ResponseEntity<AlquileresEntity> createTutorial(@RequestBody AlquileresEntity a) {
	    try {
	      AlquileresEntity alq = alquileresService.create(new AlquileresEntity(a.getId(), a.getFecha_entrada(), a.getFecha_salida(), a.getLectorEntity(), a.getLibroEntity()));

	      return new ResponseEntity<>(alq, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<AlquileresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AlquileresEntity alq) {
	    AlquileresEntity alquiler = alquileresService.read(id);

	    if (alquiler!=null) {
	    	alquiler.setId(alq.getId());
	    	alquiler.setFecha_entrada(alq.getFecha_entrada());
	    	alquiler.setFecha_salida(alq.getFecha_salida());
	    	alquiler.setLectorEntity(alq.getLectorEntity());
	    	alquiler.setLibroEntity(alq.getLibroEntity());
	    	
	      return new ResponseEntity<>(alquileresService.create(alquiler), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
	    try {
	    	alquileresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
