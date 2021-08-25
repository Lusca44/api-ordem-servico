package com.lucas.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.orderService.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
