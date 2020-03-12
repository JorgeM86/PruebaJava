package com.cidenet.hulkStore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cidenet.hulkStore.daos.TypesDAO;
import com.cidenet.hulkStore.entities.TypesDTO;

@Repository
@Transactional
public class TypesServices {
	
	@Autowired
	private TypesDAO repository;

	public List<TypesDTO> getAllTypes() {
		return repository.findAll();
	}

}
