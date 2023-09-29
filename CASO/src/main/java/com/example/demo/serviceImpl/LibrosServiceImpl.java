package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LibrosEntity;
import com.example.demo.repository.LibrosRepository;
import com.example.demo.service.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService{

	
	@Autowired
	private LibrosRepository LibrosRepository;
	
	@Override
	public LibrosEntity create(LibrosEntity lbr) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(lbr);
	}

	@Override
	public LibrosEntity update(LibrosEntity lbr) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(lbr);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		LibrosRepository.deleteById(id);
		
	}

	@Override
	public LibrosEntity read(Long id) {
		// TODO Auto-generated method stub
		return LibrosRepository.findById(id).get();
	}

	@Override
	public List<LibrosEntity> readAll() {
		// TODO Auto-generated method stub
		return LibrosRepository.findAll();
	}
	

}
