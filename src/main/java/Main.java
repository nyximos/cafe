import cafe.Cafe;

import customer.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Cafe cafe = Cafe.getInstance();

        System.out.print("금액을 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        while (money != 0) {
            Customer customer = new Customer(money);
            cafe.enter(customer);
            System.out.print("\n금액을 입력해주세요! 종료하려면 0을 입력해주세용 :");
            money = Integer.parseInt(br.readLine());
        }
        System.out.print("오늘의 총 매출은 " + cafe.getTotalSales() + "원 입니다.👏👏👏");
    }
}
