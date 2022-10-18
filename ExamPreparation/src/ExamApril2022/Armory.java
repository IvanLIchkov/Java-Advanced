package ExamApril2022;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] shop=new String[size][size];
        int gRow=0;
        int gCow=0;
        int m1Row=-1;
        int m1Cow=-1;
        int m2Row=-1;
        int m2Cow=-1;
        for (int i = 0; i <size ; i++) {
            String[] line=scan.nextLine().split("");
            for (int j = 0; j <line.length ; j++) {
                shop[i][j]=line[j];
                if (line[j].equals("A")){
                    gRow=i;
                    gCow=j;
                }else if (line[j].equals("M")&&m1Row==-1){
                    m1Row=i;
                    m1Cow=j;
                }else if (line[j].equals("M")&&m2Row==-1){
                    m2Row=i;
                    m2Cow=j;
                }
            }
        }
        int gold=0;
        while (gold<65){
            String command= scan.nextLine();
            String letter="";
            shop[gRow][gCow]="-";
            switch (command){
                case "up":
                    gRow--;
                    if (isInBounds(gRow,size)){
                        letter=shop[gRow][gCow];
                        if (isNumber(letter)){
                            gold+=Integer.parseInt(letter);
                        }else if (letter.equals("M")){
                            if (gRow==m1Row&&gCow==m1Cow){
                                shop[m1Row][m1Cow]="-";
                                gRow=m2Row;
                                gCow=m2Cow;
                            }else{
                                shop[m2Row][m2Cow]="-";
                                gRow=m1Row;
                                gCow=m1Cow;
                            }
                        }
                    }else{
                        outputIfLeave(shop,gold);
                        return;
                    }
                    break;
                case "down":
                    gRow++;
                    if (isInBounds(gRow,size)){
                        letter=shop[gRow][gCow];
                        if (isNumber(letter)){
                            gold+=Integer.parseInt(letter);
                        }else if (letter.equals("M")){
                            if (gRow==m1Row&&gCow==m1Cow){
                                shop[m1Row][m1Cow]="-";
                                gRow=m2Row;
                                gCow=m2Cow;
                            }else{
                                shop[m2Row][m2Cow]="-";
                                gRow=m1Row;
                                gCow=m1Cow;
                            }
                        }
                    }else{
                        outputIfLeave(shop,gold);
                        return;
                    }
                    break;
                case "right":
                    gCow++;
                    if (isInBounds(gCow,size)){
                        letter=shop[gRow][gCow];
                        if (isNumber(letter)){
                            gold+=Integer.parseInt(letter);
                        }else if (letter.equals("M")){
                            if (gRow==m1Row&&gCow==m1Cow){
                                shop[m1Row][m1Cow]="-";
                                gRow=m2Row;
                                gCow=m2Cow;
                            }else{
                                shop[m2Row][m2Cow]="-";
                                gRow=m1Row;
                                gCow=m1Cow;
                            }
                        }
                    }else{
                        outputIfLeave(shop,gold);
                        return;
                    }
                    break;
                case "left":
                    gCow--;
                    if (isInBounds(gCow,size)){
                        letter=shop[gRow][gCow];
                        if (isNumber(letter)){
                            gold+=Integer.parseInt(letter);
                        }else if (letter.equals("M")){
                            if (gRow==m1Row&&gCow==m1Cow){
                                shop[m1Row][m1Cow]="-";
                                gRow=m2Row;
                                gCow=m2Cow;
                            }else{
                                shop[m2Row][m2Cow]="-";
                                gRow=m1Row;
                                gCow=m1Cow;
                            }
                        }
                    }else{
                        outputIfLeave(shop,gold);
                        return;
                    }
                    break;
            }
            shop[gRow][gCow]="A";
        }
        System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n",gold);
        printShop(shop);
    }
    private static void printShop(String[][] shop){
        for (String[] strings : shop) {
            System.out.println(String.join("",strings));
        }

    }

    private static void outputIfLeave(String[][] shop, int gold) {
        System.out.println("I do not need more swords!");
        System.out.printf("The king paid %d gold coins.%n",gold);
        printShop(shop);
    }

    private static boolean isNumber(String letter) {
        try {
            int n=Integer.parseInt(letter);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isInBounds(int n, int size) {
        return n>=0&&n<=size-1;
    }
}
