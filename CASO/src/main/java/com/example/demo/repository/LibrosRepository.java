package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LibrosEntity;


public interface LibrosRepository extends JpaRepository<LibrosEntity, Long>{

}