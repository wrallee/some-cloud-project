package stackstock.nasdaq.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import stackstock.nasdaq.NasdaqStock;

import java.util.Date;

@Getter
@NoArgsConstructor
public class NasdaqStockResponseDto {
    private String id;
    private String code;
    private Double price;
    private Long tradeVolume;

    public NasdaqStockResponseDto(NasdaqStock document) {
        this.id = document.getId();
        this.code = document.getCode();
        this.price = document.getPrice();
        this.tradeVolume = document.getTradeVolume();
    }
}
