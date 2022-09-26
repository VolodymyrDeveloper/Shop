package pasichnyk.Exeption;

public class BuyerDoesNotHavePermissionExeption extends  Exception{
    public BuyerDoesNotHavePermissionExeption(String message) {
        super(message);
    }
}
