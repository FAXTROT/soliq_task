package soliq.task.exception;

public class LowBalanceException extends RuntimeException{
    
    public LowBalanceException(String errMsg) {
        super(errMsg);
    }
    
}
