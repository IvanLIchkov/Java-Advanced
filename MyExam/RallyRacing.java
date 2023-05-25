package MyExam;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String racingNumber = scan.nextLine();
        String[][] field = new String[size][size];
        int t1Row = -1;
        int t1Cow = -1;
        int t2Row = -1;
        int t2Cow = -1;
        int carRow = 0;
        int carCow = 0;
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split(" ");
            for (int cow = 0; cow < line.length; cow++) {
                field[row][cow] = line[cow];
                if (line[cow].equals("T")) {
                    if (t1Row == -1) {
                        t1Row = row;
                        t1Cow = cow;
                    } else {
                        t2Row = row;
                        t2Cow = cow;
                    }
                }
            }
        }
        int totalKm = 0;
        String command = scan.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    carRow--;
                    if (field[carRow][carCow].equals("T")) {
                        totalKm += 30;
                        if (t1Row == carRow && t1Cow == carCow) {
                            field[t1Row][t1Cow] = ".";
                            carRow = t2Row;
                            carCow = t2Cow;
                            field[t2Row][t2Cow] = ".";
                        } else {
                            field[t2Row][t2Cow] = ".";
                            carRow = t1Row;
                            carCow = t1Cow;
                            field[t1Row][t1Cow] = ".";
                        }
                    } else if (field[carRow][carCow].equals(".")) {
                        totalKm += 10;
                    } else if (field[carRow][carCow].equals("F")) {
                        totalKm += 10;
                        field[carRow][carCow] = "C";
                        printWin(racingNumber, totalKm, field);
                        return;
                    }
                    break;
                case "down":
                    carRow++;
                    if (field[carRow][carCow].equals("T")) {
                        totalKm += 30;
                        if (t1Row == carRow && t1Cow == carCow) {
                            field[t1Row][t1Cow] = ".";
                            carRow = t2Row;
                            carCow = t2Cow;
                            field[t2Row][t2Cow] = ".";
                        } else {
                            field[t2Row][t2Cow] = ".";
                            carRow = t1Row;
                            carCow = t1Cow;
                            field[t1Row][t1Cow] = ".";
                        }
                    } else if (field[carRow][carCow].equals(".")) {
                        totalKm += 10;
                    } else if (field[carRow][carCow].equals("F")) {
                        totalKm += 10;
                        field[carRow][carCow] = "C";
                        printWin(racingNumber, totalKm, field);
                        return;
                    }
                    break;
                case "right":
                    carCow++;
                    if (field[carRow][carCow].equals("T")) {
                        totalKm += 30;
                        if (t1Row == carRow && t1Cow == carCow) {
                            field[t1Row][t1Cow] = ".";
                            carRow = t2Row;
                            carCow = t2Cow;
                            field[t2Row][t2Cow] = ".";
                        } else {
                            field[t2Row][t2Cow] = ".";
                            carRow = t1Row;
                            carCow = t1Cow;
                            field[t1Row][t1Cow] = ".";
                        }
                    } else if (field[carRow][carCow].equals(".")) {
                        totalKm += 10;
                    } else if (field[carRow][carCow].equals("F")) {
                        totalKm += 10;
                        field[carRow][carCow] = "C";
                        printWin(racingNumber, totalKm, field);
                        return;
                    }
                    break;
                case "left":
                    carCow--;
                    if (field[carRow][carCow].equals("T")) {
                        totalKm += 30;
                        if (t1Row == carRow && t1Cow == carCow) {
                            field[t1Row][t1Cow] = ".";
                            carRow = t2Row;
                            carCow = t2Cow;
                            field[t2Row][t2Cow] = ".";
                        } else {
                            field[t2Row][t2Cow] = ".";
                            carRow = t1Row;
                            carCow = t1Cow;
                            field[t1Row][t1Cow] = ".";
                        }
                    } else if (field[carRow][carCow].equals(".")) {
                        totalKm += 10;
                    } else if (field[carRow][carCow].equals("F")) {
                        totalKm += 10;
                        field[carRow][carCow] = "C";
                        printWin(racingNumber, totalKm, field);
                        return;
                    }
                    break;
            }
            command = scan.nextLine();
        }
        field[carRow][carCow] = "C";
        System.out.printf("Racing car %s DNF.%n", racingNumber);
        System.out.printf("Distance covered %d km.%n", totalKm);
        printField(field);
    }

    private static void printWin(String racingNumber, int totalKm, String[][] field) {
        System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        System.out.printf("Distance covered %d km.%n", totalKm);
        printField(field);
    }

    private static void printField(String[][] field) {
        for (String[] strings : field) {
            System.out.println(String.join("", strings));
        }

    }
}
