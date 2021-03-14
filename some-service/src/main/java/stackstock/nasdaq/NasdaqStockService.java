package stackstock.nasdaq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import stackstock.nasdaq.dto.NasdaqStockResponseDto;

@Service
@RequiredArgsConstructor
public class NasdaqStockService {
    private final NasdaqStockRepository nasdaqStockRepository;

    public Flux<NasdaqStockResponseDto> findAll() {
        return nasdaqStockRepository.findAll().map(nasdaqStock -> {
            return new NasdaqStockResponseDto(nasdaqStock);
        });
    }

    public Mono<NasdaqStockResponseDto> findById(String id) {
        return nasdaqStockRepository.findById(id).map(nasdaqStock -> {
            return new NasdaqStockResponseDto(nasdaqStock);
        });
    }

}
