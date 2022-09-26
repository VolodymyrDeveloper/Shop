package pasichnyk;

import pasichnyk.ProductInterface.Expirable;

import javax.xml.crypto.Data;

public class FoodProduct extends Product implements Expirable {
    public FoodProduct(String name, double price, int quantity, Product.AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    @Override
    public Data getExpirationDate() {
        return null;
    }

    @Override
    public double getPrise() {
        return 0;
    }
}
