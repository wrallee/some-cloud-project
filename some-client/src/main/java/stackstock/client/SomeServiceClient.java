package stackstock.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SomeServiceClient {

    private RestTemplate rest;
    private WebClient.Builder wcBuilder;

    public SomeServiceClient(@LoadBalanced RestTemplate rest,
                             @LoadBalanced WebClient.Builder wcBuilder) {
        this.rest = rest;
        this.wcBuilder = wcBuilder;
    }

    public String getRestTemplateHelloMessage() {
        return rest.getForObject("http://some-service/", String.class);
    }

    public Mono<String> getWebClientHelloMessage() {
        return wcBuilder.build()
                .get()
                .uri("http://some-service/")
                .retrieve().bodyToMono(String.class);
    }
}
