package com.cidenet.hulkStore.junit_daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.TypesDTO;
import com.cidenet.hulkStore.services.TypesServices;;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.cidenet.hulkStore")
class TypesDAOTest {

	@Autowired
	private TypesServices repository;
	
	@Test
	public void findAllTypes() {
		List<TypesDTO> allTypesDTO = repository.getAllTypes();
		assertNotNull(allTypesDTO);
	}

}
