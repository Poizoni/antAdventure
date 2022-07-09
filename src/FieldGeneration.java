import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FieldGeneration {
    public static void makeField() {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] field = new String[18];

        for (int k = 0; k < field.length; k++) {

            Integer[] randomGen = new Integer[16];
            for (int i = 0; i < randomGen.length; i++) {
                randomGen[i] = r.nextInt(36);
            }
            List < Integer > list = Arrays.asList(randomGen);

            field[k] = "*";
            if (k % 6 == 0) {
                System.out.println();
            } else if (list.contains(k)) {
                field[k] = "x";
                System.out.print("x");

            } else {
                System.out.print(field[k]);
            }
        }

        System.out.println("\ndirection");
        String choice = scanner.nextLine();

        switch (choice) {
            case ("s"):

                int k = 6;
                int size = field.length;

                String[] shiftUp = new String[size];

                for (int i = 0; i < size; i++) {
                    int pos = i - k;
                    if (pos >= 0)
                        shiftUp[pos] = field[i];
                    else
                        shiftUp[pos + size] = field[i];
                }

                for (int p = 12; p < shiftUp.length; p++) {
                    shiftUp[p] = "-";
                }

                for (int y = 0; y < shiftUp.length; y++) {
                    if (y % 6 == 0) {
                        System.out.println();
                    } else if (y < shiftUp.length) {
                        System.out.print(shiftUp[y]);
                    }
                }
                break;

            case ("w"):
                int b = 12;
                int size2 = field.length;

                String[] shiftDown = new String[size2];

                for (int i = 0; i < size2; i++) {
                    int pos = i - b;
                    if (pos >= 0)
                        shiftDown[pos] = field[i];
                    else
                        shiftDown[pos + size2] = field[i];
                }

                for (int p = 0; p < shiftDown.length - 12; p++) {
                    shiftDown[p] = "-";
                }

                for (int y = 0; y < shiftDown.length; y++) {
                    if (y % 6 == 0) {
                        System.out.println();
                    } else if (y < shiftDown.length) {
                        System.out.print(shiftDown[y]);
                    }
                }
                break;
            case ("a"):
                System.out.println();
                shiftRight(top(field));
                System.out.println();
                shiftRight(mid(field));
                System.out.println();
                shiftRight(bot(field));
                break;
            case ("d"):
                System.out.println();
                shiftLeft(top(field));
                System.out.println();
                shiftLeft(mid(field));
                System.out.println();
                shiftLeft(bot(field));
                break;
            default:
                System.out.println("oops");
        }
    }

    public static void shiftLeft(String[] arr) {
        int p = 1;
        int size2 = arr.length;

        String[] leftShiftedArray2 = new String[size2];

        for (int i = 0; i < size2; i++) {
            int pos = i - p;
            if (pos >= 0)
                leftShiftedArray2[pos] = arr[i];
            else
                leftShiftedArray2[pos + size2] = arr[i];
        }

        for (int p2 = 4; p2 < leftShiftedArray2.length; p2++) {
            leftShiftedArray2[p2] = "|";
        }
        for (String ele: leftShiftedArray2)
            System.out.print(ele);
    }
    public static void shiftRight(String[] arr) {
        int p = 4;
        int size2 = arr.length;

        String[] leftShiftedArray2 = new String[size2];

        for (int i = 0; i < size2; i++) {
            int pos = i - p;
            if (pos >= 0)
                leftShiftedArray2[pos] = arr[i];
            else
                leftShiftedArray2[pos + size2] = arr[i];
        }

        for (int p2 = 0; p2 < leftShiftedArray2.length - 4; p2++) {
            leftShiftedArray2[p2] = "|";
        }

        for (String ele: leftShiftedArray2) {
            System.out.print(ele);
        }

    }

    public static String[] top(String[] arr) {
        String[] top = new String[5];
        for (int g = 0; g < 5; g++) {
            top[g] = arr[g + 1];
        }
        return top;
    }

    public static String[] mid(String[] arr) {
        String[] mid = new String[5];
        for (int d = 6; d < 11; d++) {
            mid[d - 6] = arr[d + 1];
        }
        return mid;
    }

    public static String[] bot(String[] arr) {
        String[] bot = new String[5];
        for (int q = 13; q < 17; q++) {
            bot[q - 13] = arr[q];
        }
        if (bot[4] == null) {
            bot[4] = arr[17];
        }
        return bot;
    }

}
