package customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import payment.AmountValidator;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Wallet {
    private final AmountValidator amountValidator = AmountValidator.INSTANCE;

    private BigDecimal amount;

    public void pay(BigDecimal orderAmount) {
        amountValidator.validate(amount, orderAmount);
        this.amount = this.amount.subtract(orderAmount);
    }
}
