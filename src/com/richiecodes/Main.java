package com.richiecodes;

import Console.Console;
import Cup.Cup;
import Player.Player;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("player1");
        player.roll();
        player.peek();
        int[] claim = player.getClaim();
        System.out.println("Player claimed there are " + claim[1] + " " + claim[0] + "s");
        boolean decision = player.getDecision();
        System.out.println(decision ? "Lie called" : "Play on");
    }
}