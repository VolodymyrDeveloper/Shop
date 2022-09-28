package pasichnyk;

import pasichnyk.ProductInterface.Buyable;

public abstract class Product implements Buyable {

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(String name, double priceProduct, int quantity, AgeRestriction ageRestriction ) {
        this.name = name;
        this.priceProduct = priceProduct;
        this.quantity = quantity;
        this.ageRestriction= ageRestriction;
    }


    @Override
    public String toString() {
        return "Product{" +
                "ageRestriction=" + ageRestriction +
                ", name='" + name + '\'' +
                ", price=" + priceProduct +
                ", quantity=" + quantity +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum AgeRestriction

    {
        NONE, TEENAGER, ADULT;
    }
    AgeRestriction ageRestriction;

    private String name;
    private double priceProduct;
    private int quantity;


}
