package person;

public class Dealer extends Person {
    @Override
    public boolean hitOrStand(int score) {
        return (score<=16);
    }
}
