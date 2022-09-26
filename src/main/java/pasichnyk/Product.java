package pasichnyk;

import pasichnyk.ProductInterface.Buyable;

public abstract class Product implements Buyable {

    public Product(String name, double price, int quantity,AgeRestriction ageRestriction ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction= ageRestriction;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum AgeRestriction

    {
        NONE, TEENAGER, ADULT;
    }
    AgeRestriction ageRestriction;

    private final String name;
    private final double price;
    private final int quantity;


}
