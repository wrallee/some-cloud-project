package stackstock.nasdaq;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import stackstock.nasdaq.dto.NasdaqStockResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/nasdaq", produces = "application/json")
public class NasdaqStockController {

    private NasdaqStockService nasdaqStockService;

    @GetMapping
    public Flux<NasdaqStockResponseDto> allNasdaqStocks() {
        return nasdaqStockService.findAll().take(12);
    }

    @GetMapping("/{id}")
    public Mono<NasdaqStockResponseDto> nasdaqStockById(@PathVariable String id) {
        return nasdaqStockService.findById(id);
    }
}
