package exceptions;

public class FalseMoveException extends Throwable {
    public FalseMoveException(){
        super("False move");
    }
    public FalseMoveException(String s){
        super(s);
    }
    public FalseMoveException(Throwable e){
        super(e);
    }
    public FalseMoveException(String s,Throwable e){
        super(s,e);
    }
}
