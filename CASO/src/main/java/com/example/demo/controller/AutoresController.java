package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_AUTORES;

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

import com.example.demo.entity.AutoresEntity;
import com.example.demo.service.AutoresService;



@RestController
@RequestMapping(API_AUTORES)
public class AutoresController {

	@Autowired
	private AutoresService autoresService;
	
	@GetMapping("/all")
	public List<AutoresEntity> listar() {
		return autoresService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AutoresEntity> listar2(@PathVariable("id") long id) {
		AutoresEntity aut = autoresService.read(id);
		if (aut!=null) {
			return new ResponseEntity<>(aut, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Autor")
	  public ResponseEntity<AutoresEntity> createTutorial(@RequestBody AutoresEntity a) {
	    try {
	      AutoresEntity lib = autoresService.create(new AutoresEntity(a.getId(), a.getAutor(), a.getLibrosEntity()));

	      return new ResponseEntity<>(lib, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<AutoresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AutoresEntity a) {
	    AutoresEntity autores = autoresService.read(id);
	    if (autores!=null) {
	    	autores.setId(a.getId());
	    	autores.setAutor(a.getAutor());
	    	autores.setLibrosEntity(a.getLibrosEntity());
	      return new ResponseEntity<>(autoresService.create(autores), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
	    try {
	    	autoresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
