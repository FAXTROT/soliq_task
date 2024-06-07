package soliq.task.exception;

public class ZeroTransferAmountException extends RuntimeException {
    
    public ZeroTransferAmountException(String errMsg) {
        super(errMsg);
    }
    
}
