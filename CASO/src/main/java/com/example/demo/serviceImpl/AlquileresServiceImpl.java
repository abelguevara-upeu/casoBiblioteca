package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.repository.AlquileresRepository;
import com.example.demo.service.AlquileresService;

@Service
public class AlquileresServiceImpl implements AlquileresService{

	
	@Autowired
	private AlquileresRepository LibrosRepository;
	
	@Override
	public AlquileresEntity create(AlquileresEntity alq) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(alq);
	}

	@Override
	public AlquileresEntity update(AlquileresEntity alq) {
		// TODO Auto-generated method stub
		return LibrosRepository.save(alq);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		LibrosRepository.deleteById(id);
		
	}

	@Override
	public AlquileresEntity read(Long id) {
		// TODO Auto-generated method stub
		return LibrosRepository.findById(id).get();
	}

	@Override
	public List<AlquileresEntity> readAll() {
		// TODO Auto-generated method stub
		return LibrosRepository.findAll();
	}
	

}
