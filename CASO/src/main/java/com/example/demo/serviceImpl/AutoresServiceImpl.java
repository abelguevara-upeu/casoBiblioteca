package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.repository.AutoresRepository;
import com.example.demo.service.AutoresService;

@Service
public class AutoresServiceImpl implements AutoresService{

	
	@Autowired
	private AutoresRepository autoresRepository;
	
	@Override
	public AutoresEntity create(AutoresEntity lbr) {
		// TODO Auto-generated method stub
		return autoresRepository.save(lbr);
	}

	@Override
	public AutoresEntity update(AutoresEntity lbr) {
		// TODO Auto-generated method stub
		return autoresRepository.save(lbr);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autoresRepository.deleteById(id);
		
	}

	@Override
	public AutoresEntity read(Long id) {
		// TODO Auto-generated method stub
		return autoresRepository.findById(id).get();
	}

	@Override
	public List<AutoresEntity> readAll() {
		// TODO Auto-generated method stub
		return autoresRepository.findAll();
	}
	

}
