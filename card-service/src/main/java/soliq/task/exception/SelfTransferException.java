package soliq.task.exception;

public class SelfTransferException extends RuntimeException {
    
    public SelfTransferException(String errMsg) {
        super(errMsg);
    }
    
}
