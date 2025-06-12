package order;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
public class OrderCalculator {

    public static final OrderCalculator INSTANCE = new OrderCalculator();

    public BigDecimal calculate(List<OrderProduct> products) {
        return products.stream()
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
