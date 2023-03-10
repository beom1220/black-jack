package person;

public class Dealer extends Person {
    @Override
    public boolean selectHit() {
        return (getScore()<=16);
    }
}
