package br.com.drsolutions.wsdlcliente;

import br.com.drsolutions.wsdlcliente.wsdl.GetPaisResponse;

import br.com.drsolutions.wsdlcliente.clients.PaisClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClienteApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(PaisClient quoteClient) {
		return args -> {
			String pais = "Brasil";
			
			GetPaisResponse response = quoteClient.getPais(pais);
			
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());

			response = quoteClient.getPais("Reino Unido");
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());
			
			response = quoteClient.getPais("França");
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());
		};
	}

}
