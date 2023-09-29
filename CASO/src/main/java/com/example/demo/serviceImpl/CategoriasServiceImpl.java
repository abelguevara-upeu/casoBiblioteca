package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriasEntity;
import com.example.demo.repository.CategoriasRepository;
import com.example.demo.service.CategoriasService;

@Service
public class CategoriasServiceImpl implements CategoriasService{

	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@Override
	public CategoriasEntity create(CategoriasEntity lbr) {
		// TODO Auto-generated method stub
		return categoriasRepository.save(lbr);
	}

	@Override
	public CategoriasEntity update(CategoriasEntity lbr) {
		// TODO Auto-generated method stub
		return categoriasRepository.save(lbr);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriasRepository.deleteById(id);
		
	}

	@Override
	public CategoriasEntity read(Long id) {
		// TODO Auto-generated method stub
		return categoriasRepository.findById(id).get();
	}

	@Override
	public List<CategoriasEntity> readAll() {
		// TODO Auto-generated method stub
		return categoriasRepository.findAll();
	}
	

}
