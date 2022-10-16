package ExamDecember2021;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy=Integer.parseInt(scan.nextLine());
        int size=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][];
        for (int i = 0; i <size ; i++) {
            String[]line=scan.nextLine().split("");
            field[i]=line;
        }
        int pRow=-1;
        int pCow=-1;
        for (int row = 0; row < field.length; row++) {
            for (int cow = 0; cow < field[row].length-1; cow++) {
                if (field[row][cow].equals("P")){
                    pRow=row;
                    pCow=cow;
                }
            }
        }
        while (energy>0){
            String[] commands=scan.nextLine().split(" ");
            String command=commands[0];
            int sRow=Integer.parseInt(commands[1]);
            int sCow=Integer.parseInt(commands[2]);
            if (isInBoundariesRow(sRow,size)&&isInBoundariesRow(sCow,size)){
                field[sRow][sCow]="S";
            }
            field[pRow][pCow]="-";
            energy--;
            switch (command){
                case "up":
                    pRow--;
                    if (isInBoundariesRow(pRow,size)){
                        if (field[pRow][pCow].equals("S")){
                            energy-=2;
                        }else if (field[pRow][pCow].equals("H")){
                            field[pRow][pCow]="-";
                            winPrint(field,energy);
                            return;
                        }
                    }else{
                        pRow++;
                        field[pRow][pCow]="P";
                    }
                    break;
                case "down":
                    pRow++;
                    if (isInBoundariesRow(pRow,size)){
                        if (field[pRow][pCow].equals("S")){
                            energy-=2;
                        }else if (field[pRow][pCow].equals("H")){
                            field[pRow][pCow]="-";
                            winPrint(field,energy);
                            return;
                        }
                    }else{
                        pRow--;
                        field[pRow][pCow]="P";
                    }
                    break;
                case "right":
                    pCow++;
                    if (isInBoundariesRow(pCow,size)){
                        if (field[pRow][pCow].equals("S")){
                            energy-=2;
                        }else if (field[pRow][pCow].equals("H")){
                            field[pRow][pCow]="-";
                            winPrint(field,energy);
                            return;
                        }
                    }else{
                        pCow--;
                        field[pRow][pCow]="P";
                    }
                    break;
                case "left":
                    pCow--;
                    if (isInBoundariesRow(pCow,size)){
                        if (field[pRow][pCow].equals("S")){
                            energy-=2;
                        }else if (field[pRow][pCow].equals("H")){
                            field[pRow][pCow]="-";
                            winPrint(field,energy);
                            return;
                        }
                    }else{
                        pCow++;
                        field[pRow][pCow]="P";
                    }
                    break;
            }
        }
        field[pRow][pCow]="X";
        System.out.printf("Paris died at %d;%d.%n",pRow,pCow);
        printField(field);
    }
    private static void printField(String[][] field){
        for (String[] strings : field) {
            System.out.println(String.join("",strings));
        }
    }

    private static void winPrint(String[][] field, int energy) {
        System.out.println("Paris has successfully abducted Helen! Energy left: "+energy);
        printField(field);
    }

    private static boolean isInBoundariesRow(int n, int size) {
        if (n>=0&&n<=size-1){
            return true;
        }
        return false;
    }
}
