package geekbrains.spring.lesson9.exceptions;

public class IncorrectParamException extends RuntimeException{
    public IncorrectParamException(String msg) {
        super(msg);
    }
}
