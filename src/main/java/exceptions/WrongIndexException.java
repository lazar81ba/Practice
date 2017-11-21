package exceptions;

/**
 * Created by komputer on 21.11.2017.
 */
public class WrongIndexException extends Throwable {
    public WrongIndexException(){
        super("Wrong index given");
    }
    public WrongIndexException(String s){
        super(s);
    }
    public WrongIndexException(Throwable e){
        super(e);
    }
    public WrongIndexException(String s,Throwable e){
        super(s,e);
    }

}
