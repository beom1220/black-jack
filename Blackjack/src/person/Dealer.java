package person;

public class Dealer extends Person {
    @Override
    public boolean hitSelect() {
        return (getScore()<=16);
    }
}
