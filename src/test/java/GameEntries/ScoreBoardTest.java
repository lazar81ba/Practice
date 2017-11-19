package GameEntries;

import exceptions.ScoreBoardOutOfBoundsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreBoardTest {
    ScoreBoard scoreBoard = null;
    @Before
    public void setUp() throws Exception {
        scoreBoard = new ScoreBoard(3);
        scoreBoard.add(new GameEntry("Jacek",10));
        scoreBoard.add(new GameEntry("Tomek",11));
        scoreBoard.add(new GameEntry("Zdzisiek",9));
    }

    @Test
    public void testAddToFullScoreBoard(){
        scoreBoard.add(new GameEntry("Ania",12));

        String test = scoreBoard.toString();
        assertEquals("[(Ania,12), (Tomek,11), (Jacek,10)]",test);
    }

    @Test
    public void testAdd()  {
        String test = scoreBoard.toString();
        assertEquals("[(Tomek,11), (Jacek,10), (Zdzisiek,9)]",test);
    }

    @Test
    public void restRemoveFirstElement(){
        try {
            scoreBoard.remove(0);
        } catch (ScoreBoardOutOfBoundsException e) {
            e.printStackTrace();
        }
        String test = scoreBoard.toString();
        assertEquals("[(Jacek,10), (Zdzisiek,9), null]",test);
    }
    @Test
    public void restRemoveLastElement(){
        try {
            scoreBoard.remove(2);
        } catch (ScoreBoardOutOfBoundsException e) {
            e.printStackTrace();
        }
        String test = scoreBoard.toString();
        assertEquals("[(Tomek,11), (Jacek,10), null]",test);
    }
    @Test(expected = ScoreBoardOutOfBoundsException.class)
    public void restRemoveFromEmptyScoreBoard() throws ScoreBoardOutOfBoundsException {
        ScoreBoard testBoard = new ScoreBoard(3);
        testBoard.remove(0);
    }
    @Test(expected = ScoreBoardOutOfBoundsException.class)
    public void restRemovePassingFalseIndex() throws ScoreBoardOutOfBoundsException {
        scoreBoard.remove(5);
    }
}