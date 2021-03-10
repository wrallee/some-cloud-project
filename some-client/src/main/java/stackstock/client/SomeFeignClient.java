package stackstock.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("some-service")
public interface SomeFeignClient {
    @GetMapping("/")
    String getHelloMessage();
}

