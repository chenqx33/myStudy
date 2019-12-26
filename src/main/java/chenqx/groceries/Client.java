package chenqx.groceries;

import java.text.NumberFormat;

/**
 * @author chenqx 2019-11-20
 * @instruction
 */
public class Client {
    public static void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 100.0F;
        System.out.println("简单折扣后的价格是：" + formateCurrency(knockdownPrice));
    }

    public static void calPrice(int price, int... discounts) {
        float knockdownPrice = price;
        for (int discount : discounts) {
            knockdownPrice = knockdownPrice * discount / 100;
        }
        System.out.println("复杂折扣后的价格是：" + formateCurrency(knockdownPrice));
    }

    private static String formateCurrency(float knockdownPrice) {
        return NumberFormat.getCurrencyInstance().format(knockdownPrice / 100);
    }

    public static void main(String[] args) {
        calPrice(49900, 75);
    }
}
