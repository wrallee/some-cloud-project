package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tacos.client.SomeFeignClient;
import tacos.client.SomeServiceClient;

@SpringBootApplication
public class SomeClientApplication implements CommandLineRunner {

	SomeServiceClient someServiceClient;
	SomeFeignClient someFeignClient;

	public SomeClientApplication(SomeServiceClient someServiceClient, SomeFeignClient someFeignClient) {
		this.someServiceClient = someServiceClient;
		this.someFeignClient = someFeignClient;
	}

	@Override
	public void run(String... args) throws Exception {
		// RestTemplate
		System.out.println("RestTemplate - " + someServiceClient.getRestTemplateHelloMessage());

		// FeignClient
		System.out.println("FeignClient - " + someFeignClient.getHelloMessage());

		// WebClient
		someServiceClient.getWebClientHelloMessage().subscribe(
				s-> System.out.println("WebClient - " + s)
		);

	}

	public static void main(String[] args) {
		SpringApplication.run(SomeClientApplication.class, args);
	}

}
