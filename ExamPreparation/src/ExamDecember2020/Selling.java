package ExamDecember2020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] bakery = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] line = scan.nextLine().split("");
            bakery[i] = line;
        }
        int positionRow = 0;
        int positionCow = 0;
        int firstPillarRow = -1;
        int firstPillarCow = -1;
        int secondPillarRow = -1;
        int secondPillarCow = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bakery[i][j].equals("S")) {
                    positionRow = i;
                    positionCow = j;
                } else if (bakery[i][j].equals("O")) {
                    if (firstPillarRow == -1) {
                        firstPillarRow = i;
                        firstPillarCow = j;
                    } else if (secondPillarRow == -1) {
                        secondPillarRow = i;
                        secondPillarCow = j;
                    }
                }
            }
        }
        int dollarSum = 0;
        while (dollarSum < 50) {
            String command = scan.nextLine();
            String letter = "";
            bakery[positionRow][positionCow] = "-";
            switch (command) {
                case "up":
                    positionRow--;
                    if (checkBoundaries(positionRow, size)) {
                        letter = bakery[positionRow][positionCow];
                        if (isDigit(letter)) {
                            dollarSum += Integer.parseInt(letter);
                        } else if (letter.equals("O")) {
                            bakery[positionRow][positionCow] = "-";
                            if (positionRow == firstPillarRow && positionCow == firstPillarCow) {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = secondPillarRow;
                                positionCow = secondPillarCow;
                            } else {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = firstPillarRow;
                                positionCow = firstPillarCow;
                            }
                        }
                    } else {
                        outOfBakeryPrint(dollarSum);
                        printBakery(bakery);
                        return;
                    }
                    break;
                case "down":
                    positionRow++;
                    if (checkBoundaries(positionRow, size)) {
                        letter = bakery[positionRow][positionCow];
                        if (isDigit(letter)) {
                            dollarSum += Integer.parseInt(letter);
                        } else if (letter.equals("O")) {
                            bakery[positionRow][positionCow] = "-";
                            if (positionRow == firstPillarRow && positionCow == firstPillarCow) {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = secondPillarRow;
                                positionCow = secondPillarCow;
                            } else {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = firstPillarRow;
                                positionCow = firstPillarCow;
                            }
                        }
                    } else {
                        outOfBakeryPrint(dollarSum);
                        printBakery(bakery);
                        return;
                    }
                    break;
                case "right":
                    positionCow++;
                    if (checkBoundaries(positionCow, size)) {
                        letter = bakery[positionRow][positionCow];
                        if (isDigit(letter)) {
                            dollarSum += Integer.parseInt(letter);
                        } else if (letter.equals("O")) {
                            bakery[positionRow][positionCow] = "-";
                            if (positionRow == firstPillarRow && positionCow == firstPillarCow) {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = secondPillarRow;
                                positionCow = secondPillarCow;
                            } else {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = firstPillarRow;
                                positionCow = firstPillarCow;
                            }
                        }
                    } else {
                        outOfBakeryPrint(dollarSum);
                        printBakery(bakery);
                        return;
                    }
                    break;
                case "left":
                    positionCow--;
                    if (checkBoundaries(positionCow, size)) {
                        letter = bakery[positionRow][positionCow];
                        if (isDigit(letter)) {
                            dollarSum += Integer.parseInt(letter);
                        } else if (letter.equals("O")) {
                            bakery[positionRow][positionCow] = "-";
                            if (positionRow == firstPillarRow && positionCow == firstPillarCow) {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = secondPillarRow;
                                positionCow = secondPillarCow;
                            } else {
                                bakery[positionRow][positionRow] = "-";
                                positionRow = firstPillarRow;
                                positionCow = firstPillarCow;
                            }
                        }
                    } else {
                        outOfBakeryPrint(dollarSum);
                        printBakery(bakery);
                        return;
                    }
                    break;
            }
            bakery[positionRow][positionCow] = "S";
            if (dollarSum >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                System.out.println("Money: " + dollarSum);
                printBakery(bakery);
                return;
            }
        }
    }

    private static void printBakery(String[][] bakery) {
        for (String[] strings : bakery) {
            System.out.println(String.join("", strings));
        }

    }

    private static void outOfBakeryPrint(int dollarSum) {
        System.out.println("Bad news, you are out of the bakery.");
        System.out.printf("Money: %d%n", dollarSum);

    }

    private static boolean isDigit(String letter) {
        try {
            int n = Integer.parseInt(letter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkBoundaries(int positionRow, int size) {
        if (positionRow >= 0 && positionRow <= size - 1) {
            return true;
        }
        return false;
    }
}
