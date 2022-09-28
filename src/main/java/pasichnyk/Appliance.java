package pasichnyk;

public class Appliance extends ElectronicsProduct {

    private final int priceConversionPercentage = 105;

    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);this.garanteePerion=6;
    }

    @Override
    public double getPrice() {
        if (getQuantity() <= 50) {
            return getPriceProduct() * priceConversionPercentage / 100;
        } else
            return getPriceProduct();
    }

}
