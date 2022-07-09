public class Menu {

    public static void menu() {
        String response = Main.scanner.nextLine().toLowerCase();
        switch(response) {
            case("menu"):
                //build
                //fight
                //forage
                //eat
                //lay eggs
                System.out.println("[MENU]\nWhat would you like to do?\nBUILD\nFIGHT\nFORAGE\nEAT\nLAY EGGS\nSTATS");
                menu();
                break;
            case("stats"):
                Main.newScreen();
                System.out.println("fetching nest progress");
                for (int i = 0; i <= 100; i = i + 20) {
                    Game.progressBar(i, 100);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
                Main.newScreen();
                Stats.statsDisplay();
                menu();
            case("forage"):
                forage();
            default:
                Main.newScreen();
                System.out.println("what?\n(type menu to return)");
                menu();
                Main.newScreen();
        }
    }
    public static void forage() {
        System.out.println("you are now in the woods...");
        System.out.println("walk / climb / dig / return");
        String forageChoice = Main.scanner.nextLine().toLowerCase();
        switch(forageChoice) {
            case("walk"):
                FieldGeneration.makeField();
                forage();
                System.out.println("w / a / s / d");
                String direction = Main.scanner.nextLine().toLowerCase();
                    switch (direction) {
                        case("w"):
                            FieldGeneration.makeField();
                            forage();
                        case("a"):
                            forage();
                        case("s"):
                            forage();
                        case("d"):
                            updateTerrainD();
                        default:
                            System.out.println("Invalid movement");
                            forage();
                    }
                menu();
            default:
                forage();
        }
    }

    public static String field;

    public static String rowFirst;
    public static String rowSecond;
    public static String rowThird;
    public static String rowFourth;
    public static String rowFifth;

    public static void generateTerrain() {
        String grass = "============";

        int startPos = 5;

        String startTerrain = addLetter('o', startPos, grass);

        rowFirst = addLetter('x', (int) (Math.floor(Math.random() * 10)), grass);
        rowSecond = addLetter('x', (int) (Math.floor(Math.random() * 10)), grass);
        rowThird = addLetter('x', (int) (Math.floor(Math.random() * 10)), grass);
        rowFourth = addLetter('x', (int) (Math.floor(Math.random() * 10)), grass);
        rowFifth = addLetter('x', (int) (Math.floor(Math.random() * 10)), grass);
        field =  rowFirst + "\n" + rowSecond + "\n" + rowThird + "\n" + rowFourth + "\n" + rowFifth + "\n" + startTerrain;
        System.out.println(field);
    }
    public static void updateTerrainD() {
        String newFirstRow;
        int currentPos = field.indexOf("o");
        newFirstRow = addLetter('=', currentPos, field);
        newFirstRow = addLetter('o', currentPos + 1, field);

        // rowFirst + "\n" + rowSecond + "\n" + rowThird + "\n" + rowFourth + "\n" + rowFifth +

        field = "\n" + newFirstRow;
        System.out.println(field);
    }

    public static String moveChar(String s, int n) {
        String s2 = s.substring(0,n);
        s = s.substring(n) + s2;
        return s;
    }

    public static String addLetter(char letter, int position, String word){

        // not my code lol

        String toSupport = "";

        if(position == 0){
            toSupport += letter +word;
        } else {
            String temp = word.substring(0, position+1);
            toSupport += temp + Character.toString(letter) + word.substring(position+1, word.length());
        }
        return toSupport;
    }
}
