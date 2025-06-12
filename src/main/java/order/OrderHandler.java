package order;

import cafe.Staff;
import cafe.StaffStatus;
import coffee.Coffee;
import coffee.Size;
import coffee.TemperatureType;
import customer.Customer;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OrderHandler {

    private final MenuValidator menuValidator;

    public void handle(Staff orderStaff, Customer customer) throws IOException, InterruptedException {
        List<OrderProduct> orderProducts = order(orderStaff);
        Order order = new Order(customer, orderProducts);
        orderStaff.say("총 " + order.getQuantity() + "잔, " + order.getAmount() + "원 입니다.");
        try {
            Thread.sleep(1000);
            customer.pay(order);
            Thread.sleep(1000);
            orderStaff.say("결제 완료됐습니다. 주문하신 메뉴 곧 준비해드리겠습니다~ 감사합니다😇");
            orderStaff.updateStatus(StaffStatus.WAITING);
        } catch (IllegalStateException e) {
            orderStaff.say("잔액이 부족합니다🥵 다음에 또 찾아와주세요!!😭");
            Thread.sleep(1000);
        }
    }

    private List<OrderProduct> order(Staff orderStaff) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<OrderProduct> orderProducts = new ArrayList<>();
        boolean isContinue = true;
        while (isContinue) {
            orderStaff.say("메뉴명을 입력해주세요.");
            Coffee coffee = this.menuValidator.validate(br);

            orderStaff.say("사이즈를 입력해주세요. ( TALL / GRANDE / VENTI)");
            Size size = Size.valueOf(br.readLine().toUpperCase());

            orderStaff.say("HOT / ICE");
            TemperatureType temperatureType = TemperatureType.valueOf(br.readLine().toUpperCase());

            orderStaff.say("수량을 입력해주세요.");
            int count = Integer.parseInt(br.readLine());

            orderProducts.add(new OrderProduct(coffee, size, count, temperatureType));

            orderStaff.say("더 주문하시겠어요? (네 / 아니요)");
            isContinue = br.readLine().equals("네") ? true : false;
        }
        return orderProducts;
    }
}
