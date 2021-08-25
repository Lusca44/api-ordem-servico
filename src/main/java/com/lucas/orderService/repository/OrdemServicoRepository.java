package com.lucas.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.orderService.domain.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer>{

}
