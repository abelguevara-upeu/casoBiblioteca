package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_CATEGORIAS;

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

import com.example.demo.entity.CategoriasEntity;
import com.example.demo.service.CategoriasService;



@RestController
@RequestMapping(API_CATEGORIAS)
public class CategoriasController {

	@Autowired
	private CategoriasService categoriasService;
	
	@GetMapping("/all")
	public List<CategoriasEntity> listar() {
		return categoriasService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoriasEntity> listar2(@PathVariable("id") long id) {
		CategoriasEntity lbr = categoriasService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Categoria")
	  public ResponseEntity<CategoriasEntity> createTutorial(@RequestBody CategoriasEntity l) {
	    try {
	      CategoriasEntity lib = categoriasService.create(new CategoriasEntity(l.getId(), l.getCategoria(), l.getLibrosEntity()));

	      return new ResponseEntity<>(lib, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<CategoriasEntity> updateTutorial(@PathVariable("id") long id, @RequestBody CategoriasEntity cat) {
	    CategoriasEntity categoria = categoriasService.read(id);

	    if (categoria!=null) {
	    	categoria.setId(cat.getId());
	    	categoria.setCategoria(cat.getCategoria());
	    	categoria.setLibrosEntity(cat.getLibrosEntity());
	      return new ResponseEntity<>(categoriasService.create(categoria), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") long id) {
	    try {
	    	categoriasService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
