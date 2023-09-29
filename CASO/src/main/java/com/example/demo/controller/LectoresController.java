package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_LECTORES;

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

import com.example.demo.entity.LectoresEntity;
import com.example.demo.service.LectoresService;



@RestController
@RequestMapping(API_LECTORES)
public class LectoresController {

	@Autowired
	private LectoresService lectorService;
	
	@GetMapping("/all")
	public List<LectoresEntity> listar() {
		return lectorService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<LectoresEntity> listar2(@PathVariable("id") long id) {
		LectoresEntity lec = lectorService.read(id);
		if (lec!=null) {
			return new ResponseEntity<>(lec, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Lector")
	  public ResponseEntity<LectoresEntity> createTutorial(@RequestBody LectoresEntity l) {
	    try {
	      LectoresEntity lib = lectorService.create(new LectoresEntity(l.getId(), l.getNombre(),l.getTelefono(),l.getDireccion(), l.getCodigo_postal(), l.getObservaciones(), l.getAlquileresEntity()));

	      return new ResponseEntity<>(lib, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<LectoresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LectoresEntity lec) {
	    LectoresEntity lector = lectorService.read(id);

	    if (lector!=null) {
	    	lector.setId(lec.getId());
	    	lector.setNombre(lec.getNombre());
	    	lector.setTelefono(lec.getTelefono());
	    	lector.setDireccion(lec.getDireccion());
	    	lector.setCodigo_postal(lec.getCodigo_postal());
	    	lector.setObservaciones(lec.getObservaciones());
	    	lector.setAlquileresEntity(lec.getAlquileresEntity());
	      return new ResponseEntity<>(lectorService.create(lector), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteLector(@PathVariable("id") long id) {
	    try {
	    	lectorService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
