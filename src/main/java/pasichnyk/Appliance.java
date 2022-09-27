package pasichnyk;

public class Appliance extends ElectronicsProduct {

    private final int priceConversionPercentage = 105;

    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction, int garanteePerion) {
        super(name, price, quantity, ageRestriction, garanteePerion = 6);
    }

    @Override
    public double getPrise() {
        if (getQuantity() <= 50) {
            return getPrice() * priceConversionPercentage / 100;
        } else
            return getPrice();
    }

}
