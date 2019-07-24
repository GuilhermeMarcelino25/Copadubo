package com.guilherme.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilherme.entity.RelatorioEntity;

public interface RelatorioRepository extends JpaRepository<RelatorioEntity, Long> {
	
	@Query(value = "select posicao, to_char(producao, 'FM999G999G999D90') producao  from ( select r.posicao, sum(r.producao) producao from relatorio r where  descricao in ('FRETE ATE 5 KM','FRETE ATE 10 KM') GROUP BY POSICAO ORDER BY PRODUCAO desc)", nativeQuery = true)
	List<RelatorioLimited> findProductionByBiggerValue();
}






