package ExamAugust2020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[] tokens=scan.nextLine().split("");
            field[i]=tokens;
        }
        int beeRow=0;
        int beeCow=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (field[i][j].equals("B")){
                    beeRow=i;
                    beeCow=j;
                }
            }
        }
        int flowers=0;
        String command= scan.nextLine();
        while (!command.equals("End")){
            String letter="";
            switch (command){
                case "up":
                    if (!field[beeRow][beeCow].equals("O")){
                        field[beeRow][beeCow]=".";
                        beeRow--;
                    }

                    if (isInBounds(beeRow,size)){
                        letter=field[beeRow][beeCow];
                        if (letter.equals("f")){
                            flowers++;
                        }else if (letter.equals("O")){
                            field[beeRow][beeCow]=".";
                            beeRow--;
                            letter= field[beeRow][beeCow];
                            if (letter.equals("f")){
                                flowers++;
                            }
                        }
                    }else{
                        printIfLostMethod(flowers,field);
                        return;
                    }
                    break;
                case "down":
                    if (!field[beeRow][beeCow].equals("O")){
                        field[beeRow][beeCow]=".";
                        beeRow++;
                    }

                    if (isInBounds(beeRow,size)){
                        letter=field[beeRow][beeCow];
                        if (letter.equals("f")){
                            flowers++;
                        }else if (letter.equals("O")){
                            field[beeRow][beeCow]=".";
                            beeRow++;
                            letter= field[beeRow][beeCow];
                            if (letter.equals("f")){
                                flowers++;
                            }
                        }
                    }else{
                        printIfLostMethod(flowers,field);
                        return;
                    }
                    break;
                case "right":
                    if (!field[beeRow][beeCow].equals("O")){
                        field[beeRow][beeCow]=".";
                        beeCow++;
                    }

                    if (isInBounds(beeCow,size)){
                        letter=field[beeRow][beeCow];
                        if (letter.equals("f")){
                            flowers++;
                        }else if (letter.equals("O")){
                            field[beeRow][beeCow]=".";
                            beeCow++;
                            letter= field[beeRow][beeCow];
                            if (letter.equals("f")){
                                flowers++;
                            }
                        }
                    }else{
                        printIfLostMethod(flowers,field);
                        return;
                    }
                    break;
                case "left":
                    if (!field[beeRow][beeCow].equals("O")){
                        field[beeRow][beeCow]=".";
                        beeCow--;
                    }

                    if (isInBounds(beeCow,size)){
                        letter=field[beeRow][beeCow];
                        if (letter.equals("f")){
                            flowers++;
                        }else if (letter.equals("O")){
                            field[beeRow][beeCow]=".";
                            beeCow--;
                            letter= field[beeRow][beeCow];
                            if (letter.equals("f")){
                                flowers++;
                            }
                        }
                    }else{
                        printIfLostMethod(flowers,field);
                        return;
                    }
                    break;
            }
            if (field[beeRow][beeCow].equals("O")){

            }else{
                field[beeRow][beeCow]="B";
                command= scan.nextLine();
            }

        }
        if (flowers>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-flowers);
        }
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }
    }

    private static void printIfLostMethod(int flowers, String[][] field) {
        System.out.println("The bee got lost!");
        if (flowers>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more*n",5-flowers);
        }
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }
    }

    private static boolean isInBounds(int number, int size) {
        if (number>=0&&number<=size-1){
            return true;
        }
        return false;
    }
}
