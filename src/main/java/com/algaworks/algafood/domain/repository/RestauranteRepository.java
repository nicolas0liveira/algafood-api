package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>
			, RestauranteRepositoryQueries/*consultas customizadas*/, JpaSpecificationExecutor<Restaurante>/*para uso genérico dos predicates*/ {
	
	//sobrescrevendo a implementacao do findAll do hibernate
	// Se um restaurante não tiver nenhuma forma de pagamento associada a ele,
	// esse restaurante não será retornado usando JOIN FETCH r.formasPagamento.
	// Para resolver isso, temos que usar LEFT JOIN FETCH r.formasPagamento
//	@Query("from Restaurante r left join fetch r.cozinha left join fetch r.formasPagamento")
	@Query("from Restaurante r left join fetch r.cozinha")
	List<Restaurante> findAll();
	
	//spdjpa-query-keywords: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	
	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha);
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id= :id" ) //JPQL
	List<Restaurante> consultarPorNome(String nome, @Param("id")Long cozinhaId);
	//ou
	List<Restaurante> consultarPorNomeNamedQuery(String nome, @Param("id")Long cozinhaId);//JPQL de um arquivo externo /META-INF/orm.xml



}
