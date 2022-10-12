package ExamJune2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[] line=scan.nextLine().split("");
            field[i]=line;
        }
        int snakeRow=0;
        int snakeCol=0;
        int firstBarrowRow=0;
        int firstBarrowCol=0;
        int secondBarrowRow=0;
        int secondBarrowCol=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                String letter=field[i][j];
                if (letter.equals("S")){
                    snakeRow=i;
                    snakeCol=j;
                }else if (letter.equals("B")){
                    if (firstBarrowRow==0){
                        firstBarrowRow=i;
                        firstBarrowCol=j;
                    }else if (secondBarrowRow==0){
                        secondBarrowRow=i;
                        secondBarrowCol=j;
                    }
                }
            }
        }
        int food=0;
        while (food!=10){
            String command= scan.nextLine();
            switch (command){
                case "up":
                    field[snakeRow][snakeCol]=".";
                    snakeRow--;
                    if (baudaries(snakeRow,size)){
                        String letter=field[snakeRow][snakeCol];
                        if (letter.equals("*")){
                            food++;
                        }else if (letter.equals("-")){
                            field[snakeRow][snakeCol]="S";
                        }else if (letter.equals("B")){
                            if (isFirstBurrow(snakeRow,snakeCol,firstBarrowRow,firstBarrowCol)){
                                field[snakeRow][snakeCol]=".";
                                snakeRow=secondBarrowRow;
                                snakeCol=secondBarrowCol;
                            }else{
                                field[snakeRow][snakeCol]=".";
                                snakeRow=firstBarrowRow;
                                snakeCol=firstBarrowCol;
                            }
                        }
                    }else{
                        output(food,field);
                        return;
                    }
                    break;
                case "down":
                    field[snakeRow][snakeCol]=".";
                    snakeRow++;
                    if (baudaries(snakeRow,size)){
                        String letter=field[snakeRow][snakeCol];
                        if (letter.equals("*")){
                            food++;
                        }else if (letter.equals("-")){
                            field[snakeRow][snakeCol]="S";
                        }else if (letter.equals("B")){
                            if (isFirstBurrow(snakeRow,snakeCol,firstBarrowRow,firstBarrowCol)){
                                field[snakeRow][snakeCol]=".";
                                snakeRow=secondBarrowRow;
                                snakeCol=secondBarrowCol;
                            }else{
                                field[snakeRow][snakeCol]=".";
                                snakeRow=firstBarrowRow;
                                snakeCol=firstBarrowCol;
                            }
                        }
                    }else{
                        output(food,field);
                        return;
                    }
                    break;
                case "right":
                    field[snakeRow][snakeCol]=".";
                    snakeCol++;
                    if (baudaries(snakeCol,size)){
                        String letter=field[snakeRow][snakeCol];
                        if (letter.equals("*")){
                            food++;
                        }else if (letter.equals("-")){
                            field[snakeRow][snakeCol]="S";
                        }else if (letter.equals("B")){
                            if (isFirstBurrow(snakeRow,snakeCol,firstBarrowRow,firstBarrowCol)){
                                field[snakeRow][snakeCol]=".";
                                snakeRow=secondBarrowRow;
                                snakeCol=secondBarrowCol;
                            }else{
                                field[snakeRow][snakeCol]=".";
                                snakeRow=firstBarrowRow;
                                snakeCol=firstBarrowCol;
                            }
                        }
                    }else{
                        output(food,field);
                        return;
                    }
                    break;
                case "left":
                    field[snakeRow][snakeCol]=".";
                    snakeCol--;
                    if (baudaries(snakeCol,size)){
                        String letter=field[snakeRow][snakeCol];
                        if (letter.equals("*")){
                            food++;
                        }else if (letter.equals("-")){
                            field[snakeRow][snakeCol]="S";
                        }
                        else if (letter.equals("B")){
                            if (isFirstBurrow(snakeRow,snakeCol,firstBarrowRow,firstBarrowCol)){
                                field[snakeRow][snakeCol]=".";
                                snakeRow=secondBarrowRow;
                                snakeCol=secondBarrowCol;
                            }else{
                                field[snakeRow][snakeCol]=".";
                                snakeRow=firstBarrowRow;
                                snakeCol=firstBarrowCol;
                            }
                        }
                    }else{
                        output(food,field);
                        return;
                    }
                    break;
            }
            field[snakeRow][snakeCol]="S";
        }
        System.out.println("You won! You fed the snake.");
        System.out.println("Food eaten: "+food);
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }
    }

    private static void output(int food, String[][] field) {
        System.out.println("Game over!");
        System.out.println("Food eaten: "+food);
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }

    }

    private static boolean isFirstBurrow(int snakeRow, int snakeCol, int firstBarrowRow, int firstBarrowCol) {
        if (snakeRow==firstBarrowRow&&snakeCol==firstBarrowCol){
            return true;
        }
        return false;
    }

    private static boolean baudaries(int checkNumber, int size) {
        if (checkNumber<0||checkNumber>size-1){
            return false;
        }
        return true;
    }
}
