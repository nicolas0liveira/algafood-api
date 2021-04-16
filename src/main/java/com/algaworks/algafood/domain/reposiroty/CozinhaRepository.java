package com.algaworks.algafood.domain.reposiroty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	
	//spdjpa-query-keywords: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

	List<Cozinha> findTodasByNomeContaining(String nome);
	Optional<Cozinha> findByNome(String nome);//é preciso garantir que tem uma apenas... é possível usar apenas Cozinha sem optional tb
	
	boolean existsByNome(String nome);

} 
