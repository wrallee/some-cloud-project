package tacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("some-service")
public interface SomeFeignClient {
    @GetMapping("/")
    String getHelloMessage();
}

