package pasichnyk;

import pasichnyk.ProductInterface.Expirable;

import java.time.temporal.Temporal;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class FoodProduct extends Product implements Expirable {

    private final double procentDiscount = 70;
    private final Date expirationDate;


    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, Date expirationDate) {
        super(name, price, quantity, ageRestriction);
        this.expirationDate = expirationDate;

    }

    @Override
    public Date getExpirationDate() {
      return expirationDate;
    }


    @Override
    public double getPrise() {
        java.util.Date date = new java.util.Date();
        long daysExpiration = DAYS.between(date.toInstant(), expirationDate.toInstant());
        if (daysExpiration<=15){
            return getPrice() * procentDiscount / 100;}
        else return getPrice();
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "procentDiscount=" + procentDiscount +
                ", expirationDate=" + expirationDate +
                '}';
    }

}
