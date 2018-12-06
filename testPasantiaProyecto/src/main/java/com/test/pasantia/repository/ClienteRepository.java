package com.test.pasantia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.pasantia.models.Cliente;

@RepositoryRestResource( exported = true)
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	List<Cliente> findByLogin(@Param("login") String login);
	
	Cliente findFirstByLogin(@Param("login") String login);
	
	Iterable<Cliente> findByLoginStartingWith(@Param("login") String login);
	
	
}
