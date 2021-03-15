package stackstock.nasdaq;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import stackstock.nasdaq.dto.NasdaqStockResponseDto;

@Service
@RequiredArgsConstructor
public class NasdaqStockService {
    private final NasdaqStockRepository nasdaqStockRepository;

    /*@HystrixCommand(
            fallbackMethod = "getDefaultNasdaqStocks",
            commandProperties = {
                    // 타임아웃 비활성화("cascading latency effect" 가 발생할 수 있다)
                    @HystrixProperty(name = "execution.timeout.enabled", value = "false")
            }
    )*/
    @HystrixCommand(
            fallbackMethod = "getDefaultNasdaqStocks",
            commandProperties = {
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "20000"),    // 지정된 시간
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "30"),         // 호출 횟수 임계치
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "25"),       // 호출 실퍠율 임계치
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000")     // 열림상태 유지 시간
            })
    public Flux<NasdaqStockResponseDto> findAll() {
        return nasdaqStockRepository.findAll().map(NasdaqStockResponseDto::new);
    }

    @HystrixCommand
    public Mono<NasdaqStockResponseDto> findById(String id) {
        return nasdaqStockRepository.findById(id).map(NasdaqStockResponseDto::new);
    }

    private Flux<NasdaqStockResponseDto> getDefaultNasdaqStocks() {
        return Flux.just(new NasdaqStockResponseDto());
    }

}
