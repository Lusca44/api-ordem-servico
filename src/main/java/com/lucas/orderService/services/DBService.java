package com.lucas.orderService.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.Cliente;
import com.lucas.orderService.domain.OrdemServico;
import com.lucas.orderService.domain.Tecnico;
import com.lucas.orderService.domain.enums.Prioridade;
import com.lucas.orderService.domain.enums.Status;
import com.lucas.orderService.repository.ClienteRepository;
import com.lucas.orderService.repository.OrdemServicoRepository;
import com.lucas.orderService.repository.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private OrdemServicoRepository osRepo;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Lucas Santos", "370.067.500-32", "(21) 97569-4931");
		Tecnico t2 = new Tecnico(null, "Alvinho cocudo", "285.645.170-51", "(21) 97569-4932");
		Cliente c1 = new Cliente(null, "Gabriela Penaforte", "180.195.750-90", "(21) 97569-4933");

		OrdemServico os = new OrdemServico(null, Prioridade.ALTA, "Teste mock dados", Status.ABERTO, t1, c1);

		t1.getOrdermServico().add(os);
		c1.getOrdemServico().add(os);

		tecRepo.saveAll(Arrays.asList(t1, t2));
		cliRepo.saveAll(Arrays.asList(c1));
		osRepo.saveAll(Arrays.asList(os));

	}
}
