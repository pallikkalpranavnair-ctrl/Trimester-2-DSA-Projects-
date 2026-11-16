
import java.util.Scanner;

class CricketMatchProject {

    static Scanner sc = new Scanner(System.in);

    static int runs = 0;
    static int wickets = 0;
    static int balls = 0;

    // Calculate overs
    static void showOvers() {
        System.out.println("Overs: " + balls / 6 + "." + balls % 6);
    }

    // Recursive factorial example
    static int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    // Batting function
    static void batting(String team) {

        System.out.println("\n" + team + " is batting!");

        while (balls < 30 && wickets < 10) {

            System.out.println("\nChoose delivery:");
            System.out.println("0 - Dot Ball");
            System.out.println("1 - Single");
            System.out.println("2 - Double");
            System.out.println("3 - Four");
            System.out.println("4 - Six");
            System.out.println("5 - Wide");
            System.out.println("6 - No Ball");
            System.out.println("7 - Wicket");

            int choice = sc.nextInt();

            switch (choice) {

                case 0:
                    System.out.println("Dot ball!");
                    balls++;
                    break;

                case 1:
                    runs++;
                    balls++;
                    break;

                case 2:
                    runs += 2;
                    balls++;
                    break;

                case 3:
                    runs += 4;
                    balls++;
                    System.out.println("FOUR!");
                    break;

                case 4:
                    runs += 6;
                    balls++;
                    System.out.println("SIX!");
                    break;

                case 5:
                    runs++;
                    System.out.println("Wide ball!");
                    break;

                case 6:
                    runs++;
                    System.out.println("No ball!");
                    break;

                case 7:
                    wickets++;
                    balls++;
                    System.out.println("WICKET!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Score: " + runs + "/" + wickets);
            showOvers();
        }

        System.out.println("\nInnings completed!");
        System.out.println("Total Score: " + runs + "/" + wickets);
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("===== CRICKET MATCH SIMULATION =====");

        System.out.print("Enter Team 1 name: ");
        String team1 = sc.next();

        System.out.print("Enter Team 2 name: ");
        String team2 = sc.next();

        // Toss
        int toss = (int)(Math.random() * 2);

        String firstTeam, secondTeam;

        if (toss == 0) {
            firstTeam = team1;
            secondTeam = team2;
        } else {
            firstTeam = team2;
            secondTeam = team1;
        }

        System.out.println("\nToss winner: " + firstTeam);

        System.out.println("1. Bat first");
        System.out.println("2. Bowl first");

        int decision = sc.nextInt();

        if (decision == 1) {
            System.out.println(firstTeam + " chooses to bat.");
        } else {
            String temp = firstTeam;
            firstTeam = secondTeam;
            secondTeam = temp;

            System.out.println(firstTeam + " chooses to bat.");
        }

        // First innings
        batting(firstTeam);

        int target = runs + 1;

        // Reset score
        runs = 0;
        wickets = 0;
        balls = 0;

        System.out.println("\n===== SECOND INNINGS =====");
        System.out.println(secondTeam + " needs " + target + " runs to win.");

        // Second innings
        batting(secondTeam);

        // Result
        System.out.println("\n===== MATCH RESULT =====");

        if (runs >= target) {
            System.out.println(secondTeam + " WINS!");
        } else if (runs == target - 1) {
            System.out.println("MATCH TIED!");
        } else {
            System.out.println(firstTeam + " WINS!");
        }
    }
}
