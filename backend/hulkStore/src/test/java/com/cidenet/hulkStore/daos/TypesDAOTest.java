package com.cidenet.hulkStore.daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.TypesDTO;;

@RunWith(SpringRunner.class)
@DataJpaTest
class TypesDAOTest {

	@Autowired
	private TypesDAO repository;
	
	@Test
	public void findAllTypes() {
		List<TypesDTO> allTypesDTO = repository.findAll();
		assertNotNull(allTypesDTO);
	}

}
