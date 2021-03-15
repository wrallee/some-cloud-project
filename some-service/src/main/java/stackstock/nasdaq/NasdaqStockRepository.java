package stackstock.nasdaq;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NasdaqStockRepository extends ReactiveCrudRepository<NasdaqStock, String> {
}
