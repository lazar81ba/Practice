package exceptions;

public class ScoreBoardOutOfBoundsException extends Throwable {
    public ScoreBoardOutOfBoundsException(){
        super("ScoreBoard out of bounds");
    }
    public ScoreBoardOutOfBoundsException(String s){
        super(s);
    }
    public ScoreBoardOutOfBoundsException(Throwable e){
        super(e);
    }
    public ScoreBoardOutOfBoundsException(String s,Throwable e){
        super(s,e);
    }
}
