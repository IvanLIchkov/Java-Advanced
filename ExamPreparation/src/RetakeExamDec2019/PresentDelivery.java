package ExamPreparation.src.RetakeExamDec2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int presents = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        String[][] neighborhood = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] line = scan.nextLine().split(" ");
            neighborhood[i] = line;
        }
        int santaRow = 0;
        int santaCow = 0;
        int niceKids = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (neighborhood[i][j].equals("S")) {
                    santaRow = i;
                    santaCow = j;
                }
                if (neighborhood[i][j].equals("V")) {
                    niceKids++;
                }
            }
        }
        String command = scan.nextLine();
        int niceKidsStart = niceKids;
        int presentsStart = presents;

        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    String kid = "";
                    if (isInBorder(command, santaRow, santaCow, size)) {
                        kid = neighborhood[santaRow - 1][santaCow];
                        if (kid.equals("V")) {
                            neighborhood[santaRow][santaCow] = "-";
                            neighborhood[santaRow - 1][santaCow] = "S";
                            santaRow -= 1;
                            presents--;
                            niceKids--;
                        } else if (kid.equals("K")) {
                            cookies(santaRow - 1, santaCow, neighborhood, size, presents, niceKids);
                        } else {
                            neighborhood[santaRow][santaCow] = "-";
                            neighborhood[santaRow - 1][santaCow] = "S";
                            santaRow -= 1;
                        }
                    }
                    break;
                case "down":
                    kid = "";
                    if (isInBorder(command, santaRow, santaCow, size)) {
                        kid = neighborhood[santaRow + 1][santaCow];
                        if (kid.equals("V")) {
                            neighborhood[santaRow][santaCow] = "-";
                            neighborhood[santaRow + 1][santaCow] = "S";
                            santaRow += 1;
                            presents--;
                            niceKids--;
                        } else if (kid.equals("K")) {
                            neighborhood[santaRow + 1][santaCow] = "S";
                            neighborhood[santaRow][santaCow] = "-";
                            santaRow += 1;
                            cookies(santaRow, santaCow, neighborhood, size, presents, niceKids);
                        } else {
                            neighborhood[santaRow + 1][santaCow] = "S";
                            neighborhood[santaRow][santaCow] = "-";
                            santaRow += 1;
                        }
                    }
                    break;
                case "left":
                    kid = "";
                    if (isInBorder(command, santaRow, santaCow, size)) {
                        kid = neighborhood[santaRow][santaCow - 1];
                        if (kid.equals("V")) {
                            neighborhood[santaRow][santaCow] = "-";
                            neighborhood[santaRow][santaCow - 1] = "S";
                            santaCow -= 1;
                            presents--;
                            niceKids--;
                        } else if (kid.equals("K")) {
                            cookies(santaRow, santaCow - 1, neighborhood, size, presents, niceKids);
                        } else {
                            neighborhood[santaRow][santaCow - 1] = "S";
                            neighborhood[santaRow][santaCow] = "-";
                            santaCow -= 1;
                        }
                    }
                    break;
                case "right":
                    kid = "";
                    if (isInBorder(command, santaRow, santaCow, size)) {
                        kid = neighborhood[santaRow][santaCow + 1];
                        if (kid.equals("V")) {
                            neighborhood[santaRow][santaCow] = "-";
                            neighborhood[santaRow][santaCow + 1] = "S";
                            santaCow += 1;
                            presents--;
                            niceKids--;
                        } else if (kid.equals("K")) {
                            cookies(santaRow, santaCow + 1, neighborhood, size, presents, niceKids);
                        } else {
                            neighborhood[santaRow][santaCow + 1] = "S";
                            neighborhood[santaRow][santaCow] = "-";
                            santaCow += 1;
                        }
                    }
                    break;

            }
            if (presents <= 0) {
                System.out.printf("Santa ran out of presents!%n");
                for (String[] strings : neighborhood) {
                    System.out.println(String.join(" ", strings));
                }
                System.out.printf("No presents for %d nice kid/s.", niceKidsStart - presentsStart);
                return;
            }
            command = scan.nextLine();

        }
        for (String[] strings : neighborhood) {
            System.out.println(String.join(" ", strings));
        }
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKidsStart);
        }else{
            System.out.printf("No presents for %d nice kid/s.",niceKids);
        }


    }

    private static void cookies(int santaRow, int santaCow, String[][] neighborhood, int size, int presents, int niceKids) {
        String kid = "";
        if (santaRow - 1 >= 0 && santaRow - 1 < size) {
            kid = neighborhood[santaRow - 1][santaCow];
            if (kid.equals("V")) {
                presents--;
                niceKids--;
                neighborhood[santaRow - 1][santaCow] = "-";
            } else if (kid.equals("X")) {
                presents--;
                neighborhood[santaRow - 1][santaCow] = "-";
            }
        }
        if (santaCow + 1 >= 0 && santaCow + 1 < size) {
            kid = neighborhood[santaRow][santaCow + 1];
            if (kid.equals("V")) {
                presents--;
                niceKids--;
                neighborhood[santaRow][santaCow + 1] = "-";
            } else if (kid.equals("X")) {
                presents--;
                neighborhood[santaRow][santaCow + 1] = "-";
            }
        }
        if (santaRow + 1 >= 0 && santaRow + 1 < size) {
            kid = neighborhood[santaRow + 1][santaCow];
            if (kid.equals("V")) {
                presents--;
                niceKids--;
                neighborhood[santaRow + 1][santaCow] = "-";
            } else if (kid.equals("X")) {
                presents--;
                neighborhood[santaRow + 1][santaCow] = "-";
            }
        }
        if (santaCow - 1 >= 0 && santaCow - 1 < size) {
            kid = neighborhood[santaRow][santaCow - 1];
            if (kid.equals("V")) {
                presents--;
                niceKids--;
                neighborhood[santaRow][santaCow - 1] = "-";
            } else if (kid.equals("X")) {
                presents--;
                neighborhood[santaRow][santaCow - 1] = "-";
            }
        }
        for (String[] strings : neighborhood) {
            System.out.println(String.join(" ", strings));
        }
    }

    private static boolean isInBorder(String command, int santaRow, int santaCow, int size) {
        switch (command) {
            case "up":
                if (santaRow - 1 >= 0 && santaRow - 1 < size) {
                    return true;
                }
                return false;
            case "down":
                if (santaRow + 1 >= 0 && santaRow + 1 < size) {
                    return true;
                }
                return false;
            case "left":
                if (santaCow - 1 >= 0 && santaCow - 1 < size) {
                    return true;
                }
                return false;
            case "right":
                if (santaCow + 1 >= 0 && santaCow + 1 < size) {
                    return true;
                }
                return false;
        }
        return true;
    }

    private static boolean isGood(String kid) {
        if (kid.equals("X")) {
            return false;
        }
        return true;
    }
}
