package Player;

import Console.Console;
import Cup.Cup;

public class Player {
    static int DICE_NUMBER = 7;
    private Cup cup;
    private String name;
    Console console = new Console();
    public Player(String name) {
        this.name = name;
        cup = new Cup(DICE_NUMBER);
    }

    //shake
    public void roll() {
        cup.roll();
    }

    //peek
    public void peek() {
        cup.peek();
    }

    //make claim
    //get from user two ints one for die value 1 - 6 and one for amount 1 - max dice
    public int[] getClaim() {
        int dieValue, dieCount;


        dieValue = console.getInt(1, 6, "What die value: 1-6");
        dieCount = console.getInt(1, 14, "How many " + dieValue + " dice:");

        return new int[] {dieValue, dieCount};
    }

    //decide if call out lie or play
    public boolean getDecision() {
        return console.getYN("l", "p",
                "Do you call the previous claim? liar or play");
    }

    public boolean isOut() {
        return cup.size() <= 0;
    }

    public String getName() {
        return name;
    }
}
