package arrays;

import exceptions.FalseMoveException;

import java.util.Arrays;

public class TicTacToe {
    private final int X=1,O=-1;
    private final int EMPTY = 0;
    private int currentPlayerMark;

    private final int board[][] = new int[3][3];

    private static class Pair{
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pair(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }

    private enum Directions{
        UP, DOWN, LEFT, RIGHT,DOWNRIGHT,DOWNLEFT,UPRIGHT;

        public Pair returnCoordinates(){
            switch(this){
                case UP:
                    return new Pair(-1,0);
                case DOWN:
                    return new Pair(1,0);
                case LEFT:
                    return new Pair(0,-1);
                case RIGHT:
                    return new Pair(0,1);
                case DOWNRIGHT:
                    return new Pair(1,1);
                case DOWNLEFT:
                    return new Pair(1,-1);
                case UPRIGHT:
                    return new Pair(-1,1);
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    }

    public TicTacToe(String firstPlayerMark) {
        this.currentPlayerMark=X;
        if(firstPlayerMark.equals("O"))
            this.currentPlayerMark = O;
        clearBoard();
    }

    private void clearBoard() {
        for(int i=0;i<3;i++)
            Arrays.fill(board[i],EMPTY);
    }

    public void makeMove(int i, int j) throws FalseMoveException {
        if(i<0||j<0||i>2||j>2)
            throw new FalseMoveException();
        if(board[i][j]==EMPTY)
            board[i][j] = currentPlayerMark;
        else throw new FalseMoveException();
        if(checkIfDraw()){
            displayBoard();
            System.out.println("Remis" );
        }
        if(!checkBoard()) {
            changePlayer();
        } else{
            displayBoard();
            char current = currentPlayerMark==X?'X':'O';
            System.out.println("Wygrał gracz " + current );
        }
    }

    public void displayBoard() {
        StringBuilder builder = new StringBuilder();
        for(int x=0;x<3;x++) {
            for (int y = 0; y < 3; y++) {
                if(board[y][x]!=EMPTY){
                    char current = board[y][x] == X ? 'X' : 'O';
                    builder.append(current);
                }else
                    builder.append(' ');
                if(y!=2)
                    builder.append('|');
            }
            if(x!=2)
                builder.append(System.lineSeparator()).append("- - -").append(System.lineSeparator());
        }
        System.out.print(builder.toString());
    }

    private boolean checkBoard() {
        return checkMostImportantVerticalPoints()||
                checkMostImportantHorizontalPoints();
    }

    private boolean checkIfDraw() {
        boolean result=true;
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                if(board[x][y]==EMPTY)
                    result=false;
        return result;
    }

    private void changePlayer(){
        currentPlayerMark = currentPlayerMark==X?O:X;
    }

    private boolean checkMostImportantHorizontalPoints() {
       return checkPointInDirection(0,0,Directions.DOWN.returnCoordinates())||
            checkPointInDirection(0,0,Directions.RIGHT.returnCoordinates())||
            checkPointInDirection(0,0,Directions.DOWNRIGHT.returnCoordinates())||
            checkPointInDirection(0,1,Directions.DOWN.returnCoordinates())||
            checkPointInDirection(0,2,Directions.DOWN.returnCoordinates());

    }

    private boolean checkMostImportantVerticalPoints() {
        return checkPointInDirection(1,0,Directions.RIGHT.returnCoordinates())||
            checkPointInDirection(2,0,Directions.RIGHT.returnCoordinates())||
            checkPointInDirection(2,0,Directions.UPRIGHT.returnCoordinates());
    }

    private boolean checkPointInDirection(int x, int y, Pair coordinates) {
        int firstMark = board[x][y];
        if(firstMark!=EMPTY) {
            int counts = 1;
            for (int k = 0; k < 2; k++){
                x+=coordinates.getX();
                y+=+coordinates.getY();
                counts = firstMark==board[x][y]?counts+1:counts;
            }
            if(counts==3)
                return true;
        }
        return false;
    }

}
