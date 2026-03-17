package PW_9.Task_4;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Price {
    BigDecimal amount;
    String currency;
}