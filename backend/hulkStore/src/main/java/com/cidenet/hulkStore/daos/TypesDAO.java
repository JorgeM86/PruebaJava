package com.cidenet.hulkStore.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidenet.hulkStore.entities.TypesDTO;

public interface TypesDAO extends JpaRepository<TypesDTO, Integer> {

}
