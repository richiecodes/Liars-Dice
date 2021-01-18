package com.richiecodes;

import Console.Console;
import Cup.Cup;
import Game.LiarsDice;
import Player.Player;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        LiarsDice game = new LiarsDice(console.getInt(2, 5, "How many players?"));
    }
}