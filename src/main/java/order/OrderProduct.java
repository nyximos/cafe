package order;

import coffee.Coffee;
import coffee.Size;
import coffee.TemperatureType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderProduct {
    private Coffee coffee;
    private Size size;
    private int count;
    private TemperatureType temperatureType;

    public BigDecimal getPrice() {
        return this.coffee.getPrice()
                .add(this.size.getExtraCharge())
                .multiply(BigDecimal.valueOf(count));
    }
}
