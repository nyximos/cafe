package customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private List<OrderProduct> products;
    private OrderStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
