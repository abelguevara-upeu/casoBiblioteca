package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LectoresEntity;
import com.example.demo.repository.LectoresRepository;
import com.example.demo.service.LectoresService;

@Service
public class LectoresServiceImpl implements LectoresService{

	
	@Autowired
	private LectoresRepository lectoresRepository;
	
	@Override
	public LectoresEntity create(LectoresEntity lec) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(lec);
	}

	@Override
	public LectoresEntity update(LectoresEntity lec) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(lec);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lectoresRepository.deleteById(id);
		
	}

	@Override
	public LectoresEntity read(Long id) {
		// TODO Auto-generated method stub
		return lectoresRepository.findById(id).get();
	}

	@Override
	public List<LectoresEntity> readAll() {
		// TODO Auto-generated method stub
		return lectoresRepository.findAll();
	}
	

}
