package tacos.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IngredientServiceClient {

    private RestTemplate rest;

    public IngredientServiceClient(@LoadBalanced RestTemplate rest) {
        this.rest = rest;
    }

    public String getHelloMessage() {
        return rest.getForObject("http://ingredient-service/", String.class);
    }
}
