package ExamAugust2021;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        int numberOfCommands=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][size];
        for (int i = 0; i <size ; i++) {
            field[i]=scan.nextLine().split("");
        }
        int playerRow=-1;
        int playerCow=-1;
        for (int row = 0; row < size; row++) {
            for (int cow = 0; cow < size; cow++) {
                if (field[row][cow].equals("P")){
                    playerRow=row;
                    playerCow=cow;
                }
            }
        }
        for (int i = 0; i <numberOfCommands ; i++) {
            String command= scan.nextLine();
            String letter="";
            field[playerRow][playerCow]=".";
            switch (command){
                case "up":
                    playerRow--;
                    if (inBounds(playerRow,size)){
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerRow--;
                            if (!inBounds(playerRow,size)){
                                playerRow=size-1;
                                letter=field[playerRow][playerCow];
                                if (letter.equals("B")){
                                    playerRow--;
                                    if (!inBounds(playerRow,size)){
                                        playerRow=size-1;
                                    }
                                }else if (letter.equals("T")){
                                    playerRow++;
                                }
                            }
                        }else if (letter.equals("T")){
                            playerRow++;
                        }
                    }else{
                        playerRow=size-1;
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerRow--;
                            if (!inBounds(playerRow,size)){
                                playerRow=size-1;
                            }
                        }else if (letter.equals("T")){
                            playerRow++;
                        }
                    }
                    break;
                case "down":
                    playerRow++;
                    if (inBounds(playerRow,size)){
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerRow++;
                            if (!inBounds(playerRow,size)){
                                playerRow=0;
                                letter=field[playerRow][playerCow];
                                if (letter.equals("B")){
                                    playerRow++;
                                    if (!inBounds(playerRow,size)){
                                        playerRow=size-1;
                                    }
                                }else if (letter.equals("T")){
                                    playerRow--;
                                }
                            }
                        }else if (letter.equals("T")){
                            playerRow--;
                        }
                    }else{
                        playerRow=0;
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerRow++;
                            if (!inBounds(playerRow,size)){
                                playerRow=size-1;
                            }
                        }else if (letter.equals("T")){
                            playerRow--;
                        }
                    }
                    break;
                case "right":
                    playerCow++;
                    if (inBounds(playerCow,size)){
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerCow++;
                            if (!inBounds(playerCow,size)){
                                playerCow=0;
                                letter=field[playerRow][playerCow];
                                if (letter.equals("B")){
                                    playerCow++;
                                    if (!inBounds(playerCow,size)){
                                        playerCow=0;
                                    }
                                }else if (letter.equals("T")){
                                    playerCow--;
                                }
                            }
                        }else if (letter.equals("T")){
                            playerCow--;
                        }
                    }else{
                        playerCow=0;
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerCow++;
                            if (!inBounds(playerCow,size)){
                                playerCow=0;
                            }
                        }else if (letter.equals("T")){
                            playerCow--;
                        }
                    }
                    break;
                case "left":
                    playerCow--;
                    if (inBounds(playerCow,size)){
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerCow--;
                            if (!inBounds(playerCow,size)){
                                playerCow=0;
                                letter=field[playerRow][playerCow];
                                if (letter.equals("B")){
                                    playerCow--;
                                    if (!inBounds(playerCow,size)){
                                        playerCow=size-1;
                                    }
                                }else if (letter.equals("T")){
                                    playerCow++;
                                }
                            }
                        }else if (letter.equals("T")){
                            playerCow++;
                        }
                    }else{
                        playerCow=size-1;
                        letter=field[playerRow][playerCow];
                        if (letter.equals("B")){
                            playerCow--;
                            if (!inBounds(playerCow,size)){
                                playerCow=size-1;
                            }
                        }else if (letter.equals("T")){
                            playerCow++;
                        }
                    }
                    break;
            }
            if (letter.equals("F")){
                field[playerRow][playerCow]="P";
                System.out.println("Well done, the player won first place!");
                printField(field);
                return;
            }
            field[playerRow][playerCow]="P";
        }
        System.out.println("Oh no, the player got lost on the track!");
        printField(field);
    }

    private static void printField(String[][] field) {
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }
    }

    private static boolean inBounds(int n, int size) {
        if (n>=0&&n<=size-1){
            return true;
        }
        return false;
    }
}
