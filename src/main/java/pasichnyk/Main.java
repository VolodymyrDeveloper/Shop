package pasichnyk;

import pasichnyk.Exeption.BuyerDoesNotHaveEnoughtMoneyExeption;
import pasichnyk.Exeption.BuyerDoesNotHavePermissionExeption;
import pasichnyk.Exeption.ProductHasExpiredExeption;
import pasichnyk.Exeption.ProductIsOutOfStockExeption;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ProductIsOutOfStockExeption, BuyerDoesNotHaveEnoughtMoneyExeption, BuyerDoesNotHavePermissionExeption, ProductHasExpiredExeption {

        FoodProduct cigars = new FoodProduct("Winston", 6.90, 1400, Product.AgeRestriction.ADULT);

        Customer vasil = new Customer("Vasil", 17, 30.00);

        Customer petro = new Customer("Petro", 18, 0.44);

        Computer computer1 = new Computer("LG", 5000, 1500, Product.AgeRestriction.NONE);
        Computer computer2 = new Computer("LG", 5000, 999, Product.AgeRestriction.NONE);

        Appliance phone = new Appliance("Phone",850,60, Product.AgeRestriction.NONE);
        Appliance phone2 = new Appliance("Phone2",850,40, Product.AgeRestriction.NONE);

//
//        System.out.println(computer1.getPrice());
//        System.out.println(computer2.getPrice());
//        System.out.println(phone.getPrice());
//        System.out.println(phone2.getPrice());

        System.out.println(cigars.getExpirDate());
        cigars.setExpirDate("20 10 2022");
        System.out.println(new Date());
        cigars.calculateExpirationDays();
//        System.out.println(cigars.getExpirDate());
//        System.out.println(cigars.getPrice());

//       PurchaseManager.processPurchase(vasil, cigars);
//
//        PurchaseManager.processPurchase(petro, cigars);

    }


    static class PurchaseManager {
        public static void processPurchase(Customer customer, Product product) throws BuyerDoesNotHaveEnoughtMoneyExeption,
                BuyerDoesNotHavePermissionExeption, ProductHasExpiredExeption, ProductIsOutOfStockExeption {
            if (product.getQuantity() == 0) {
                throw new ProductIsOutOfStockExeption("\n" + "The product is out of stock (no quantity)");
            } else if (customer.getBalance() < product.getPriceProduct()) {
                throw new BuyerDoesNotHaveEnoughtMoneyExeption("\n" + "You do not have enough money to buy this product!");
            } else if (product.ageRestriction.equals(Product.AgeRestriction.ADULT) && customer.getAge() < 18) {
                throw new BuyerDoesNotHavePermissionExeption("\n" + "You are too young to buy this product");
            } else {
                customer.setBalance(customer.getBalance() - product.getPriceProduct());
                product.setQuantity(product.getQuantity() - 1);
            }

        }
    }
}