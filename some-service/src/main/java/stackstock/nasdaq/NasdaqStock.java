package stackstock.nasdaq;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "nasdaq")
public class NasdaqStock {
    @Id
    private String id;
    private String code;
    private Double price;
    private Long tradeVolume;
    private Date getDate = new Date();
}

