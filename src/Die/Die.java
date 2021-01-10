package Die;

import java.util.Random;

public class Die {
    private int sides;
    private int value;

    public Die() {
        sides = 6;
        value = 1;
    }

    public void roll(Random rand) {
        value = rand.nextInt(sides) + 1;
    }

    public int getValue() {
        return value;
    }

}
