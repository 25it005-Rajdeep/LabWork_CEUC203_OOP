/**
    Practical 3 (Part A, For Advanced Learners) - Rock Paper Scissors Lizard Spock
 (a) Define an enum Move with ROCK, PAPER, SCISSORS, LIZARD, SPOCK.
 (b) Write winner(Move a, Move b) returning 1 if a beats b, -1 if b beats a, 0 for a tie —
 use a switch expression listing what each move beats (Scissors cut Paper, Paper
 covers Rock, Rock crushes Lizard, Lizard poisons Spock, Spock smashes Scissors,
 and the five mirror cases).
 (c) In main, play 5 rounds: pick a random computer Move, read the player’s Move, call
 winner(), print the round result and keep score.
 (d) After 5 rounds, print the overall winner.
 Expected output: each round prints both moves and the round winner; ends with a
 “You win 3–2” summary.
     */
    import java.util.Random;
    import java.util.Scanner;

public class Para1RPSLS {
        enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static int winner(Move a, Move b) {
        if (a == b)
            return 0;

        boolean aWins;

        switch (a) {
            case ROCK:
                aWins = (b == Move.LIZARD || b == Move.SCISSORS);
                break;

            case PAPER:
                aWins = (b == Move.ROCK || b == Move.SPOCK);
                break;

            case SCISSORS:
                aWins = (b == Move.PAPER || b == Move.LIZARD);
                break;

            case LIZARD:
                aWins = (b == Move.SPOCK || b == Move.PAPER);
                break;

            case SPOCK:
                aWins = (b == Move.SCISSORS || b == Move.ROCK);
                break;

            default:
                aWins = false;
                break;
        }

        return aWins ? 1 : -1;
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random rng = new Random();
            Move[] moves = Move.values();
            int you = 0, cpu = 0;

            System.out.println("Best of 5. Moves: ROCK PAPER SCISSORS LIZARD SPOCK");

            for (int round = 1; round <= 5; round++) {
                System.out.print("Round " + round + " - your move: ");
                Move mine;
                try {
                    mine = Move.valueOf(sc.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("  Invalid move, round skipped.");
                    continue;
                }
                Move theirs = moves[rng.nextInt(moves.length)];

                int r = winner(mine, theirs);
                System.out.print("  You: " + mine + " | Computer: " + theirs + " -> ");
                if (r == 1)       { you++; System.out.println("you win the round"); }
                else if (r == -1) { cpu++; System.out.println("computer wins the round"); }
                else              {        System.out.println("tie"); }
            }

            System.out.println("Final score - You " + you + " : " + cpu + " Computer");
            System.out.println(you > cpu ? "You win!" : you < cpu ? "Computer wins!" : "Overall tie!");
            sc.close();
        }
    }
