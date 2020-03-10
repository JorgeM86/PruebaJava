package com.cidenet.hulkStore.daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.CategoriesDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
class CategoriesDAOTest {

	@Autowired
	private CategoriesDAO repository;
	
	@Test
	public void findAllCategories() {
		List<CategoriesDTO> allCategoriesDTO = repository.findAll();
		assertNotNull(allCategoriesDTO);
	}

}
