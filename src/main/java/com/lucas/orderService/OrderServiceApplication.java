package com.lucas.orderService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.orderService.domain.Cliente;
import com.lucas.orderService.domain.OrdemServico;
import com.lucas.orderService.domain.Tecnico;
import com.lucas.orderService.domain.enums.Prioridade;
import com.lucas.orderService.domain.enums.Status;
import com.lucas.orderService.repository.ClienteRepository;
import com.lucas.orderService.repository.OrdemServicoRepository;
import com.lucas.orderService.repository.TecnicoRepository;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private OrdemServicoRepository osRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Lucas Santos", "370.067.500-32", "(21) 97569-4934");
		Cliente c1 = new Cliente(null, "Gabriela Penaforte", "180.195.750-90", "(21) 97569-4934");
		
		
		
		OrdemServico os = new OrdemServico(null, Prioridade.ALTA, "Teste mock dados", Status.ABERTO, t1, c1);
		
		t1.getOrdermServico().add(os);
		c1.getOrdemServico().add(os);
		
		tecRepo.saveAll(Arrays.asList(t1));
		cliRepo.saveAll(Arrays.asList(c1));
		osRepo.saveAll(Arrays.asList(os));
	}

}
