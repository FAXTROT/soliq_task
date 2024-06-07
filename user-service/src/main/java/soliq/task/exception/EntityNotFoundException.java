package soliq.task.exception;

public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(String errMsg) {
        super(errMsg);
    }
    
}
