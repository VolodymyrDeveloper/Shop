package pasichnyk;

import pasichnyk.ProductInterface.Expirable;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class FoodProduct extends Product implements Expirable {

    private final double procentDiscount = 70;

    SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy", Locale.UK);



    private Date expirDate;





    public Date getExpirDate() {
        return expirDate;
    }

        public void setExpirDate(Date expirDate) throws ParseException {
        this.expirDate = formatDate.parse(expirDate.toString());
    }
    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        this.expirDate = expirDate;

    }

    public long calculateExpirationDays(){

    }



    @Override
    public Date getExpirationDate() throws ParseException {

        Date data = formatDate.parse(new Date().toString());

        return getExpirDate();
       }


    @Override
    public double getPrice() {
        Date data = new Date();
        long days = data.getTime()-expirDate.getTime();
        if (days<=15){
            return getPriceProduct() * procentDiscount / 100;}
        else
            return getPriceProduct();
    }



}
