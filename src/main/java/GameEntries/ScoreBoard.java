package GameEntries;

import exceptions.ScoreBoardOutOfBoundsException;

import java.util.Arrays;

public class ScoreBoard {
    private int numEntries = 0;

    @Override
    public String toString() {
        return Arrays.toString(board);
    }

    private GameEntry[] board;

    public ScoreBoard(int capacity){
        board = new GameEntry[capacity];
    }

    public void add(GameEntry entry) {
        int score = entry.getScore();
        if(numEntries<board.length||score>board[numEntries-1].getScore()){
            if(numEntries<board.length)
                numEntries++;
                int j = numEntries-1;
                while(j>0 && score>board[j-1].getScore()){
                    board[j]=board[j-1];
                    j--;
                }
                board[j]=entry;
            }

    }

    public GameEntry remove(int i)throws ScoreBoardOutOfBoundsException{
        if(i<0||i>=numEntries)
            throw new ScoreBoardOutOfBoundsException();
        GameEntry tmp = board[i];
        numEntries--;
        for(int j=i;j<numEntries;j++){
            board[j] = board[j+1];
        }
        board[numEntries]=null;
        return tmp;

    }
}
