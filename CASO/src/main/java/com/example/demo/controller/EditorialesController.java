package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_EDITORIALES;

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

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.service.EditorialesService;



@RestController
@RequestMapping(API_EDITORIALES)
public class EditorialesController {

	@Autowired
	private EditorialesService editorialesService;
	
	@GetMapping("/all")
	public List<EditorialesEntity> listar() {
		return editorialesService.readAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EditorialesEntity> listar2(@PathVariable("id") long id) {
		EditorialesEntity edt = editorialesService.read(id);
		if (edt!=null) {
			return new ResponseEntity<>(edt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Editorial")
	  public ResponseEntity<EditorialesEntity> createTutorial(@RequestBody EditorialesEntity ed) {
	    try {
	      EditorialesEntity edit = editorialesService.create(new EditorialesEntity(ed.getId(),ed.getEditorial(), ed.getLibrosEntity()));

	      return new ResponseEntity<>(edit, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/put/{id}")
	  public ResponseEntity<EditorialesEntity> updateTutorial(@PathVariable("id") long id, @RequestBody EditorialesEntity ed) {
	    EditorialesEntity editorial = editorialesService.read(id);

	    if (editorial!=null) {
	    	editorial.setId(ed.getId());
	    	editorial.setEditorial(ed.getEditorial());
	    	editorial.setLibrosEntity(ed.getLibrosEntity());
	      return new ResponseEntity<>(editorialesService.create(editorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
	    try {
	    	editorialesService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
