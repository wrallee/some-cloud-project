package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import tacos.client.SomeServiceClient;

@SpringBootApplication
public class SomeClientApplication implements CommandLineRunner {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Autowired
	SomeServiceClient someServiceClient;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("RestTemplate - " + someServiceClient.getRestTemplateHelloMessage());
		someServiceClient.getWebClientHelloMessage().subscribe(
				s-> System.out.println("WebClient - " + s)
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(SomeClientApplication.class, args);
	}

}
