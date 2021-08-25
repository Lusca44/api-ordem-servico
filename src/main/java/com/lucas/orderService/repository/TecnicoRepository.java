package com.lucas.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.orderService.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
