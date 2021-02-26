package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tacos.client.IngredientServiceClient;

@SpringBootApplication
public class IngredientClientApplication implements CommandLineRunner {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	IngredientServiceClient ingredientServiceClient;

	@Override
	public void run(String... args) throws Exception {
		String result = ingredientServiceClient.getHelloMessage();
		System.out.println(result);
	}

	public static void main(String[] args) {
		SpringApplication.run(IngredientClientApplication.class, args);
	}

}
