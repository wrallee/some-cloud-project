package stackstock.nasdaq;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NasdaqStockRepository extends ReactiveCrudRepository<NasdaqStock, String> {

    Mono<NasdaqStock> findById(String id);
    Flux<NasdaqStock> findFirstByCode(String code);
    Flux<NasdaqStock> findByCode(String code);
    Flux<NasdaqStock> deleteByCode(String code);

}
