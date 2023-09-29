package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.repository.EditorialesRepository;
import com.example.demo.service.EditorialesService;

@Service
public class EditorialesServiceImpl implements EditorialesService{

	
	@Autowired
	private EditorialesRepository LibrosRepository;
	
	@Override
	public EditorialesEntity create(EditorialesEntity edt) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(edt);
	}

	@Override
	public EditorialesEntity update(EditorialesEntity edt) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(edt);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		LibrosRepository.deleteById(id);
		
	}

	@Override
	public EditorialesEntity read(Long id) {
		// TODO Auto-generated method stub
		return LibrosRepository.findById(id).get();
	}

	@Override
	public List<EditorialesEntity> readAll() {
		// TODO Auto-generated method stub
		return LibrosRepository.findAll();
	}
	

}
