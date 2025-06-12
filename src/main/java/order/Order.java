package order;

import customer.Customer;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {
    private final OrderCalculator orderCalculator = OrderCalculator.INSTANCE;

    private Customer customer;
    private List<OrderProduct> products;
    private OrderStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public Order(Customer customer, List<OrderProduct> products) {
        this.customer = customer;
        this.products = products;
        this.status = OrderStatus.READY;
        this.amount = orderCalculator.calculate(products);
        this.createdAt = LocalDateTime.now();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getQuantity() {
        return products.stream()
                .map(products -> products.getCount())
                .reduce(0, Integer::sum);
    }
}
