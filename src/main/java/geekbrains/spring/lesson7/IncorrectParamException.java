package geekbrains.spring.lesson7;

public class IncorrectParamException extends RuntimeException{
    public IncorrectParamException(String msg) {
        super(msg);
    }
}
