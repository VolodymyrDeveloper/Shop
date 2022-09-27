package pasichnyk;

public class Computer extends ElectronicsProduct {

    private final int discountProcent = 95;

    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction, int garanteePerion) {
        super(name, price, quantity, ageRestriction, garanteePerion = 24);
    }


    @Override
    public double getPrise() {
        if (getQuantity() >= 1000)
            return getPrice() * discountProcent / 100;
        else
            return getPrice();
    }
}
