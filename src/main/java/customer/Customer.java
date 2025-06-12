package customer;

import cafe.Cafe;
import lombok.Getter;
import order.Order;
import order.OrderStatus;

import java.math.BigDecimal;

@Getter
public class Customer {

    private final Cafe cafe = Cafe.getInstance();

    private Wallet wallet;
    private Order order;

    public Customer(int money) {
        this.wallet = new Wallet(BigDecimal.valueOf(money));
    }

    public void pay(Order order) {
        try {
            wallet.pay(order.getAmount());
            this.order = order;
            cafe.receive(order.getAmount());
            order.setStatus(OrderStatus.IN_PROGRESS);
        } catch (IllegalStateException e) {
            order.setStatus(OrderStatus.ORDER_CANCELED);
            throw e;
        }
    }


}
