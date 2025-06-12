package payment;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class AmountValidator {

    public static final AmountValidator INSTANCE = new AmountValidator();

    public void validate(BigDecimal amount, BigDecimal orderAmount) {
        if (amount == null || amount.compareTo(orderAmount) < 0) {
            throw new IllegalStateException("잔액이 부족합니다!!!");
        }
    }
}
