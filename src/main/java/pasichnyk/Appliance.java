package pasichnyk;

import pasichnyk.ElectronicsProduct;

public class Appliance extends ElectronicsProduct {
    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction, int garanteePerion) {
        super(name, price, quantity, ageRestriction, garanteePerion = 6);
    }

    @Override
    public double getPrise() {
        return 0;
    }
}
