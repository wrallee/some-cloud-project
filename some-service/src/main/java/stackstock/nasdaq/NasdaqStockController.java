package stackstock.nasdaq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/nasdaq", produces = "application/json")
public class NasdaqStockController {

    private NasdaqStockRepository nasdaqStockRepo;

    public NasdaqStockController(NasdaqStockRepository nasdaqStockRepo) {
        this.nasdaqStockRepo = nasdaqStockRepo;
    }

    @GetMapping
    public Flux<NasdaqStock> allNasdaqStocks() {
        return nasdaqStockRepo.findAll().take(12);
    }

    @GetMapping("/{id}")
    public Mono<NasdaqStock> nasdaqStockById(@PathVariable String id) {
        return nasdaqStockRepo.findById(id);
    }
}
