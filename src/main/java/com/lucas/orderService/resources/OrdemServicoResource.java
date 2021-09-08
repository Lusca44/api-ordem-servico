package com.lucas.orderService.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.orderService.dtos.OrdemServicoDTO;
import com.lucas.orderService.services.OrdemServicoService;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService service;

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> findById(@PathVariable Integer id) {
		OrdemServicoDTO objDTO = new OrdemServicoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}

	@GetMapping
	public ResponseEntity<List<OrdemServicoDTO>> findAll() {
		List<OrdemServicoDTO> listDTO = service.findAll().stream().map(obj -> new OrdemServicoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
