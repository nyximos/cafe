package coffee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum Size {
    TALL(BigDecimal.ZERO),
    GRANDE(BigDecimal.valueOf(500)),
    VENTI(BigDecimal.valueOf(1000))
    ;

    private final BigDecimal extraCharge;
}
