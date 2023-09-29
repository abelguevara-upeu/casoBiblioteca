package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EditorialesEntity;


public interface EditorialesService {
	EditorialesEntity create(EditorialesEntity lbr);
	EditorialesEntity update(EditorialesEntity lbr);
	void delete(Long id);
	EditorialesEntity read(Long id);
	List<EditorialesEntity> readAll();
}
