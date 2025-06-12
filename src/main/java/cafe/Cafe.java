package cafe;

import coffee.Coffee;
import customer.Customer;
import order.MenuValidator;
import order.Order;
import order.OrderHandler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Cafe {

    private static final List<Staff> staff = List.of(
            new Staff("🐯", true, true),
            new Staff("🦊", true, false),
            new Staff("🐰",false, true)
    );

    private static final List<Coffee> coffees = List.of(
            new Coffee("아메리카노", 3200),
            new Coffee("카페라떼", 4200),
            new Coffee("바닐라라떼", 4500)
    );

    private static final Cafe INSTANCE = new Cafe("어메스 카페", staff, coffees);

    public static Cafe getInstance() {
        return INSTANCE;
    }

    private final Barista barista = Barista.INSTANCE;

    private final String name;
    private final List<Coffee> menu;
    private final StaffSelector staffSelector;
    private final MenuValidator menuValidator;
    private final OrderHandler orderHandler;
    private BigDecimal totalSales;

    public Cafe(String name, List<Staff> staff, List<Coffee> coffees) {
        this.name = name;
        this.menu = coffees;
        this.totalSales = BigDecimal.ZERO;
        this.staffSelector = new StaffSelector(staff);
        this.menuValidator = new MenuValidator(this.menu);
        this.orderHandler = new OrderHandler(this.menuValidator);
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    private void getMenu() {
        System.out.println(menu.toString());
    }

    public void enter(Customer customer) throws InterruptedException, IOException {
        Staff orderStaff = staffSelector.selector(ActionType.ORDER);
        orderStaff.updateStatus(StaffStatus.CASHIERING);
        orderStaff.say("안녕하세요~ 주문하시겠어요?");
        Thread.sleep(1000);
        this.getMenu();
        Thread.sleep(1000);
        Order order = orderHandler.handle(orderStaff, customer);

        Staff baristaStaff = staffSelector.selector(ActionType.MAKE_COFFEE);
        CompletableFuture.runAsync(() -> {
            try {
                barista.make(baristaStaff, order);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void receive(BigDecimal amount) {
        this.totalSales = this.totalSales.add(amount);
    }

}