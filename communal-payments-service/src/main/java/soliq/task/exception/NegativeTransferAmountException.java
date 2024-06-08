package soliq.task.exception;

public class NegativeTransferAmountException extends RuntimeException {
    
    public NegativeTransferAmountException(String errMsg) {
        
        super(errMsg);
    }
    
}
