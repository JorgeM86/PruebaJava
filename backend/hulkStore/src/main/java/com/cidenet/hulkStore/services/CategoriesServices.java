package com.cidenet.hulkStore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cidenet.hulkStore.daos.CategoriesDAO;
import com.cidenet.hulkStore.entities.CategoriesDTO;

@Repository
@Transactional
public class CategoriesServices {
	
	@Autowired
	private CategoriesDAO repository;

	public List<CategoriesDTO> getAllCategories() {
		return repository.findAll();
	}
	
}
