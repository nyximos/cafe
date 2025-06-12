package order;

import coffee.Coffee;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class MenuValidator {

    private final List<Coffee> menu;

    public Coffee validate(BufferedReader br) throws IOException {
        while (true) {
            String coffeeName = br.readLine();

            Optional<Coffee> coffee = this.menu.stream()
                    .filter(coffee1 -> coffee1.getName().equals(coffeeName))
                    .findFirst();

            if (coffee.isPresent()) {
                return coffee.get();
            }
            System.out.println("없는 메뉴입니다. 메뉴명을 입력해주세요.");

        }
    }
}
