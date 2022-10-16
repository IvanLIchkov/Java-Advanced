package ExamOctober2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] territory=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[]line=scan.nextLine().split("");
            territory[i]=line;
        }
        int mRow=-1;
        int mCow=-1;
        for (int row = 0; row < size; row++) {
            for (int cow = 0; cow < size; cow++) {
                if (territory[row][cow].equals("M")){
                    mRow=row;
                    mCow=cow;
                }
            }
        }
        String command= scan.nextLine();
        int cheeses=0;
        while (!command.equals("end")){
            territory[mRow][mCow]="-";
            String letter="";
            switch (command){
                case "up":
                    mRow--;
                    if (isInTerritory(mRow,size)){
                        letter=territory[mRow][mCow];
                        if (letter.equals("c")){
                            cheeses++;
                        }else if (letter.equals("B")){
                            territory[mRow][mCow]="-";
                            mRow--;
                                letter=territory[mRow][mCow];
                                if (letter.equals("c")) {
                                    cheeses++;
                                }
                            }
                    }else{
                        territory[mRow+1][mCow]="-";
                        System.out.println("Where is the mouse?");
                        if (cheeses<5){
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",cheeses);
                        }else {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeses);
                        }
                        printMatrix(territory);
                        return;
                    }
                    break;
                case "down":
                    mRow++;
                    if (isInTerritory(mRow,size)){
                        letter=territory[mRow][mCow];
                        if (letter.equals("c")){
                            cheeses++;
                        }else if (letter.equals("B")){
                            territory[mRow][mCow]="-";
                            mRow++;
                                letter=territory[mRow][mCow];
                                if (letter.equals("c")) {
                                    cheeses++;
                                }
                            }
                    }else{
                        territory[mRow-1][mCow]="-";
                        System.out.println("Where is the mouse?");
                        if (cheeses<5){
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",cheeses);
                        }else {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeses);
                        }
                        printMatrix(territory);
                        return;
                    }
                    break;
                case "right":
                    mCow++;
                    if (isInTerritory(mCow,size)){
                        letter=territory[mRow][mCow];
                        if (letter.equals("c")){
                            cheeses++;
                        }else if (letter.equals("B")){
                            territory[mRow][mCow]="-";
                            mCow++;
                                letter=territory[mRow][mCow];
                                if (letter.equals("c")) {
                                    cheeses++;
                                }
                            }
                    }else{
                        territory[mRow][mCow-1]="-";
                        System.out.println("Where is the mouse?");
                        if (cheeses<5){
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",cheeses);
                        }else {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeses);
                        }
                        printMatrix(territory);
                        return;
                    }
                    break;
                case "left":
                    mCow--;
                    if (isInTerritory(mCow,size)){
                        letter=territory[mRow][mCow];
                        if (letter.equals("c")){
                            cheeses++;
                        }else if (letter.equals("B")){
                            territory[mRow][mCow]="-";
                            mCow--;
                                letter=territory[mRow][mCow];
                                if (letter.equals("c")) {
                                    cheeses++;
                                }
                            }
                    }else{
                        territory[mRow][mCow+1]="-";
                        System.out.println("Where is the mouse?");
                        if (cheeses<5){
                            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-cheeses);
                        }else {
                            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeses);
                        }
                        printMatrix(territory);
                        return;
                    }
                    break;
            }
            territory[mRow][mCow]="M";
            command= scan.nextLine();
        }
        if (cheeses<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-cheeses);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheeses);
        }
        printMatrix(territory);
    }

    private static void printMatrix(String[][] territory) {
        for (String[] strings : territory) {
            System.out.println(String.join("",strings));
        }

    }

    private static boolean isInTerritory(int n, int size) {
        return n >= 0 && n <= size - 1;
    }
}
