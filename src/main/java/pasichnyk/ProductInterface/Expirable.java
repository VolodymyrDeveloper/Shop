package pasichnyk.ProductInterface;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Date;

public interface Expirable {
     Date getExpirationDate() throws ParseException;
}
