import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    static String winner(String user, String computer) {

        if (user.equals(computer))
            return "Draw";

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
                (user.equals("Paper") && computer.equals("Rock")) ||
                (user.equals("Scissors") && computer.equals("Paper")))
            return "User";

        return "Computer";
    }

    static String[][] statistics(int userWins,
                                 int computerWins,
                                 int games) {

        String[][] data = new String[2][3];

        data[0][0] = "User";
        data[0][1] = String.valueOf(userWins);
        data[0][2] =
                String.valueOf((userWins * 100.0) / games);

        data[1][0] = "Computer";
        data[1][1] = String.valueOf(computerWins);
        data[1][2] =
                String.valueOf((computerWins * 100.0) / games);

        return data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;

        System.out.println(
                "User\tComputer\tWinner");

        for (int i = 0; i < games; i++) {

            String user = sc.next();

            String computer = computerChoice();

            String result =
                    winner(user, computer);

            if (result.equals("User"))
                userWins++;
            else if (result.equals("Computer"))
                computerWins++;

            System.out.println(
                    user + "\t" +
                            computer + "\t\t" +
                            result);
        }

        String[][] stats =
                statistics(userWins,
                        computerWins,
                        games);

        System.out.println("\nPlayer\tWins\tPercentage");

        for (int i = 0; i < stats.length; i++) {

            System.out.println(
                    stats[i][0] + "\t" +
                            stats[i][1] + "\t" +
                            stats[i][2] + "%");
        }
    }
}