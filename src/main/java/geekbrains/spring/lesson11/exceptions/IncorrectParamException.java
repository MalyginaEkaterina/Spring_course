package geekbrains.spring.lesson11.exceptions;

public class IncorrectParamException extends RuntimeException{
    public IncorrectParamException(String msg) {
        super(msg);
    }
}
