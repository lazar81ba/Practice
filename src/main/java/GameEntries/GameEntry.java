package GameEntries;

public class GameEntry {

    @Override
    public String toString() {
        return "(" + name + ',' + score +')';
    }

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public GameEntry(String name, int score){
        this.name=name;
        this.score=score;
    }
}
