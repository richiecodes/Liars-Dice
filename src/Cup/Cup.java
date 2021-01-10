package Cup;

import Die.Die;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cup {
    private List<Die> dice;

    public Cup(int diceNum) {
        dice = new ArrayList<>();
        for (int i = 0; i < diceNum; i++) {
            addDie();
        }
    }

    public void addDie() {
        dice.add(new Die());
    }

    public void removeDie() {
        dice.remove(dice.size() - 1);
    }

    public void roll() {
        for(var die : dice) {
            die.roll(new Random());
        }
    }

    public void peek() {
        String output = "";

        for(var die : dice) {
            output += die.getValue() + " ";
        }

        System.out.println(output.trim());
    }

    public int size(){
        return dice.size();
    }
}
