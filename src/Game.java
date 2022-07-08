
public class Game {

    public static String name;

    public static void startGame() {
        Menu menuObject = new Menu();

        System.out.println("Type your colony name:");
        name = Main.scanner.nextLine();
        Main.newScreen();
        System.out.println("Initiating Ant Hill...");
        for (int i = 0; i <= 100; i = i + 20) {
            progressBar(i, 100);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        Main.newScreen();
        System.out.println("Now in " + name);
        System.out.println("\n(type menu for options)");
        menuObject.menu();
    }

    public static void progressBar(int remain, int total) {

        // not my code lol

        if (remain > total) {
            throw new IllegalArgumentException();
        }
        int maxBareSize = 10; // 10unit for 100%
        int remainProcent = ((100 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "*";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        StringBuilder bareDone = new StringBuilder();
        bareDone.append("[");
        for (int i = 0; i < remainProcent; i++) {
            bareDone.append(icon);
        }
        String bareRemain = bare.substring(remainProcent, bare.length());
        System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");
        if (remain == total) {
            System.out.print("\n");
        }
    }
}


