package pasichnyk.Exeption;

public class BuyerDoesNotHaveEnoughtMoneyExeption extends Exception{
    public BuyerDoesNotHaveEnoughtMoneyExeption(String message) {
        super(message);
    }
}
