package com.cidenet.hulkStore.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidenet.hulkStore.entities.CategoriesDTO;

public interface CategoriesDAO extends JpaRepository<CategoriesDTO, Integer> {

}
