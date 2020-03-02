package com.cidenet.hulkStore.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cidenet.hulkStore.entities.ProductsDTO;

public interface ProductsDAO extends JpaRepository<ProductsDTO, Integer> {

}
