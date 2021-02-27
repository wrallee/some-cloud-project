package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tacos.client.SomeFeignClient;
import tacos.client.SomeServiceClient;

@SpringBootApplication
public class SomeClientApplication implements CommandLineRunner {

	@Autowired
	SomeServiceClient someServiceClient;

	@Autowired
	SomeFeignClient someFeignClient;

	@Override
	public void run(String... args) throws Exception {
		// RestTemplate
		System.out.println("RestTemplate - " + someServiceClient.getRestTemplateHelloMessage());

		// WebClient
		someServiceClient.getWebClientHelloMessage().subscribe(
				s-> System.out.println("WebClient - " + s)
		);

		// FeignClient
		System.out.println("FeignClient - " + someFeignClient.getHelloMessage());

	}

	public static void main(String[] args) {
		SpringApplication.run(SomeClientApplication.class, args);
	}

}
