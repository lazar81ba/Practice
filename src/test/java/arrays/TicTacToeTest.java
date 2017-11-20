package arrays;

import exceptions.FalseMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {
    TicTacToe game ;

    @Before
    public void setUp(){
        game = new TicTacToe("X");
    }

    @Test(expected = FalseMoveException.class)
    public void testMakeTheSameMove() throws FalseMoveException {
        game.makeMove(2,0);
        game.makeMove(2,0);
    }

    @Test(expected = FalseMoveException.class)
    public void testMakeOutOFBoundsMove() throws FalseMoveException {
        game.makeMove(3,0);
    }

    @Test
    public void displayBoard(){
        try {
            game.makeMove(2,0);
            game.makeMove(1,0);
        } catch (FalseMoveException e) {
            e.printStackTrace();
        }
        game.displayBoard();
    }

    @Test
    public void testWinGameXPlayer(){
        try {
            game.makeMove(0,0);
            game.makeMove(0,1);
            game.makeMove(1,0);
            game.makeMove(0,2);
            game.makeMove(2,0);
        } catch (FalseMoveException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testWinGameOPlayer(){
        try {
            game.makeMove(1,0);
            game.makeMove(0,0);
            game.makeMove(2,0);
            game.makeMove(0,1);
            game.makeMove(2,1);
            game.makeMove(0,2);

        } catch (FalseMoveException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDraw(){
        try {
            game.makeMove(0,0);
            game.makeMove(2,0);
            game.makeMove(2,1);
            game.makeMove(1,2);
            game.makeMove(1,1);
            game.makeMove(0,1);
            game.makeMove(1,0);
            game.makeMove(2,2);
            game.makeMove(0,2);

        } catch (FalseMoveException e) {
            e.printStackTrace();
        }
    }

}