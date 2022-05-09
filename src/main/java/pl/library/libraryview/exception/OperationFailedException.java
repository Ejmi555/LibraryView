package pl.library.libraryview.exception;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException() {
        super("Operation failed");
    }
}
