package soliq.task.exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String errMsg) {
        
        super(errMsg);
    }
    
}
