package pasichnyk;

import pasichnyk.ProductInterface.Expirable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {

    private final double procentDiscount = 70;

    private String expirDate;

    SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");

    public FoodProduct(String name, double priceProduct, int quantity, AgeRestriction ageRestriction, String expirDate) {
        super(name, priceProduct, quantity, ageRestriction);
        this.expirDate = expirDate;
    }

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    public String getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(String expirDate) {
        this.expirDate = expirDate;
    }

    @Override
    public Date getExpirationDate() throws ParseException {
        Date data = formatDate.parse(expirDate);
        return data;
    }

    public long culcDaysSuitabilityofProduct() throws ParseException {
        Date data = new Date();
        long days = getExpirationDate().getTime() - data.getTime();
        long daysSuitabilityofProduct = (days / (1000 * 60 * 60 * 24));
        return daysSuitabilityofProduct;
    }



    @Override
    public double getPrice() throws ParseException {
        if (culcDaysSuitabilityofProduct() <= 15)
            return getPriceProduct() * procentDiscount / 100;
        else
            return getPriceProduct();
    }


}


