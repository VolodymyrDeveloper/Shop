package pasichnyk;

import pasichnyk.Exeption.BuyerDoesNotHaveEnoughtMoneyExeption;
import pasichnyk.Exeption.BuyerDoesNotHavePermissionExeption;
import pasichnyk.Exeption.ProductHasExpiredExeption;
import pasichnyk.Exeption.ProductIsOutOfStockExeption;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ProductIsOutOfStockExeption, BuyerDoesNotHaveEnoughtMoneyExeption, BuyerDoesNotHavePermissionExeption, ProductHasExpiredExeption, ParseException {

        Customer vasil = new Customer("Vasil", 17, 30.00);
        Customer petro = new Customer("Petro", 18, 0.44);

        FoodProduct cigars = new FoodProduct("Winston", 6.90, 1400, Product.AgeRestriction.ADULT);
        FoodProduct chocolate = new FoodProduct("Rochen", 20, 10, Product.AgeRestriction.NONE);
        FoodProduct apple = new FoodProduct("Apple", 10, 100, Product.AgeRestriction.NONE, "30/09/2022");
        FoodProduct berry = new FoodProduct("Strawberry", 100, 5, Product.AgeRestriction.NONE);
        FoodProduct alcohol = new FoodProduct("Wiski", 1100, 10, Product.AgeRestriction.ADULT);


        Computer computer1 = new Computer("LG", 5000, 1500, Product.AgeRestriction.NONE);
        Computer computer2 = new Computer("LG", 5000, 999, Product.AgeRestriction.NONE);
        Appliance phone = new Appliance("Apple", 850, 60, Product.AgeRestriction.NONE);
        Appliance phone2 = new Appliance("Sumsung", 850, 40, Product.AgeRestriction.NONE);

        List<Product> productList = new ArrayList<>();
        productList.add(cigars);
        productList.add(chocolate);
        productList.add(computer1);
        productList.add(computer2);
        productList.add(phone);
        productList.add(phone2);
        productList.add(apple);
        productList.add(berry);
        productList.add(alcohol);

        System.out.println("The price computer " + computer1.getName() + " " + computer1.getPrice()); //Returns 95% of the price because the quantity is over 1000.
        System.out.println("The price computer " + computer2.getName() + " " + computer2.getPrice()); //Returns 100% of the price because the quantity is less 1000.
        System.out.println("The price phone " + phone.getName() + " " + phone.getPrice()); //Returns 100% of the price because the quantity is over 50.
        System.out.println("The price phone " + phone2.getName() + " " + phone2.getPrice()); //Returns 105% of the price because the quantity is less than 50.

        System.out.println("We set date on cigare " + "10/15/2022");
        cigars.setExpirDate("10/15/2022");
        System.out.println(cigars.getPrice());//Returns 70% of the price because the product expires in 15 days time.

        PurchaseManager.processPurchase(vasil, cigars);
        PurchaseManager.processPurchase(petro, cigars);

        chocolate.setExpirDate("09/28/2022");
        apple.setExpirDate("10/01/2022");
        berry.setExpirDate("10/10/2022");



//        PurchaseManager.processPurchase(petro, chocolate);
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

        public static void processPurchase(Customer customer, FoodProduct foodProduct) throws ProductHasExpiredExeption, ParseException {
            if (foodProduct.culcDaysSuitabilityofProduct() <= 0) {
                throw new ProductHasExpiredExeption("\n" + "The product has expired");
            } else {
                customer.setBalance(customer.getBalance() - foodProduct.getPriceProduct());
            }
            foodProduct.setQuantity(foodProduct.getQuantity() - 1);
        }
    }
}


