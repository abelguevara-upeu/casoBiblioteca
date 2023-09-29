package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriasEntity;


public interface CategoriasService {
	CategoriasEntity create(CategoriasEntity lbr);
	CategoriasEntity update(CategoriasEntity lbr);
	void delete(Long id);
	CategoriasEntity read(Long id);
	List<CategoriasEntity> readAll();
}
