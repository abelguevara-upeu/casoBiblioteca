package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LibrosEntity;


public interface LibrosService {
	LibrosEntity create(LibrosEntity lbr);
	LibrosEntity update(LibrosEntity lbr);
	void delete(Long id);
	LibrosEntity read(Long id);
	List<LibrosEntity> readAll();
}
