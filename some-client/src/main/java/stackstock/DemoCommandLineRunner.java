package stackstock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import stackstock.client.SomeFeignClient;
import stackstock.client.SomeServiceClient;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    SomeServiceClient someServiceClient;
    SomeFeignClient someFeignClient;

    public DemoCommandLineRunner(SomeServiceClient someServiceClient, SomeFeignClient someFeignClient) {
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

}
