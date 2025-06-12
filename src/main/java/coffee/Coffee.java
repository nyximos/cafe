package coffee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Coffee {
    private String name;
    private String description;
    private BigDecimal price;

    public Coffee(String name, int price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    @Override
    public String toString() {
        return new StringBuilder(name)
                .append(" ")
                .append(price)
                .append("원 ")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
