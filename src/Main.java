import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game gameObject = new Game();

        System.out.println("Welcome to antAdventure");
        System.out.println("Start new colony? yes / no");
        String choice = scanner.nextLine().toLowerCase();
        switch(choice)
        {
            case("yes"):
                gameObject.startGame();
                break;
            case("no"):
                System.out.println("see you later then");
                break;
            default:
                System.out.println("hmmmm, are you sure thats your answer?");
                break;
        }

    }
    public static void newScreen() {
        for(int i = 0 ; i < 20 ; i++) {
            System.out.println();
        }
    }
}