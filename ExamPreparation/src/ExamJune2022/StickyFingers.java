package ExamJune2022;

import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] bank = new String[size][size];
        String[] commands = scan.nextLine().split(",");
        int dRow = -1;
        int dCow = -1;
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split(" ");
            for (int cow = 0; cow < line.length; cow++) {
                bank[row][cow] = line[cow];
                if (line[cow].equals("D")) {
                    dRow = row;
                    dCow = cow;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < commands.length; i++) {
            int tempSum = 0;
            String command = commands[i];
            bank[dRow][dCow] = "+";
            switch (command) {
                case "up":
                    dRow--;
                    if (isInBounds(dRow, size)) {
                        String letter = bank[dRow][dCow];
                        if (letter.equals("$")) {
                            sum += dRow * dCow;
                            tempSum = dRow * dCow;
                            sumPrint(tempSum);
                        } else if (letter.equals("P")) {
                            bank[dRow][dCow] = "#";
                            caughtPrint(sum);
                            printBank(bank);
                            return;
                        }
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dRow++;
                    }
                    break;
                case "down":
                    dRow++;
                    if (isInBounds(dRow, size)) {
                        String letter = bank[dRow][dCow];
                        if (letter.equals("$")) {
                            sum += dRow * dCow;
                            tempSum = dRow * dCow;
                            sumPrint(tempSum);
                        } else if (letter.equals("P")) {
                            bank[dRow][dCow] = "#";
                            caughtPrint(sum);
                            printBank(bank);
                            return;
                        }
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dRow--;
                    }
                    break;
                case "right":
                    dCow++;
                    if (isInBounds(dCow, size)) {
                        String letter = bank[dRow][dCow];
                        if (letter.equals("$")) {
                            sum += dRow * dCow;
                            tempSum = dRow * dCow;
                            sumPrint(tempSum);
                        } else if (letter.equals("P")) {
                            bank[dRow][dCow] = "#";
                            caughtPrint(sum);
                            printBank(bank);
                            return;
                        }
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dCow--;
                    }
                    break;
                case "left":
                    dCow--;
                    if (isInBounds(dCow, size)) {
                        String letter = bank[dRow][dCow];
                        if (letter.equals("$")) {
                            sum += dRow * dCow;
                            tempSum = dRow * dCow;
                            sumPrint(tempSum);
                        } else if (letter.equals("P")) {
                            bank[dRow][dCow] = "#";
                            caughtPrint(sum);
                            printBank(bank);
                            return;
                        }
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dCow++;
                    }
                    break;
            }
            bank[dRow][dCow] = "D";
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", sum);
        printBank(bank);
    }

    private static void printBank(String[][] bank) {
        Arrays.stream(bank).forEach(s -> System.out.println(String.join(" ", s)));
    }

    private static void caughtPrint(int sum) {
        System.out.printf("You got caught with %d$, and you are going to jail.%n", sum);
    }

    private static void sumPrint(int tempSum) {
        System.out.printf("You successfully stole %d$.%n", tempSum);
    }

    private static boolean isInBounds(int n, int size) {
        return n >= 0 && n <= size - 1;
    }
}
