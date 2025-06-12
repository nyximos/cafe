package cafe;

import lombok.NoArgsConstructor;
import order.Order;

@NoArgsConstructor
public class Barista {

    public static final Barista INSTANCE = new Barista();

    public void make(Staff staff, Order order) throws InterruptedException {
        // Todo
        Thread.sleep(2000);
        staff.say("주문하신 음료 나왔습니다~🧚");
    }
}
