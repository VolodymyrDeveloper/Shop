package pasichnyk;

public abstract class ElectronicsProduct extends Product{

    int garanteePerion;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        this.garanteePerion = garanteePerion;
    }

    public int getGaranteePerion() {
        return garanteePerion;
    }

    public void setGaranteePerion(int garanteePerion) {
        this.garanteePerion = garanteePerion;
    }
}
