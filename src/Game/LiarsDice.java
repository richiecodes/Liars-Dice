package Game;

import Console.Console;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiarsDice {
    public List<Player> players;
    private Console console = new Console();
    private int[] claim;
    //private Scanner scan = new Scanner(System.in);

    public LiarsDice(int playerCount) {
        players = new ArrayList<>();
        for(int i = 0; i < playerCount; i++) {
            players.add(new Player(console.getString("Enter player " + (i + 1) + "s name:")));
        }
        runRound();
    }

    public void runRound() {
        shakeAllCups();
        System.out.println(players.get(0).getName() + "'s turn");
        players.get(0).peek();
        claim = players.get(0).getClaim();
        while (true) {
            //runTurn(players.get(activePlayer));
        }
        // lie called
        // confirm if claim is a lie
        // remove die from loser
        // remove player if out
        // determine if there are enough players to continue
    }

    public void runTurn(Player player) {
        console.getString(player.getName() + "'s turn press enter to continue");
        player.peek();
        boolean decision = player.getDecision();

        if(decision) {
            // called lie end turns
            return;
        }

        int[] newClaim = player.getClaim();
        //validateClaim if invalid ask for new claim
        isValidClaim(newClaim, player);
        // new claim must increment either the value or the count of the previous claim
        // if the value is raised the count can be any number
        // if only the count is raised it must be higher than previous count

    }

    //work on this
    private boolean isValidClaim(int[] newClaim, Player player) {
        return false;
    }

    private void shakeAllCups() {
        for(var player : players) {
            player.roll();
        }
    }
}