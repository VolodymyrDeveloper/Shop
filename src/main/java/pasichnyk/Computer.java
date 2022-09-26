package pasichnyk;

import pasichnyk.ElectronicsProduct;

public class Computer extends ElectronicsProduct {

    private final int discountProcentFromPrise = 5;
    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction, int garanteePerion) {
        super(name, price, quantity, ageRestriction, garanteePerion = 24);
    }


    @Override
    public double getPrise() {
        if (getQuantity()>1000)
            return getPrice()*(100-discountProcentFromPrise/100);
        else
        return getPrice()
                ;
    }
}
