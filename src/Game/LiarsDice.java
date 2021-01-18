package Game;

import Console.Console;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class LiarsDice {
    public List<Player> players;
    private Console console = new Console();
    final int CLAIM_VALUE = 0, CLAIM_COUNT = 1;
    private int[] claim;

    public LiarsDice(int playerCount) {
        players = new ArrayList<>();
        for(int i = 0; i < playerCount; i++) {
            players.add(new Player(console.getString("Enter player " + (i + 1) + "s name:")));
        }

        while (true) {
            boolean continueGame = runRound();
            if(!continueGame) break;
        }
    }

    public boolean runRound() {
        shakeAllCups();
        String playerName = players.get(0).getName();
        System.out.println(String.format("%s's turn", playerName));
        players.get(0).peek();
        claim = players.get(0).getClaim();
        int activePlayer = 1;
        while (true) {
            boolean continueRound = runTurn(players.get(activePlayer % players.size()));
            if (!continueRound) break;
            activePlayer++;
        }

        // confirm if claim is a lie
        if(isLie()) {
            activePlayer -= 1;
        }

        activePlayer = activePlayer % players.size();

        // remove die from loser
        players.get(activePlayer).removeDie();
        System.out.println(players.get(activePlayer).getName() + " just lost a die");

        // remove player if out
        if(players.get(activePlayer - 1).isOut()) {
            System.out.println(String.format("%s has been removed from the game", players.get(activePlayer).getName()));
            players.remove(activePlayer - 1);
        }

        // determine if there are enough players to continue
        if(players.size() == 1) {
            System.out.println("Game over " + players.get(0).getName() + " wins!");
            return false;
        }

        return true;
    }

    public boolean runTurn(Player player) {
        Console.cls();
        console.getString(player.getName() + "'s turn press enter to continue");
        Console.cls();
        player.peek();
        System.out.println("The current claim is " + claim[CLAIM_COUNT] + " " + claim[CLAIM_VALUE] + "s");
        boolean decision = player.getDecision();

        if(decision) {
            // called lie end turns
            return false;
        }

        int[] newClaim;

        while (true) {
            newClaim = player.getClaim();
            if(isValidClaim(newClaim))
                break;
        }

        claim = newClaim;
        return true;
    }
    //work on this
    private boolean isValidClaim(int[] newClaim) {
        if(newClaim[CLAIM_COUNT] == claim[CLAIM_COUNT] && newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE]) {
            System.out.println("Error: must be a new claim");
            return false;
        }

        if(newClaim[CLAIM_VALUE] < claim[CLAIM_VALUE]) {
            System.out.println("Die value must be same or increased");
            return false;
        }

        if(newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE] && claim[CLAIM_COUNT] > newClaim[CLAIM_COUNT]) {
            System.out.println("Error: Must increment at least one item");
            return false;
        }

        return true;
    }

    private void shakeAllCups() {
        for(var player : players) {
            player.roll();
        }
    }

    private boolean isLie() {
        int count = 0;
        for (var player : players) {
            count += player.countValue(claim[CLAIM_VALUE]);
        }

        return count < claim[CLAIM_COUNT];
    }
}