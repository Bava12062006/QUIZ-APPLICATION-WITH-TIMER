import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What is the capital of France?\n(a) Berlin\n(b) Madrid\n(c) Paris\n(d) Rome",
                "Which planet is known as the Red Planet?\n(a) Earth\n(b) Mars\n(c) Venus\n(d) Jupiter",
                "Who wrote 'Hamlet'?\n(a) Charles Dickens\n(b) William Shakespeare\n(c) Mark Twain\n(d) Leo Tolstoy"
        };

        String[] answers = {"c", "b", "b"};

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 30 seconds to complete the quiz. Answer quickly!\n");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up! The quiz has ended.");
                System.out.println("Your final score: " + score + "/" + questions.length);
                System.exit(0);
            }
        }, 30000); // Timer set for 30 seconds

        for (int i = 0; i < questions.length; i++) {
            if (timeUp) break;

            System.out.println("Question " + (i + 1) + ":");
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toLowerCase();

            if (timeUp) break;

            if (userAnswer.equals(answers[i])) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! The correct answer was: " + answers[i] + "\n");
            }
        }

        timer.cancel();
        if (!timeUp) {
            System.out.println("Quiz completed!");
            System.out.println("Your final score: " + score + "/" + questions.length);
        }

        scanner.close();
    }
}
