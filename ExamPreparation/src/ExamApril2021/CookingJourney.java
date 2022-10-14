package ExamApril2021;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] shop=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[] line=scan.nextLine().split("");
            shop[i]=line;
        }
        int sRow=0;
        int sCow=0;
        int firstPilarRow=-1;
        int firstPilarCow=-1;
        int secondPilarRow=-1;
        int secondPilarCow=-1;

        for (int row = 0; row < size; row++) {
            for (int cow = 0; cow < size; cow++) {
                if (shop[row][cow].equals("S")){
                    sRow=row;
                    sCow=cow;
                }else if (shop[row][cow].equals("P")){
                    if (firstPilarRow==-1){
                        firstPilarRow=row;
                        firstPilarCow=cow;
                    }else if (secondPilarRow==-1){
                        secondPilarRow=row;
                        secondPilarCow=cow;
                    }
                }
            }
        }
        int money=0;
        while (money<50){
            String command= scan.nextLine();
            String letter="";
            shop[sRow][sCow]="-";
            switch (command){
                case "up":
                    sRow--;
                    if (isInShop(sRow,size)){
                        letter=shop[sRow][sCow];
                        if (isDigit(letter)){
                            money+=Integer.parseInt(letter);
                        }else{
                            if (letter.equals("P")){
                                if (sRow==firstPilarRow){
                                    sRow=secondPilarRow;
                                    sCow=secondPilarCow;
                                    shop[firstPilarRow][firstPilarCow]="-";
                                }else if (sRow==secondPilarRow){
                                    sRow=firstPilarRow;
                                    sCow=firstPilarCow;
                                    shop[secondPilarRow][secondPilarCow]="-";
                                }
                            }
                        }
                    }else{
                        outOfShopOutput(money);
                        printShop(shop);
                        return;
                    }
                    break;
                case "down":
                    sRow++;
                    if (isInShop(sRow,size)){
                        letter=shop[sRow][sCow];
                        if (isDigit(letter)){
                            money+=Integer.parseInt(letter);
                        }else{
                            if (letter.equals("P")){
                                if (sRow==firstPilarRow){
                                    sRow=secondPilarRow;
                                    sCow=secondPilarCow;
                                    shop[firstPilarRow][firstPilarCow]="-";
                                }else if (sRow==secondPilarRow){
                                    sRow=firstPilarRow;
                                    sCow=firstPilarCow;
                                    shop[secondPilarRow][secondPilarCow]="-";
                                }
                            }
                        }
                    }else{
                        outOfShopOutput(money);
                        printShop(shop);
                        return;
                    }
                    break;
                case "right":
                    sCow++;
                    if (isInShop(sCow,size)){
                        letter=shop[sRow][sCow];
                        if (isDigit(letter)){
                            money+=Integer.parseInt(letter);
                        }else{
                            if (letter.equals("P")){
                                if (sRow==firstPilarRow){
                                    sRow=secondPilarRow;
                                    sCow=secondPilarCow;
                                    shop[firstPilarRow][firstPilarCow]="-";
                                }else if (sRow==secondPilarRow){
                                    sRow=firstPilarRow;
                                    sCow=firstPilarCow;
                                    shop[secondPilarRow][secondPilarCow]="-";
                                }
                            }
                        }
                    }else{
                        outOfShopOutput(money);
                        printShop(shop);
                        return;
                    }
                    break;
                case "left":
                    sCow--;
                    if (isInShop(sCow,size)){
                        letter=shop[sRow][sCow];
                        if (isDigit(letter)){
                            money+=Integer.parseInt(letter);
                        }else{
                            if (letter.equals("P")){
                                if (sRow==firstPilarRow){
                                    sRow=secondPilarRow;
                                    sCow=secondPilarCow;
                                    shop[firstPilarRow][firstPilarCow]="-";
                                }else if (sRow==secondPilarRow){
                                    sRow=firstPilarRow;
                                    sCow=firstPilarCow;
                                    shop[secondPilarRow][secondPilarCow]="-";
                                }
                            }
                        }
                    }else{
                        outOfShopOutput(money);
                        printShop(shop);
                        return;
                    }
                    break;
            }
            shop[sRow][sCow]="S";
        }
        System.out.println("Good news! You succeeded in collecting enough money!");
        System.out.printf("Money: %d%n",money);
        printShop(shop);
    }

    private static void printShop(String[][] shop) {
        for (String[] strings : shop) {
            System.out.println(String.join("",strings));
        }

    }

    private static void outOfShopOutput(int money) {
        System.out.println("Bad news! You are out of the pastry shop.");
        System.out.printf("Money: %d%n",money);

    }

    private static boolean isDigit(String letter) {
        try {
            int n=Integer.parseInt(letter);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isInShop(int n, int size) {
        if (n>=0&&n<=size-1){
            return true;
        }
        return false;
    }
}
