package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_LIBROS;

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

import com.example.demo.entity.LibrosEntity;
import com.example.demo.service.LibrosService;



@RestController
@RequestMapping(API_LIBROS)
public class LibrosController {

	@Autowired
	private LibrosService libroService;
	
	@GetMapping("/all")
	public List<LibrosEntity> listar() {
		return libroService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<LibrosEntity> listar2(@PathVariable("id") long id) {
		LibrosEntity lbr = libroService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Libro")
	  public ResponseEntity<LibrosEntity> createTutorial(@RequestBody LibrosEntity l) {
	    try {
	      LibrosEntity lib = libroService.create(new LibrosEntity(l.getId(), l.getTitulo(), l.getFecha_lanzamiento(), l.getAutorEntity(), l.getCategoriaEntity(), l.getEditorialEntity(), l.getIdioma(), l.getPaginas(), l.getDescripcion(), l.getPortada(), l.getAlquileresEntity()));

	      return new ResponseEntity<>(lib, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<LibrosEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LibrosEntity l) {
	    LibrosEntity libros = libroService.read(id);

	    if (libros!=null) {
	    	libros.setId(l.getId());
	    	libros.setTitulo(l.getTitulo());
	    	libros.setFecha_lanzamiento(l.getFecha_lanzamiento());
	    	libros.setAutorEntity(l.getAutorEntity());
	    	libros.setCategoriaEntity(l.getCategoriaEntity());
	    	libros.setEditorialEntity(l.getEditorialEntity());
	    	libros.setIdioma(l.getIdioma());
	    	libros.setPaginas(l.getPaginas());
	    	libros.setDescripcion(l.getDescripcion());
	    	libros.setPortada(l.getPortada());
	      return new ResponseEntity<>(libroService.create(libros), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
	    try {
	    	libroService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
