package stackstock.nasdaq;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "nasdaq")
public class NasdaqStock {
    @Id
    private String id;
    private String code;
    private Double price;
    private Long tradeVolume;
}