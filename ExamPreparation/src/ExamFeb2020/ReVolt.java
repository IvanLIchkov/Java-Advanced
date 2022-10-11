package ExamFeb2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        int numberOfCommands=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[] tokens=scan.nextLine().split("");
            field[i]=tokens;
        }
        int playerRow=0;
        int playerCow=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (field[i][j].equals("f")){
                    playerRow=i;
                    playerCow=j;
                    break;
                }
            }
        }
        for (int i = 0; i <numberOfCommands ; i++) {
            String command= scan.nextLine();
            String position="";
            switch (command){
                case "up":
                    if (checkForBoudn(size,playerRow,playerCow,command)){
                        position=field[playerRow-1][playerCow];
                        if (position.equals("B")){
                            playerRow-=1;
                            moveMent(position,playerRow,playerCow,command,size,field);
                            if (checkForBoudn(size,playerRow,playerCow,command)){
                                playerRow -= 1;
                            }else{
                                field[size-1][playerCow]="f";
                                field[playerRow][playerCow]="-";
                                playerRow=size-1;
                            }
                        }else if (position.equals("-")){
                            field[playerRow][playerCow]="-";
                            field[playerRow-1][playerCow]="f";
                            playerRow-=1;
                        }else if (position.equals("F")){
                            field[playerRow][playerCow]="-";
                            field[playerRow-1][playerCow]="f";
                        }
                    }else{
                        field[size-1][playerCow]="f";
                        field[playerRow][playerCow]="-";
                        playerRow=size-1;
                    }
                    break;
                case "down":
                    if (checkForBoudn(size,playerRow,playerCow,command)) {
                        position = field[playerRow + 1][playerCow];
                        if (position.equals("B")) {
                            playerRow += 1;
                            moveMent(position, playerRow, playerCow, command, size, field);
                            if (checkForBoudn(size,playerRow,playerCow,command)){
                                playerRow += 1;
                            }else{
                                field[0][playerCow]="f";
                                field[playerRow][playerCow]="-";
                                playerRow=0;
                            }
                        } else if (position.equals("-")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow + 1][playerCow] = "f";
                            playerRow += 1;
                        } else if (position.equals("F")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow + 1][playerCow] = "f";
                        }
                    }else{
                        field[0][playerCow]="f";
                        field[playerRow][playerCow]="-";
                        playerRow=0;
                    }
                    break;
                case "right":
                    if (checkForBoudn(size,playerRow,playerCow,command)) {
                        position = field[playerRow][playerCow + 1];
                        if (position.equals("B")) {
                            playerCow += 1;
                            moveMent(position, playerRow, playerCow, command, size, field);
                            if (checkForBoudn(size,playerRow,playerCow,command)){
                                playerCow += 1;
                            }else{
                                field[playerRow][size+1]="f";
                                field[playerRow][playerCow]="-";
                                playerCow=size+1;
                            }
                        } else if (position.equals("-")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow][playerCow + 1] = "f";
                            playerCow += 1;
                        } else if (position.equals("F")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow][playerCow + 1] = "f";
                        }
                    }else{
                        field[playerRow][0]="f";
                        field[playerRow][playerCow]="-";
                        playerCow=0;
                    }
                    break;
                case "left":
                    if (checkForBoudn(size,playerRow,playerCow,command)) {
                        position = field[playerRow][playerCow - 1];
                        if (position.equals("B")) {
                            playerCow -= 1;
                            moveMent(position, playerRow, playerCow, command, size, field);
                            if (checkForBoudn(size,playerRow,playerCow,command)){
                                playerCow -= 1;
                            }else{
                                field[playerRow][size-1]="f";
                                field[playerRow][playerCow]="-";
                                playerCow=size-1;
                            }

                        } else if (position.equals("-")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow][playerCow - 1] = "f";
                            playerCow -= 1;
                        } else if (position.equals("F")) {
                            field[playerRow][playerCow] = "-";
                            field[playerRow][playerCow - 1] = "f";
                        }
                    }else{
                        field[playerRow][size-1]="f";
                        field[playerRow][playerCow]="-";
                        playerCow=size-1;
                    }
                    break;
            }
            if (position.equals("F")){
                System.out.println("Player won!");
                for (String[] strings : field) {
                    for (String string : strings) {
                        System.out.printf("%s",string);
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Player lost!");
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.printf("%s",string);
            }
            System.out.println();
        }
    }

    private static void moveMent(String position, int playerRow, int playerCow, String command, int size, String[][] field) {
        if (position.equals("B")){
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0 && playerRow - 1 < size) {
                        field[playerRow-1][playerCow]="f";
                        field[playerRow][playerCow]="-";
                        playerRow-=1;
                    }else{
                        field[size-1][playerCow]="f";
                        field[playerRow][playerCow]="-";
                        playerRow=size-1;
                    }
                    break;
                case "down":
                    if (playerRow + 1 >= 0 && playerRow + 1 < size) {
                        field[playerRow-1][playerCow]="-";
                        field[playerRow+1][playerCow]="f";
                        playerRow+=1;
                    }else {
                        field[0][playerCow]="f";
                        field[playerRow][playerCow]="-";
                        playerRow=0;
                    }
                    break;
                case "right":
                    if (playerCow + 1 >= 0 && playerCow + 1 < size) {
                        field[playerRow][playerCow+1]="f";
                        field[playerRow][playerCow]="-";
                        playerCow+=1;
                    }else {
                        field[playerRow][0]="f";
                        field[playerRow][playerCow]="-";
                        playerCow=0;
                    }
                    break;
                case "left":
                    if (playerCow - 1 >= 0 && playerCow - 1 < size) {
                        field[playerRow][playerCow-1]="-";
                        field[playerRow][playerCow]="f";
                        playerCow-=1;
                    }else{
                        field[playerRow][playerCow+1]="-";
                        field[playerRow][size-1]="f";
                        playerCow=size-1;
                    }
                    break;
            }
        }else if (position.equals("T")){

        }
    }

    private static boolean checkForBoudn(int size, int playerRow, int playerCow, String command) {
        switch (command){
            case "up":
                if (playerRow-1>=0&&playerRow-1<size){
                    return true;
                }
                break;
            case "down":
                if (playerRow+1>=0&&playerRow+1<size){
                    return true;
                }
                break;
            case "right":
                if (playerCow+1>=0&&playerCow+1<size){
                    return true;
                }
                break;
            case "left":
                if (playerCow-1>=0&&playerCow-1<size){
                    return true;
                }
                break;
        }
        return false;
    }
}
