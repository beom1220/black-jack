package person;

import card.Card;

import java.util.ArrayList;

public abstract class Person {
    public ArrayList<Card> handCard = new ArrayList<>();
    public int score;
    public abstract boolean hitOrStand(int check);
}
