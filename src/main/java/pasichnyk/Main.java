package pasichnyk;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        FoodProduct apple = new FoodProduct("Apricot", 20, 100, Product.AgeRestriction.NONE, new Date(2022, 9, 28));

        System.out.println(apple.getPrise());



    }


    static class PurchaseManager {

        void processPurchase(Product product, Customer customer) {

        }
    }
}