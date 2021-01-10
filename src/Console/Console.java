package Console;

import java.util.Scanner;

public class Console {
     Scanner scan = new Scanner(System.in);

    public int getInt(int min, int max, String query){
        int value = 0;
        do {
            System.out.println(query);
            value = scan.nextInt();
        } while(value < min || value > max);

        return value;
    }

    public boolean getYN(String yes, String no, String query) {
        String input = "";
        do {
            System.out.println(query);
            input = scan.nextLine();
        } while(!input.equals(yes) && !input.equals(no));

        return input.equals(yes);
    }

    public String getString(String query) {
        System.out.println(query);
        return scan.nextLine();
    }
}

//getInt(1, 4, "i want a number")

//output
// i want number
// 0 reask
// 5 reask
// 3 return 3
