package competition;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import game.TicTacToe;
import game.TicTacToePlayer;
import org.reflections.Reflections;

public class Competition {

    private final Map<String, Integer> scores = new HashMap<>();

    /** Merge a new map of scores into the master map */
    public synchronized void mergeScores(Map<String, Integer> merge) {

        for (Map.Entry<String, Integer> entry : merge.entrySet()) {
            this.scores.put(
                entry.getKey(),
                this.scores.getOrDefault(entry.getKey(), 0) + entry.getValue()
            );
        }

    }

    private Map<String, Integer> getScores() {
        return this.scores;
    }

    /**
     * Get all classes in "opponents" package that are subtypes of {@link TicTacToePlayer}, and then
     * instantiate them.
     */
    static final List<Class<? extends TicTacToePlayer>> PLAYERS = new Reflections(
        "opponents")
        .getSubTypesOf(TicTacToePlayer.class)
        .stream().toList();

    static final HashMap<Class<? extends TicTacToePlayer>, TicTacToePlayer> PLAYER_CACHE = new HashMap<>();

    /**
     * Play a game of TicTacToe between all players and add their scores to the master map.
     *
     * @param numGames number of games to play as each side
     */
    public void playGame(int numGames) {
        List<Thread> games = new LinkedList<>();
        for (Class<? extends TicTacToePlayer> player : PLAYERS) {
            System.out.printf("Creating thread for %s...%n", player.getSimpleName());
            games.add(new Thread(new RunAgainstAll(player, numGames, this)));
        }

        for (Thread thread : games) {
            thread.start();
        }
        for (Thread thread : games) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    /**
     * Runs a game of TicTacToe between a player and all other players.
     *
     * @param p1Class  the class of the player
     * @param numGames the number of games to play
     * @param origin   the source Competition object to merge scores into
     */
    public record RunAgainstAll(
        Class<? extends TicTacToePlayer> p1Class,
        int numGames,
        Competition origin
    ) implements Runnable {

        @Override
        public void run() {
            HashMap<String, Integer> scores = new HashMap<>();

            for (Class<? extends TicTacToePlayer> p2Class : PLAYERS) {
                if (p1Class == p2Class) {
                    continue; // don't play against yourself
                }
                // Print out the match-up
                // Padded 30 characters because Pius can't be a normal person with a normal name
                System.out.printf("%-30s vs %30s%n", p1Class.getSimpleName(),
                    p2Class.getSimpleName());

                // Instantiate the players from their reflected classes
                TicTacToePlayer p1;
                TicTacToePlayer p2;
                try {
                    if (PLAYER_CACHE.containsKey(p1Class)) {
                        p1 = PLAYER_CACHE.get(p1Class);
                    } else {
                        p1 = p1Class
                            .getDeclaredConstructor(String.class, int.class)
                            .newInstance("p1", 1);
                        PLAYER_CACHE.put(p1Class, p1);
                    }

                    if (PLAYER_CACHE.containsKey(p2Class)) {
                        p2 = PLAYER_CACHE.get(p2Class);
                    } else {
                        p2 = p2Class
                            .getDeclaredConstructor(String.class, int.class)
                            .newInstance("p2", 2);
                        PLAYER_CACHE.put(p2Class, p2);
                    }
                } catch (Exception e) {
                    // Something went wrong
                    throw new RuntimeException(e);
                }

                // this is basically GameController.playGame() copied
                for (int i = 0; i < numGames; i++) {
                    TicTacToe game = new TicTacToeCompetition();
                    int turnTimer = 0;

                    // game plays
                    int state = 0; // 0 = ongoing, 1 = X win, 2 = O win, 3 = tie
                    while (state == 0) {
                        game.placePiece(p1.playTurn(), 1); // x player goes
                        turnTimer++;

                        // check state after X goes to see if the game ended
                        state = game.gameOver();
                        if (state != 0) {
                            break;
                        }

                        game.placePiece(p2.playTurn(), 2); // O player goes
                        turnTimer++;

                        state = game.gameOver(); // update state after O goes, while loop condition will handle the check

                        if (turnTimer > 50) {
                            state = 3;
                        }
                    }

                    // declare winner
                    if (state == 1) {
                        scores.put(
                            p1.getClass().getSimpleName(),
                            scores.getOrDefault(p1.getClass().getSimpleName(), 0) + 1
                        );
                        scores.put(
                            p1.getClass().getSimpleName(),
                            scores.getOrDefault(p1.getClass().getSimpleName(), 0) - 1
                        );
                    } else if (state == 2) {
                        scores.put(
                            p1.getClass().getSimpleName(),
                            scores.getOrDefault(p1.getClass().getSimpleName(), 0) - 1
                        );
                        scores.put(
                            p1.getClass().getSimpleName(),
                            scores.getOrDefault(p1.getClass().getSimpleName(), 0) + 1
                        );
                    } // else draw
                }
            }

            // Merge the scores back into the original competition
            origin.mergeScores(scores);

            System.out.printf("%s finished!%n", p1Class.getSimpleName());

        }
    }

    public static void main(String[] args) {
        Competition competition = new Competition();
        competition.playGame(500); // 500 games on each side, total of 1000 games

        System.out.println("<<<------- SCORES ------->>>");

        Map<String, Integer> scores = competition.getScores();
        scores
            .keySet()
            .stream() // start iterating over the keys
            .sorted(Comparator.comparingInt(scores::get)) // sort the keys by the values
            .forEach(c -> System.out.printf( // print the scores
                "%s: %d%n",
                c.getClass().getSimpleName(),
                scores.get(c)
            ));
    }

}
