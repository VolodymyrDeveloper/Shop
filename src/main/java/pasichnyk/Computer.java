package pasichnyk;

public class Computer extends ElectronicsProduct {

    private final int discountProcent = 95;

    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name,
                price,
                quantity,
                ageRestriction);
        this.garanteePerion = 24;
    }


    @Override
    public double getPrice() {
        if (getQuantity() >= 1000)
            return getPriceProduct() * discountProcent / 100;
        else
            return getPriceProduct();
    }
}
